package com.report.config;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.report.entity.User;
import com.report.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	private final UserRepository userRepository;

	@Transactional
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String nickname = request.getParameter("username");
		String loginError = "로그인 실패";

		Optional<User> optUser = userRepository.findByUsername(nickname);

		if (optUser.isPresent()) {
			// user가 존재하는데 로그인 실패하는 경우
			User user = optUser.get();
			System.out.println(user);
			int failedAttempts = user.getFailedLoginAttempts();
			if (failedAttempts >= 5) {
				user.lockAccount();
				userRepository.save(user);
				loginError = "계정 잠김 (관리자에게 문의하세요)";
			} else {
				// 실패 횟수 증가
				user.setFailedLoginAttempts(user.getFailedLoginAttempts() + 1);
				User updatedUser = userRepository.save(user);
				loginError = "로그인 실패 : " + updatedUser.getFailedLoginAttempts();
			}
		} else {
			// 유저가 존재하지 않는 경우
			loginError = "존재하지 않는 사용자입니다";
		}
		// 로그인 실패 시 에러 메시지를 전달
		request.getSession().setAttribute("loginError", loginError);
		response.sendRedirect(request.getContextPath() + "/login");
	}
}
