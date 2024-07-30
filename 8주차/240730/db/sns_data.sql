-- SNS 데이터 베이스 구성하기
# 데이터 베이스 생성 (KOSTAGRAM)
# 테이블 (users, posts, followers, likes)
drop database if exists kostagram; -- 존재하면 지우기 (조건 추가 안하면 에러 발생)
create database kostagram default character set = 'utf8mb4';
use kostagram;

# users 테이블 
-- [id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100) NOT NULL UNIQUE, password VARCHAR(255) NOT NULL, 
--   bio(자기소개) TEXT (없어도 되므로 NULL값 가능), profile_pic VARCHAR(255) (기본 프로필이 있을수도 있으므로 NULL 가능), 
--   created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
--   update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, deleted_at(언제 탈퇴) DATETIME]
create table users (
	id INT auto_increment primary key,
	name VARCHAR(100),
	email VARCHAR(100) not null unique,
	password VARCHAR(255) not null,
	bio text,
	profile_pic varchar(255),
	created_at DATETIME default CURRENT_TIMESTAMP,
	update_at DATETIME default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	deleted_at DATETIME
);

# posts 테이블
-- [id INT AUTO_INCREMENT PRIMARY KEY, user_id, content, image, 
--   created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
--   update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, deleted_at DATETIME]
-- user_id는 users 테이블과 관계가 있다 (유저가 삭제되면, 게시물도 같이 삭제되도록)
create table posts (
	id INT auto_increment primary key,
	user_id INT not null,
	content TEXT,
	image VARCHAR(255) not null,
	created_at DATETIME default CURRENT_TIMESTAMP,
	update_at DATETIME default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	deleted_at DATETIME,
	foreign key(user_id) references users(id) on delete cascade
);

# likes 테이블
-- [id INT AUTO_INCREMENT PRIMARY KEY, user_id, post_id
--  created_at DATETIME DEFAULT CURRENT_TIMESTAMP, deleted_at DATETIME]
-- user_id는 users 테이블과 관계가 있다(참조한다는 의미, 유저가 삭제되면 좋아요도 같이 삭제되도록)
-- post_id는 posts 테이블과 관계가 있다(게시글이 삭제되면, 좋아요도 같이 삭제되도록)
-- 좋아요할 user_id와 post_id가 동일해야 하므로 unique key 추가
create table likes (
	id INT auto_increment primary key,
	user_id INT not null,
	post_id INT not null,
	created_at DATETIME default CURRENT_TIMESTAMP,
	deleted_at DATETIME,
	foreign key(user_id) references users(id) on delete cascade,
	foreign key(post_id) references posts(id) on delete cascade,
	unique key(user_id, post_id)
);

# follows 테이블
-- [id INT AUTO_INCREMENT PRIMARY KEY, following, followed
--  created_at DATETIME DEFAULT CURRENT_TIMESTAMP, deleted_at DATETIME]
-- users 테이블과 다대다 관계
-- following 아이디는 users 테이블과 관계가 있다 (유저가 삭제되면 같이 삭제)
-- followed 아이디는 users 테이블과  관계가 있다 (유저가 삭제되면, 같이 삭제)
create table follows (
	id INT auto_increment primary key,
	following_id INT not null,
	followed_id INt not null,
	created_at DATETIME default CURRENT_TIMESTAMP,
	deleted_at DATETIME,
	foreign key(following_id) references users(id) on delete cascade,
	foreign key(followed_id) references users(id) on delete cascade,
	unique key(following_id, followed_id)
);



# 데이터 삽입
insert into users (name, email, password) values 
	("류준열", "ryu@gmail.com", "1234"),
	("혜리", "hr@gmail.com", "1234"),
	("한소희", "hsh@gmail.com", "1234"),
	("최인규", "choi@gmail.com", "1234");

insert into posts (user_id, content, image) values 
	(2, "어이가 없네", "hr.jpg"),
	(3, "환승 아닙니다", "hsh.jpg");
	

# 데이터 조회
-- 사용자 목록 조회
select * from users where deleted_at is null;

-- 게시글 전체 조회
select p.*, u.name from posts p join users u on p.user_id = u.id where p.deleted_at is null;

-- 특정 사용자 게시글 조회
select p.*, u.name from posts p join users u on p.user_id = u.id where u.id = 3 and p.deleted_at is null;

-- 팔로우 하기
insert into follows (following_id, followed_id) values
	(1, 3) on duplicate key update deleted_at = null; -- 만약에 중복이면 업데이트(deleted_at = null, 언팔 취소)하라는 의미
select * from follows;

-- 언팔하기
update follows set deleted_at = now() where following_id = 2 and followed_id = 1 and deleted_at is null;
-- select f.id, ing.name `팔로우한`, ed.name `팔로우 당한` from follows f 
-- 	join users ing on ing.id = f.following_id 
-- 	join users ed on ed.id = f.followed_id
-- 	where f.deleted_at is null;

-- 특정 사용자가 특정 게시글 좋아요
insert into likes(user_id, post_id) values (4, 2) ON DUPLICATE KEY UPDATE deleted_at = NULL;
insert into likes(user_id, post_id) values (4, 1) ON DUPLICATE KEY UPDATE deleted_at = NULL;
select * from likes;

-- 특정 사용자가 특정 게시글 좋아요 취소
update likes set deleted_at = now() where user_id = 3 and post_id = 2 and deleted_at is null;
select * from likes where deleted_at is null;

-- 특정 사용자 팔로워 수, 팔로잉 수 조회
select (select count(*) from follows where following_id = 4 group by following_id) as "내가 팔로잉",
	(select count(*) from follows where followed_id = 4 group by followed_id) as "나를 팔로우";
-- 류준열 : 자기가 팔로우한 사람 = 한소희 (1명) / 팔로워 = 최인규 (1명)

-- 특정 사용자 팔로워 목록 조회
select u.id, u.name as `팔로워 목록` from follows f join users u on f.following_id = u.id 
	where f.followed_id = 3 and f.deleted_at is null;

select ing.* from follows f
	join users ing on f.following_id = ing.id
	join users ed on f.followed_id = ed.id
	where ed.id = 3;

-- 특정 사용자 팔로잉 목록 조회
select u.id, u.name as `팔로잉 목록` from follows f join users u on f.followed_id = u.id 
	where f.following_id = 1 and f.deleted_at is null;
	
select ed.* from follows f
	join users ing on f.following_id = ing.id
	join users ed on f.followed_id = ed.id
	where ing.id = 3;