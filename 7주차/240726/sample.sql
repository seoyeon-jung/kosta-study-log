-- study_db 생성
DROP DATABASE IF EXISTS `study_db`;
CREATE DATABASE study_db DEFAULT CHARACTER SET = 'utf8mb4' COLLATE = utf8mb4_0900_ai_ci;
-- 생성된 DB 선택
USE study_db;

-- 테이블 생성
DROP TABLE IF EXISTS `tCity`;
CREATE TABLE tCity (
	name CHAR(10) PRIMARY KEY,
	area INT NULL,
	popu INT NULL,
	metro CHAR(1) NOT NULL,
	region CHAR(6) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
-- 데이터 입력
INSERT INTO tCity VALUES
('서울', 605, 974, 'y', '서울'),
('부산', 765, 342, 'y', '경상'),
('오산', 42, 21, 'n', '경기'),
('청주', 940, 83, 'n', '충청'),
('전주', 205, 65, 'n', '전라'),
('순천', 910, 27, 'n', '전라'),
('춘천', 1116, 27, 'n', '강원'),
('홍천', 1819, 7, 'n', '강원');

-- 테이블 생성
DROP TABLE IF EXISTS `tStaff`;
CREATE TABLE tStaff (
	name CHAR (15) PRIMARY KEY,
	depart CHAR (10) NOT NULL,
	gender CHAR(3) NOT NULL,
	joindate DATE NOT NULL,
	grade CHAR(10) NOT NULL,
	salary INT NOT NULL,
	score DECIMAL(5, 2) NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
-- 데이터 입력
INSERT INTO tStaff VALUES
('김유신', '총무부', '남', '2000-2-3', '이사', 420, 88.8),
('유관순', '영업부', '여', '2009-3-1', '과장', 380, NULL),
('안중근', '인사과', '남', '2012-5-5', '대리', 256, 76.5),
('윤봉길', '영업부', '남', '2015-8-15', '과장', 350, 71.25),
('강감찬', '영업부', '남', '2018-10-9', '사원', 320, 56.0),
('정몽주', '총무부', '남', '2010-9-16', '대리', 370, 89.5),
('허난설헌', '인사과', '여', '2020-1-5', '사원', 285, 44.5),
('신사임당', '영업부', '여', '2013-6-19', '부장', 400, 92.0),
('성삼문', '영업부', '남', '2014-6-8', '대리', 285, 87.75),
('논개', '인사과', '여', '2010-9-16', '대리', 340, 46.2),
('황진이', '인사과', '여', '2012-5-5', '사원', 275, 52.5),
('이율곡', '총무부', '남', '2016-3-8', '과장', 385, 65.4),
('이사부', '총무부', '남', '2000-2-3', '대리', 375, 50),
('안창호', '영업부', '남', '2015-8-15', '사원', 370, 74.2),
('을지문덕', '영업부', '남', '2019-6-29', '사원', 330, NULL),
('정약용', '총무부', '남', '2020-3-14', '과장', 380, 69.8),
('홍길동', '인사과', '남', '2019-8-8', '차장', 380, 77.7),
('대조영', '총무부', '남', '2020-7-7', '차장', 290, 49.9),
('장보고', '인사과', '남', '2005-4-1', '부장', 440, 58.3),
('선덕여왕', '인사과', '여', '2017-8-3', '사원', 315, 45.1);
-- 테이블 생성
DROP TABLE IF EXISTS `DEPT`;
CREATE TABLE DEPT(
	DEPTNO INT(2),
	DNAME VARCHAR(14),
	LOC VARCHAR(13),
	CONSTRAINT PK_DEPT PRIMARY KEY(DEPTNO)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
-- 테이블 생성
DROP TABLE IF EXISTS `EMP`;
CREATE TABLE EMP(
	EMPNO INT(4),
	ENAME VARCHAR(10),
	JOB VARCHAR(9),
	MGR INT(4),
	HIREDATE DATE,
	SAL FLOAT(7, 2),
	COMM FLOAT(7, 2),
	DEPTNO INT(2),
	CONSTRAINT PK_EMP PRIMARY KEY(EMPNO),
	CONSTRAINT FK_DEPTNO FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
-- 데이터 입력
INSERT INTO DEPT
VALUES(10, 'ACCOUNTING', 'NEW YORK'),
	(20, 'RESEARCH', 'DALLAS'),
	(30, 'SALES', 'CHICAGO'),
	(40, 'OPERATIONS', 'BOSTON');
-- 데이터 입력
INSERT INTO EMP VALUES
(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-2-20', 1600, 300, 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981-2-22', 1250, 500, 30),
(7566, 'JONES', 'MANAGER', 7839, '1981-4-2', 2975, NULL, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-9-28', 1250, 1400, 30),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-5-1', 2850, NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-6-9', 2450, NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1987-7-13', 3000, NULL, 20),
(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-9-8', 1500, 0, 30),
(7876, 'ADAMS', 'CLERK', 7788, '1987-7-13', 1100, NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-3', 950, NULL, 30),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-3', 3000, NULL, 20),
(7934, 'MILLER', 'CLERK', 7782, '1982-1-23', 1300, NULL, 10);

-- 테이블 생성
DROP TABLE IF EXISTS `SALGRADE`;
CREATE TABLE SALGRADE (GRADE INT, LOSAL INT, HISAL INT) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- 데이터 입력
INSERT INTO SALGRADE VALUES
(1, 700, 1200),
(2, 1201, 1400),
(3, 1401, 2000),
(4, 2001, 3000),
(5, 3001, 9999);

-- 테이블 생성
DROP TABLE IF EXISTS `usertbl`;
CREATE TABLE usertbl(
	userid CHAR(15) NOT NULL PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	birthyear INT NOT NULL,
	addr CHAR(100),
	mobile CHAR(11),
	mdate DATE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- 테이블 생성
DROP TABLE IF EXISTS `buytbl`;
CREATE TABLE buytbl(
	num INT AUTO_INCREMENT PRIMARY KEY,
	userid CHAR(8) NOT NULL,
	productname CHAR(10),
	groupname CHAR(10),
	price INT NOT NULL,
	amount INT NOT NULL,
	FOREIGN KEY (userid) REFERENCES usertbl(userid) ON DELETE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- 데이터 삽입
INSERT INTO usertbl VALUES
( 'kty', '김태연', 1989, '전주', '01011111111', '1989-3-9'),
('bsj', '배수지', 1994, '광주', '01022222222', '1994-10-10'),
('ksh', '김설현', 1995, '부천', '01033333333', '1995-1-3'),
('bjh', '배주현', 1991, '대구', '01044444444', '1991-3-29'),
('ghr', '구하라', 1991, '광주', '01055555555', '1991-1-13'),
('san', '산다라박', 1984, '부산', '01066666666', '1984-11-12'),
('jsm', '전소미', 2001, '캐나다', '01077777777', '2001-3-9'),
('lhl', '이효리', 1979, '서울', '01088888888', '1979-5-10'),
('iyou', '아이유', 1993, '서울', '01099999999', '1993-5-19'),
('ailee', '에일리', 1989, '미국', '01000000000', '1989-5-30');

-- 데이터 삽입
INSERT INTO buytbl VALUES
(NULL, 'kty', '운동화', '잡화', 30, 2),
(NULL, 'kty', '노트북', '전자', 1000, 1),
(NULL, 'jsm', '운동화', '잡화', 30, 1),
(NULL, 'lhl', '모니터', '전자', 200, 1),
(NULL, 'bsj', '모니터', '전자', 200, 1),
(NULL, 'kty', '청바지', '잡화', 100, 1),
(NULL, 'lhl', '책', '서적', 15, 2),
(NULL, 'iyou', '책', '서적', 15, 7),
(NULL, 'iyou', '컴퓨터', '전자', 500, 1),
(NULL, 'bsj', '노트북', '전자', 1000, 1),
(NULL, 'bjh', '메모리', '전자', 50, 4),
(NULL, 'ailee', '운동화', '잡화', 30, 2),
(NULL, 'ghr', '운동화', '잡화', 30, 1);

-- 테이블 생성
DROP TABLE IF EXISTS `logic_operation`;
CREATE TABLE `logic_operation` (
	`a` INT NOT NULL,
	`b` INT NOT NULL,
	`and` VARCHAR(6) NULL,
	`or` VARCHAR(6) NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
-- 데이터 입력
INSERT INTO `logic_operation` VALUES
(0, 0, NULL, NULL),
(0, 1, NULL, 'OR 부합'),
(1, 0, NULL, 'OR 부합'),
(1, 1, 'AND 부합', 'OR 부합');

-- 테이블 생성
DROP TABLE IF EXISTS `promotion_tbl`;
CREATE TABLE promotion_tbl (
	id INT AUTO_INCREMENT PRIMARY KEY,
	product_name VARCHAR(50),
	promotion_msg VARCHAR(100)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- 데이터 입력
INSERT INTO promotion_tbl (product_name, promotion_msg) VALUES
('Product A', '10% discount'),
('Product B', '20% off only 30 items'),
('Product C', 'Buy one get one 50% off'),
('Product D', 'Limited time offer: up to 30% discount');



-- 테이블 생성
DROP TABLE IF EXISTS `tcar`;
CREATE TABLE tcar (
	car VARCHAR(30) NOT NULL, -- 이름
	capacity INT NOT NULL, -- 배기량
	price INT NOT NULL, -- 가격
	maker VARCHAR(30) NOT NULL -- 제조사
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- 데이터 입력
INSERT INTO tcar (car, capacity, price, maker) VALUES
('소나타', 2000, 2500, '현대'),
('그랜저', 2500, 3500, '현대'),
('티볼리', 1600, 2300, '쌍용'),
('코란도', 1800, 3000, '쌍용'),
('A8', 3000, 4800, 'Audi'),
('SM5', 2000, 2600, '삼성');

-- 테이블 생성
DROP TABLE IF EXISTS `tmaker`;
CREATE TABLE tmaker (
	maker VARCHAR(30) NOT NULL, -- 회사
	factory CHAR(10) NOT NULL, -- 공장
	domestic CHAR(1) NOT NULL -- 국산 여부. Y/N
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- 데이터 입력
INSERT INTO tmaker (maker, factory, domestic) VALUES
('현대', '부산', 'y'),
('쌍용', '청주', 'y'),
('Audi', '독일', 'n'),
('기아', '서울', 'y');