## 목차
- [회원 관리 시스템 \[백엔드\]](#회원-관리-시스템-백엔드)
  - [controller 추가](#controller-추가)
  - [Service 추가](#service-추가)
  - [request 클래스 생성](#request-클래스-생성)
    - [SignUpRequest](#signuprequest)
    - [UserListRequest](#userlistrequest)
    - [UpdateuserRequest](#updateuserrequest)
  - [이메일 중복 여부 체크](#이메일-중복-여부-체크)
    - [controller](#controller)
    - [service](#service)
    - [repository에 추가](#repository에-추가)

<br/>
<br/>
<br/>
<br/>

# 회원 관리 시스템 [백엔드]
## controller 추가
```java
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	// userService
	private final UserService userService;

	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<UserResponse> signUp(@RequestBody SignUpRequest user) {
		UserResponse joinUser = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(joinUser);
	}

	// 회원 전체 리스트
	@GetMapping("/userlist")
	public ResponseEntity<List<UserResponse>> getUserList() {
		List<UserResponse> userList = userService.getAllUser();
		return ResponseEntity.ok(userList);
	}

	// 회원 정보 수정
	@PatchMapping("/update")
	public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest user) {
		UserResponse updatedUser = userService.updateUserInfo(user);
		return ResponseEntity.ok(updatedUser);
	}

	// 회원 정보 삭제
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<UserResponse> userWithdrawal(@PathVariable("id") Long id) {
		UserResponse user = userService.deleteUserById(id);
		return ResponseEntity.ok(user);
	}

	// 예외 처리
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handlePostException(RuntimeException e, HttpServletRequest req) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ErrorResponse.builder().statusCode(HttpStatus.BAD_REQUEST.value()).message("유저 관련 에러 발생")
						.url(req.getRequestURI()).details(e.getMessage()).build());
	}

}
```

<br/>
<br/>

## Service 추가
```java
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public UserResponse addUser(SignUpRequest user) {
		User newUser = User.builder().email(user.getEmail()).name(user.getName()).password(user.getPassword()).build();
		User joinedUser = userRepository.save(newUser);

		return UserResponse.toDTO(joinedUser);
	}

	@Override
	public List<UserResponse> getAllUser() {
		List<User> userList = userRepository.findAll();

		if (userList.size() > 0) {
			List<UserResponse> result = userList.stream().map(UserResponse::toDTO).toList();
			return result;
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public UserResponse deleteUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없음"));

		userRepository.deleteById(id);
		return UserResponse.toDTO(user);
	}

	@Override
	public UserResponse updateUserInfo(UpdateUserRequest userDTO) {
		User user = userRepository.findByEmail(userDTO.getEmail())
				.orElseThrow(() -> new IllegalArgumentException("회원 정보 조회에 실패했습니다. [없는 이메일]"));

		if (!user.getPassword().equals(userDTO.getPassword())) {
			throw new RuntimeException("비밀번호 입력 오류");
		}

		if (userDTO.getName() != null)
			user.setName(userDTO.getName());
		User updatedUser = userRepository.save(user);

		return UserResponse.toDTO(updatedUser);
	}

}
```

<br/>
<br/>

## request 클래스 생성
### SignUpRequest
```java
@Data
@Builder
@NoArgsConstructor
public class SignUpRequest {
	private String email;
	private String name;
	private String password;

	@Builder
	public SignUpRequest(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
}
```
- 회원가입 할 때는 email, name, password만 필요하다.
### UserListRequest
```java
@Data
@Builder
@NoArgsConstructor
public class UserListResquest {
	private Long id;
	private String email;
	private String name;

	public UserListResquest(Long id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}

}
```
- 회원 전체 리스트를 불러올 때는 id, email, name만 불러오면 된다.
### UpdateuserRequest
```java
@Getter
@ToString
public class UpdateUserRequest {
	private String email;
	private String name;
	private String password;
}
```
- email은 unique(고유값)이므로 수정이 불가능하도록 제한한다.
- 회원 정보 중 name만 수정 가능하다.

<br/>
<br/>

## 이메일 중복 여부 체크
### controller
```java
	// 이메일 중복 체크
	@GetMapping("/duplicate")
	public ResponseEntity<Boolean> emailCheck(@RequestBody Map<String, String> emailMap) {
		// key와 value로 email을 가져와서 체크할 수 있다
		boolean isNotDuplicate = userService.duplicateCheckEmail(emailMap.get("email"));
		return ResponseEntity.ok(isNotDuplicate);
	}
```
### service
```java
	@Override
	public boolean duplicateCheckEmail(String email) {
		return userRepository.existsByEmail(email);
	}
```
### repository에 추가
```java
boolean existsByEmail(String email);
```