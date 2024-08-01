# [실습] Kostagram
## 구조 분석해보기
### `com.kosta.controller`
`KostagramExample.java`
- main 메소드로 실제로 동작하는 곳
### `com.kosta.util`
- `utility 클래스` : 반복적으로 사용해야 될 동작(기능)을 별도의 클래스로 만들어 놓고 필요할 때 사용하는 클래스
- kostagram에서는 DB 연동 관련 클래스를 넣어서 사용하고 있다.

### `com.kosta.dao`
- DAO (Data Access Object)
  - 데이터베이스에 접근하는 클래스이다.
  - DB를 연동하여 SQL문을 이용해 CRUD와 관련한 로직을 작성한다.
- Kostagram에서는 `userDAO`를 통해 user 관련해서 필요한 로직을 작성하였다.

### `com.kosta.service`
- Service : 비지니스 로직 수행
- Kostagram에서는 비지니스 로직을 작성하고, dao 인스턴스를 생성해 DB와 연동하여 로직을 작성한다.

### `com.kosta.model`
- Kostagram에서 필요한 User 클래스를 만들었다.
  - getter, setter, 생성자를 lombok을 사용하여 만들었다.
- [예시]
  ```java
  	// 회원 전체 목록 가져오기
	public void printAllusers() throws Exception {
		System.out.println("\n ---------- 회원 전체를 출력합니다 ----------");

		// DB에서 회원 전체 목록을 리스트로 가져오기
		List<User> userList = userDAO.getUserList();

		// id와 이름을 출력
		System.out.println("ID \t 이름");
		for (User user : userList) {
			System.out.println(user.getId() + "\t" + user.getName());
		}
	}
    ```