# Movie Project
## 데이터베이스 movie_db
### table movie
- id
- title [영화 제목]
- summary [줄거리]
- gerne [장르]
- director [감독]
- actors [출연진] -> 정규화가 필요한 데이터 (나중에)
- poster [포스터 - image]
- release [개봉일]

<br/>
<br/>
<br/>

## 보여줄 페이지
[메인 - 영화 리스트] movieList.jsp
- 포스터, 영화 제목, 개봉일 로 리스트 출력
[개별 영화 정보] movie.jsp
- 포스터
- 영화 제목
- 줄거리
- 개봉일
- 감독 / 출연진

<br/>
<br/>
<br/>

## 프로젝트 구조
### com.movie.controller
- MovieController [Interface]
- ListController
	- 영화 리스트 보여줄 때 사용하는 controller
- ViewController
	- 개별 영화 정보를 보여줄 때 사용하는 controller
- MovieServlet

### com.movie.dao [DB에 접근해서 CRUD 구현]
- MovieDAO [Interface]
- MovieDAOImpl [실제 동작하는 메소드들을 구현]
	- sql문을 작성하고 DB에 접근하여 CRUD 구현
	- 영화 리스트 전체보기
	- 영화 추가
	- 개별 영화 보기
	- 영화 삭제
	- 영화 정보 수정

### com.movie.model
- Moive [영화 객체]
	- int id
	- String title, summay, genre, director, actors, poster
	- date
	- (필요하면) 생성자 추가

### com.movie.service
- MovieService [Interface]
- MovieServiceImpl
	- 영화 리스트 전체보기
	- 영화 추가
	- 개별 영화 보기
	- 영화 삭제
	- 영화 정보 수정

### com.movie.util
- ConnetionPool
	- DB와 연동

