package com.report.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.report.domain.Role;
import com.report.entity.Report;
import com.report.entity.User;
import com.report.repository.ReportRepository;
import com.report.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	private final UserRepository userRepository;
	private final ReportRepository reportRepository;

	// 관리자 페이지에 전체 유저 리스트 가져오기
	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	// 관리자 페이지에서 유저 탈퇴시키기
	@Override
	public void deleteUserById(Long id) throws Exception {
		userRepository.deleteById(id);
	}

	// 관리자 페이지에서 유저 정보를 id 통해서 가져오기
	@Override
	public User findUserById(Long id) throws Exception {
		User user = userRepository.findById(id).orElseThrow(() -> new Exception("ID가 존재하지 않습니다"));
		return user;
	}

	// 관리자가 유저 정보(grade, point, 잠금여부) 관리하기
	@Override
	public User updateUserByAdmin(User user) throws Exception {
		User originUser = findUserById(user.getId());

		originUser.setPoint(user.getPoint());
		originUser.setGrade(user.getGrade());

		originUser.setLocked(user.getLocked());
		originUser.setFailedLoginAttempts(user.getLocked() == true ? 0 : user.getFailedLoginAttempts());

		User updatedUser = userRepository.save(originUser);
		return updatedUser;
	}

	// 관리자 페이지에 전체 글 리스트 가져오기
	@Override
	public List<Report> findAllReport() {
		return reportRepository.findAll();
	}

	// 관리자 페이지에서 글 임의로 삭제하기
	@Override
	public void deleteReportById(Long id, User user) throws Exception {
		Role userRole = user.getRole();

		// 관리자(ADMIN)인 경우 삭제 가능
		if (userRole == Role.ADMIN) {
			reportRepository.deleteById(id);
		} else {
			throw new Exception("관리자인 경우에만 삭제할 수 있습니다.");
		}
	}

}
