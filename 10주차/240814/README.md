# spring 실습
## 1. DB 생성
```sql
CREATE DATABASE mybatis_proj_db DEFAULT CHARACTER SET = 'utf8mb4' COLLATE = 'utf8mb4_0900_ai_ci';

use mybatis_proj_db;

create table users_tbl (
	id INT auto_increment primary key comment '사용자 번호',
	name VARCHAR(50) not null comment '사용자 이름',
	email VARCHAR(100) unique not null comment '사용자 이메일',
	created_at DATETIME default current_timestamp comment '사용자 가입일',
	deleted_at CHAR(1) not null default 'n' comment '사용자 삭제 여부'
);

create table movie_tbl (
	id INT NOT NULL PRIMARY KEY auto_increment comment '영화 번호',
	title VARCHAR(255) not null comment '영화 제목',
	release_date Date not null comment '영화 개봉일',
	genre VARCHAR(255) not null comment '영화 장르',
	director VARCHAR(255) not null comment '영화 감독',
	summary VARCHAR(10000) not null comment '영화 줄거리',
	user_id int not null comment '작성자',
	foreign key(user_id) references users_tbl(id)
);

CREATE TABLE file_tbl (
        id INT PRIMARY KEY AUTO_INCREMENT COMMENT '파일 번호',
        movie_id INT NOT NULL COMMENT '영화 번호',
        origin_file_name VARCHAR(255) NOT NULL COMMENT '원본 파일명',
        stored_file_path VARCHAR(255) NOT NULL COMMENT '파일 저장 경로',
        file_size INT NOT NULL COMMENT '파일 크기',
        foreign key(movie_id) references movie_tbl(id)
);
```
- `users_tbl` : user를 관리하는 테이블
- `movie_tbl` : movie 글을 관리하는 테이블
- `file_tbl` : movie 글을 작성할 때, 첨부하는 이미지들을 관리하는 테이블