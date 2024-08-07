# 미니 프로젝트 - 영화 sql문

```sql
-- movie_db 생성
DROP DATABASE IF EXISTS `movie_db`;
CREATE DATABASE movie_db DEFAULT CHARACTER SET = 'utf8mb4' COLLATE = utf8mb4_0900_ai_ci;

-- 생성된 DB 선택
USE movie_db;

-- table 생성
create table movie (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(255) not null,
	summary VARCHAR(255) not null,
	gerne VARCHAR(255) not null,
	director VARCHAR(255) not null,
	actors VARCHAR(255) not null,
	poster VARCHAR(255) not null,
	release_date Date not null
);
```