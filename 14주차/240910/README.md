## 목차
- [로그인 로직 수정](#로그인-로직-수정)
  - [`LoginCustomAuthenticationFilter` 파일 생성](#logincustomauthenticationfilter-파일-생성)
  - [로그인 로직 삭제](#로그인-로직-삭제)
  - [JwtAuthenticationService 파일 생성](#jwtauthenticationservice-파일-생성)
  - [`TokenUtils` 생성](#tokenutils-생성)
  - [`WebSecurityConfig` 파일 수정](#websecurityconfig-파일-수정)
  - [로그 확인](#로그-확인)
  - [Postman으로 로그인 확인](#postman으로-로그인-확인)
  - [리액트 연동을 위해 `WebSecurityConfig` 파일 수정](#리액트-연동을-위해-websecurityconfig-파일-수정)
- [토큰 저장하기 \[프론트\]](#토큰-저장하기-프론트)
  - [`api.js` 수정](#apijs-수정)

<br/>
<br/>
<br/>
<br/>

# 로그인 로직 수정
## `LoginCustomAuthenticationFilter` 파일 생성
```java
@Slf4j
public class LoginCustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	private JwtAuthenticationService jwtAuthenticationService;
	private static final AntPathRequestMatcher LOGIN_PATH = new AntPathRequestMatcher("/api/auth/login", "POST");

	protected LoginCustomAuthenticationFilter(AuthenticationManager authenticationManager,
			JwtAuthenticationService jwtAuthenticationService) {
		super(LOGIN_PATH);
		setAuthenticationManager(authenticationManager);
		this.jwtAuthenticationService = jwtAuthenticationService;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		// POST '/api/auth/login'에 요청이 들어오면 진행되는 곳

		// 1. Body에 있는 로그인 정보 { email: "", password: "" } 가져오기
		LoginRequest loginRequest = null;
		try {
			log.info("[attemptAuthentication] 로그인 정보 가져오기");
			ObjectMapper objectMapper = new ObjectMapper();
			loginRequest = objectMapper.readValue(request.getInputStream(), LoginRequest.class);
		} catch (IOException e) {
			throw new RuntimeException("로그인 요청 파라미터 이름 확인 필요 (로그인 불가)");
		}

		// 2. email, password를 기반으로 AuthenticationToken 생성
		log.info("[attemptAuthentication] Authentication 생성");
		UsernamePasswordAuthenticationToken uPAToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
				loginRequest.getPassword());

		// 3. 인증 시작
		// (AuthenticationManager이 authentication 메소드가 동작할 때 >> loadUserByUsername 실행)
		log.info("[attemptAuthentication] 인증 시작");
		Authentication authenticate = getAuthenticationManager().authenticate(uPAToken);

		return authenticate;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		log.info("[successfulAuthentication] 로그인 성공 > 토큰 생성");
		jwtAuthenticationService.successAuthentication(response, authResult);
	}

}
```
## 로그인 로직 삭제
- `AuthController`에서 로그인 로직 삭제
- `UserService`, `UserServiceImpl`에서 로그인 로직 삭제
## JwtAuthenticationService 파일 생성
```java
// 인증 관련 서비스 진행
@Service
@RequiredArgsConstructor
public class JwtAuthenticationService {
	private final TokenUtils tokenUtils;

	void successAuthentication(HttpServletResponse response, Authentication authResult) throws IOException {
		User user = (User) authResult.getPrincipal(); // authResult의 유저 정보 가져오기

		// tokenUtils에 user 넣어서 토큰 생성
		Map<String, String> tokenMap = tokenUtils.generateToken(user);
		String accessToken = tokenMap.get("accessToken");

		// loginRespnse에 token 담아서 응답
		LoginResponse loginResponse = LoginResponse.builder().accessToken(accessToken).build();

		tokenUtils.writeResponse(response, loginResponse);

	}

}
```
## `TokenUtils` 생성
```java
// token과 관련
@Component
@RequiredArgsConstructor
public class TokenUtils {
	private final JwtProvider jwtProvider;

	// token 생성
	public Map<String, String> generateToken(User user) {
		String accessToken = jwtProvider.generateAccessToken(user);

		Map<String, String> tokenMap = new HashMap<String, String>();
		tokenMap.put("accessToken", accessToken);
		return tokenMap;
	}

	// JSON 응답 전송
	public void writeResponse(HttpServletResponse response, LoginResponse loginResponse) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = objectMapper.writeValueAsString(loginResponse);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonResponse);
	}
}
```
## `WebSecurityConfig` 파일 수정
```java
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	private final UserDetailsService userDetailsService;
	private final JwtProperties jwtProperties;

	// JWT PROVIDER bean 생성
	@Bean
	JwtProvider jwtProvider() {
		return new JwtProvider(jwtProperties, userDetailsService);
	};

	private TokenUtils tokenUtils() {
		return new TokenUtils(jwtProvider());
	}

	private JwtAuthenticationService jwtAuthenticationService() {
		return new JwtAuthenticationService(tokenUtils());
	}

	// 인증 관리자 (Authenticaiton Manager) 설정
	@Bean
	AuthenticationManager authenticationManager() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(bCryptPasswordEncoder());

		return new ProviderManager(authProvider);
	}

	// 암호화 빈
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// HTTP 요청에 따른 보안 구현
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 경로에 대한 권한 설정
		http.authorizeHttpRequests(auth ->
		// 특정 URL 경로에 대해서는 인증 없이 접근 가능
		auth.requestMatchers(
				// 로그인 관련 로직은 LoginCustomAuthenticationFilter에 존재
				new AntPathRequestMatcher("/api/auth/signup"), // 회원가입
				new AntPathRequestMatcher("/api/auth/duplicate") // email 중복 체크
		).permitAll()
				// AuthController 중 나머지는 ADMIN만 접근 가능한 페이지
				.requestMatchers(new AntPathRequestMatcher("/api/auth")).hasRole("ADMIN")
				// 그 밖의 다른 요청들은 인증을 통과한 사용자라면(=로그인한 사용자) 접근 가능
				.anyRequest().authenticated());

		// session 관리는 이제 더 이상 하지 않는다
		// 무상태성 세션 관리
		http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// 특정 경로(로그인)에 대한 필터 추가
		http.addFilterBefore(new LoginCustomAuthenticationFilter(authenticationManager(), jwtAuthenticationService()),
				UsernamePasswordAuthenticationFilter.class);

		// (토큰을 통해 검증할 수 있도록) filter 추가
		// http.addFilterBefore(추가할 필터, 다른필터)
		// jwt 인증 필터를 추가
		http.addFilterBefore(new JwtAuthenticationFilter(jwtProvider()), UsernamePasswordAuthenticationFilter.class);

		// HTTP 기본 설정
		http.httpBasic(HttpBasicConfigurer::disable);

		// CSRF 비활성화
		http.csrf(AbstractHttpConfigurer::disable);

		// CORS 비활성화
		http.cors(AbstractHttpConfigurer::disable);

		return http.getOrBuild();
	}
}
```
## 로그 확인
![alt text](image.png)
## Postman으로 로그인 확인
![alt text](image-1.png)

- 전체 글 조회도 확인
![alt text](image-2.png)
## 리액트 연동을 위해 `WebSecurityConfig` 파일 수정
```java
...
		// CORS 비활성화
		http.cors(corsConfig -> corsConfig.configurationSource(corsConfigurationSource()));

		return http.getOrBuild();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		return request -> {
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowedHeaders(Collections.singletonList("*"));
			config.setAllowedMethods(Collections.singletonList("*"));
			config.setAllowedOriginPatterns(Collections.singletonList("http://localhost:3000"));
			config.setAllowCredentials(true);
			return config;
		};
	}
}
```

<br/>
<br/>
<br/>
<br/>

# 토큰 저장하기 [프론트]
## `api.js` 수정
```javascript
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    } else {
      delete config.headers.Authorization;
    }
    return config;
  },
  (err) => {
    return Promise.reject(err);
  }
);
```
![alt text](image-3.png)