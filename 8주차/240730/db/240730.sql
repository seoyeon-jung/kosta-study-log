use study_db;

# 테이블 생성
CREATE TABLE contact(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    addr VARCHAR(255),
    tel VARCHAR(20),
    email VARCHAR(255),
    birthday DATE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

# 테이블에 컬럼 추가
ALTER TABLE contact ADD COLUMN age INT;
# 테이블 확인
DESC contact;

# 테이블에 컬럼 삭제
ALTER TABLe contact DROP age;
DESC contact;

# 테이블의 기존 컬럼 자료형과 이름 변경
ALTER TABLe contact CHANGE tel phone INT;
DESC contact;

# 다시 원래대로
ALTER TABLE contact CHANGE phone tel VARCHAR(20);
DESC contact;

# 테이블의 기존 컬럼 자료형만 변경
ALTER TABLE contact MODIFY tel VARCHAr(255);
DESC contact;

# 테이블의 컬럼 순서 조정
ALTER TABLE contact MODIFY COLUMN email VARCHAR(255) AFTER name;

# 테이블 삭제
-- DROP TABLE contact;

# 데이터베이스 내부 테이블 확인
SHOW TABLES;

SELECT * FROM students;
INSERT INTO students VALUES
	(null, '정서연', '2000-12-10', '서울', 'ISTJ'),
    (null, '권지훈', '2000-01-31', '서울', 'INTJ'),
    (null, '한민혁', '2000-09-29', '인천', 'ESFP');

INSERT INTO students (name, birthday, address, mbti) VALUES 
	('박진국', '2000-08-21', '서울', 'INFP'),
    ('성제현', '2000-12-05', '대구', 'ENFP');

SELECT * FROM students;

# enum 타입 데이터 타입 추가
ALTER TABLE students ADD COLUMN gender ENUM('남', '여');
DESC students;
SELECT * FROM students;


CREATE TABLE tNullable (
	name CHAR(10) NOT NULL, # NULL이 아니다
    age INT # NULL
);
INSERT INTO tNullable (name, age) VALUES ("흥부", 36);
INSERT INTO tNullable (name, age) VALUES ("놀부");
-- INSERT INTO tNullable (name, age) VALUES (44);
-- Column count doesn't match value count at row 1 (null이므로 INSERT 오류가 난다)

# 기본값 설정
CREATE TABLE tCityDefault(
	name CHAR(10) PRIMARY KEY,
    area INT NOT NULL DEFAULT 0,
    popu INT NOT NULL DEFAULT 0,
    metro ENUM('y', 'n') NOT NULL DEFAULT 'n',
    region CHAR(6) NULL
);

INSERT INTO tCityDefault (name, area, popu, region) VALUES ('전주', 712, 34, '경상');
INSERT INTO tCityDefault VALUES ('인전', 1063, 295, 'y', '경기');
INSERT INTO tCityDefault VALUES ('강릉', 131, 24, DEFAULT, '강원');
INSERT INTO tCityDefault (name) VALUES ('군산'); -- 알아서 기본값으로 잘 들어간다.

SELECT * FROm tcitydefault;


CREATE TABLE tCheck (
	gender CHAR(3) CHECK(gender = '남' or gender = '여'),
    grade INT CHECK(grade BETWEEN 1 AND 3),
    origin CHAR(3) CHECK(origin IN ('동', '서', '남', '북')),
    name CHAR(12) CHECK(name LIKE '김%')
);

-- INSERT INTO tCheck VALUES ('남자', 4, '동서', '최인규'); -- check 조건에 맞지 않으므로 insert되지 않는다.
INSERT INTO tCheck VALUES ('남', 3, '동', '김인규');


-- tStaffDefault 테이블 생성 (각 필드에 기본값을 지정하고, 각 필드에 제약 조건을 설정)
-- 기본값 : (부서는 영업부, 직급은 수습, 월급은 280, 성취도는 1.0 으로 기본값을 적용)
-- 제약조건 : (부서는 영업부, 총무부, 인사과 중 하나만, 성별은 남 또는 여, 월급은 0 보다 크다는 조건 설정) 
CREATE TABLE tStaffDefault (
	name CHAR(15) PRIMARY KEY,
	depart ENUM("영업부", "총무부", "인사과") NOT NULL DEFAULT "영업부",
    gender ENUM("남", "여"),
    joindate DATE NOT NULL DEFAULT(CURDATE()),
    grade CHAR(10) NOT NULL DEFAULT "수습",
    salary INT NOT NULL DEFAULT 280 CHECK(salary > 0),
    score DECIMAL(5, 2) NOT NULL DEFAULT 1.0
);
INSERT INTO tStaffDefault (name, gender) VALUES("최인규", "남");
SELECT * FROM tStaffDefault;


# 슈퍼키 - 레코드를 유일하게 만드는 속성들의 조합 (1개 이상)
# 후보키 - 슈퍼키 중 속성의 개수를 최소화한 것들
# 기본키 - 후보키 중에서 지정한 키 (테이블에 오직 1개의 키 _ 복합키 가능)

-- 이름과 부서와 성별을 복합키로 지정하여
-- 새로운 직원 테이블 tStaffCompany를 생성 (tStaff 테이블과 구성 동일)
CREATE TABLE tStaffCompany(
	name CHAR(15),
    depart ENUM("영업부", "총무부", "인사과") NOT NULL DEFAULT "영업부",
    gender ENUM("남", "여"),
    joindate DATE NOT NULL DEFAULT(CURDATE()),
    grade CHAR(10) NOT NULL DEFAULT "수습",
    salary INT NOT NULL DEFAULT 280 CHECK(salary > 0),
    score DECIMAL(5, 2) NOT NULL DEFAULT 1.0,
    CONSTRAINT ck_pk PRIMARY KEY(name, depart, gender) -- name, deaprt, gender를 primary key롯 생성하겠다는 제약조건
);



CREATE TABLE tPrimary (
	isLongHair boolean CHECK(isLongHair IN(1, 0)),
    isGlasses boolean CHECK(isGlasses IN(1, 0)),
    gender ENUM('남', '여'),
    CONSTRAINT ct_pk PRIMARY KEY(isLongHair, isGlasses, gender)
);
INSERT INTO tPrimary VALUES 
	(0, 0, '여'), (0, 0, '남'), (0, 1, '여'), (0, 1, '남'), (1, 0, '여'), (1, 0, '남'), (1, 0,'여'), (1, 1, '남'), (1, 1, '여');
    



CREATE TABLE tSale (
	saleno INT AUTO_INCREMENT PRIMARY KEY,
    customer VARCHAR(10),
    product VARCHAR(30)
);

INSERT INTO tSale (customer, product) VALUES ("단군", "지팡이"), ("고주몽", "고등어");
SELECT * FROM tSale;
DELETE FROM tSale WHERE saleno = 2;
INSERT INTO tSale (customer, product) VALUES ("박혁거세", "계란"); -- saleno = 3번으로 들어간다
ALTER TABLe tSale AUTO_INCREMENT = 1;
INSERT INTO tSale  (customer, product) VALUES ("고주몽", "고등어"); -- 가장 높은 순서(4)+1 로 들어간다

ALTER TABLE tSale AUTO_INCREMENT = 1000;
INSERT INTO tSale (customer, product) VALUES ("왕건", "너구리");

SELECT LAST_INSERT_ID();
UPDATE tSale SET product="짜파게티" WHERE saleno = LAST_INSERT_ID();


# 참주 무결성 example (외래키 미설정)
CREATE TABLe tEmployee (
	name CHAR(10) PRIMARY KEY,
    salary INT NOT NULL,
    addr VARCHAR(30) NOT NULL
);
INSERT INTO tEmployee VALUES
	("아이린", 650, "대구"),
    ("슬기", 480, "안산"),
    ("웬디", 625, "서울");
SELECT * FROM tEmployee;

CREATE TABLE tProject(
	projectID INT PRIMARY KEY,
    employee CHAR(10) NOT NULL,
    proejct VARCHAR(30) NOT NULL,
    cost INT
);
INSERT INTO tProject VALUES
	(1, "아이린", "홍콩 수출건", 800),
    (2, "아이린", "TV 광고건", 3400),
    (3, "아이린", "매출 분석건", 200),
    (4, "슬기", "경영 혁신안 작성", 120),
    (5, "슬기", "대리점 계획", 85),
    (6, "웬디", "노조 협상건", 24);
SELECT * FROM tProject;

-- JOIN을 사용해서 대구 출신 직원들이 진행 중인 프로젝트 조회
SELECT * FROM tEmployee e JOIN tProject p ON e.name = p.employee WHERE e.addr = "대구";

INSERT INTO tProject VALUES(7, "조이", "원자재 매입", 9000); -- 무결성이 깨져버림
DELETE FROM tEmployee WHERE name = "아이린";
-- 멋대로 삭제 가능, 프로젝트가 있는데 담당자를 찾을 수 없으므로 무결성이 깨져버림

DROP TABLE tEmployee;
DROP TABLE tProject;



# 참조 무결성 example2 (외래키 설정)
CREATE TABLe tEmployee (
	name CHAR(10) PRIMARY KEY,
    salary INT NOT NULL,
    addr VARCHAR(30) NOT NULL
);
INSERT INTO tEmployee VALUES
	("아이린", 650, "대구"),
    ("슬기", 480, "안산"),
    ("웬디", 625, "서울");

CREATE TABLE tProject(
	projectID INT PRIMARY KEY,
    employee CHAR(10) NOT NULL,
    proejct VARCHAR(30) NOT NULL,
    cost INT,
    CONSTRAINT FK_employee FOREIGN KEY(employee) REFERENCES tEmployee(name)
);
INSERT INTO tProject VALUES
	(1, "아이린", "홍콩 수출건", 800),
    (2, "아이린", "TV 광고건", 3400),
    (3, "아이린", "매출 분석건", 200),
    (4, "슬기", "경영 혁신안 작성", 120),
    (5, "슬기", "대리점 계획", 85),
    (6, "웬디", "노조 협상건", 24);
    
#INSERT INTO tProject VALUES(7, "조이", "원자재 매입", 9000); -- error 발생
#DELETE FROM tEmployee WHERE name = "아이린"; -- error 발생
#DELETE FROM tProject WHERE name = "아이린"; -- 아이린이 한 작업 삭제 가능