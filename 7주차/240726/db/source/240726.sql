# 테이블 데이터 조회
SELECT * FROM emp;
SELECT * FROM tcity;

# 테이블 열 이름으로 조회
SELECT job FROM emp;
SELECT ename, job FROM emp;
SELECT name, area, popu FROM tcity;
SELECT region, name, area FROM tcity;

# 테이블 중복 제거하여 조회
SELECT DISTINCT job FROM emp;

# 테이블 구조와 속성 파악
DESC tcity;
DESC emp;

# tcity 테이블에서 데이터 조회(region, name, area 컬럼만 조회)
# 열이름 별명 (AS 생략하고 한 칸 띄워 작성 가능)
# 열이름 `별명` (별명에 띄어쓰기나 한글, 예약어 등이 있는 경우에는 백틱으로 감싸는 것을 권장)
SELECT `region` AS `도시명`, `popu` AS `인구 (만명)`, `area` AS `면적` FROM tcity;
SELECT region 도시명, name 인구, area 면적 FROM tcity;

SELECT name AS `도시명`, popu AS `인구` FROM tcity WHERE metro='n';

# 산술 표현식
SELECT name `도시명`, popu * 10000 `인구` FROM tcity;
SELECT * FROM tcity WHERE popu = 300 + 42;
SELECT 1+2+3+4+5 AS `5까지의 합`;

-- tcity 테이블에서 데이터(name, area, popu, 인구밀도) 조회
-- 인구밀도는 인구수를 면적으로 나눈 값
SELECT name, area, popu, popu/area AS `인구밀도` FROM tcity;

-- SELECT 문을 통해 1년은 몇 초인지 계산
SELECT 365 * 24 * 60 * 60 `1년은 몇 초?`;

# 컬럼 연결(Concatenate)
SELECT concat("최인규","는 ","천재") AS `명언`;
SELECT concat(name, " ", grade) AS `직급` FROM tstaff;

# DISTINCT 중복 제거
SELECT region FROM tcity;
SELECT DISTINCT region FROM tcity;

# 정렬 (ORDER BY)
SELECT * FROM tcity ORDER BY region;
SELECT * FROM tcity ORDER BY area;
SELECT * FROM tcity ORDER BY popu DESC;
SELECT * FROM tcity ORDER BY region, name DESC;
SELECT * FROM tcity ORDER BY 5, 1 DESC;
SELECT name AS `도시명`, popu AS `인구` FROM tcity ORDER BY `인구` DESC;

-- tstaff 테이블에서 salary가 적은 사람부터 순서대로 출력하되, salary가 같다면 score가 높은 사람을 먼저 조회
SELECT * FROM tstaff ORDER BY salary ASC, score DESC;

# 조건문 (WHERE)
-- tcity 테이블에서 metro가 n인 데이터 조회 (name, popu 컬럼만 조회 - 인구수 내림차순)
SELECT name, popu FROM tcity WHERE metro = 'n' ORDER BY popu DESC;

-- tstaff 테이블에서 joindate가 2015년 이전인 데이터 조회 (name, depart, grade 컬럼만 조회)
SELECT name, depart, grade FROM tstaff WHERE joindate < '2016-01-01';

# NULL을 비교할 때 IS 또는 IS NOT을 사용한다.
SELECT * FROM tstaff WHERE score IS NULL;

# 논리 연산자
SELECT * FROM logic_operation;
SELECT `a`, `b`, `and` FROM logic_operation WHERE a = 1 AND b = 1;
SELECT `a`, `b`, `or` FROM logic_operation WHERE a = 1 OR b = 1;

-- OR과 NOT을 이용해 AND 연산
SELECT `a`, `b`, `and` FROM logic_operation WHERE NOT (a = 0 OR b = 0);

-- AND와 NOT을 이용해 OR 연산
SELECT `a`, `b`, `or` FROM logic_operation WHERE NOT(NOt a = 1 AND NOT b= 1);

-- tstaff 테이블에서 salary가 300 미만이면서 score는 60 이상인 직원이 누구인지 조회
SELECT * FROM tstaff WHERE salary < 300 AND score >= 60;
-- tstaff 테이블에서 인사과 남자 직원과 영업부 여자 직원을 모두 조회
SELECT * FROM tstaff WHERE (depart = '인사과' AND gender = '남') OR (depart = '영업부' AND gender = '여');

# 와일드카드
SELECT * FROM tstaff WHERE name LIKE "%신%";

-- emp 테이블에서 'T'이라는 글자가 들어가는 직원을 검색
SELECT * FROM emp WHERE ename LIKE "%T%";
-- emp 테이블에서 'T'이라는 글자가 들어가지 않는 직원을 검색
SELECT * FROM emp WHERE ename NOT LIKE "%T%";
-- emp 테이블에서 'T'으로 끝나는 직원을 검색
SELECT * FROM emp WHERE ename LIKE "%T";
-- emp 테이블에서 '천'으로 시작하는 직원을 검색
SELECT * FROM emp WHERE ename LIKE "T%";
-- promotion_tbl 테이블에서 promotion_msg에 '30%'라는 글자가 들어가는 상품 검색
SELECT * FROM promotion_tbl WHERE promotion_msg LIKE "%30\%% ";
SELECT * FROM promotion_tbl WHERE promotion_msg LIKE "%30@%%" ESCAPE '#';


# BETWEEN ~ AND
SELECT * FROM tCity WHERE popu BETWEEN 50 AND 100;
SELECT * FROM tCity WHERE popu >= 50 AND popu <= 100;
SELECT * FROM tstaff WHERE name BETWEEN '가' AND '사';
SELECT * FROM tStaff WHERE joindate BETWEEN '20150101' AND '20180101';


# IN
SELECT * FROM tcity WHERE region IN ('경상', '전라');
SELECT * FROM tcity WHERE region = '경상' OR region = '전라';


-- tcity 테이블에서 area가 500~1000 사이의 도시 목록을 조회
SELECT * FROM tcity WHERE area BETWEEN 500 AND 1000;

-- tcity 테이블에서 region 필드가 경상 또는 전라가 아닌 모든 도시를 조회
SELECT * FROM tcity WHERE region NOT IN ('경상', '전라');

-- tstaff 테이블에서 성이 '이'씨 이거나 '안'씨인 직원을 조회
SELECT * FROM tstaff WHERE name LIKE "이%" OR name LIKE "안%";

-- tstaff 테이블에서 총무부나 영업무에 근무하는 직원을 조회
SELECT * FROM tstaff WHERE depart IN ('총무부', '영업부');

-- tstaff 테이블에서 인사과나 영업부에 근무하는 대리를 조회
SELECT * FROM tstaff WHERE depart IN ('인사과', '영업부') AND grade = '대리';


# 행의 개수 제한 - LIMIT [건너뛸 개수,] 조회할 개수
SELECT * FROM tcity ORDER BY area DESC LIMIT 4;
SELECT * FROM tcity ORDER BY area DESC LIMIT 0, 4;
SELECT * FROM tcity ORDER BY area DESC LIMIT 4, 4;

-- tstaff 테이블에서 salary가 높은 상위 5명의 직원을 조회
SELECT * FROM tstaff ORDER BY salary DESC LIMIT 5;

-- tcity 테이블에서 area가 넓은 도시 중 앞의 2개는 건너뛰고 이후 3개의 도시를 조회
SELECT * FROM tcity ORDER BY area DESC LIMIT 2, 3;
SELECT * FROM tcity ORDER BY area DESC LIMIT 3 OFFSET 2;

-- tstaff 테이블에서 salary 순으로 내림차순 정렬한 후 12위에서 16위까지 조회
SELECT * FROM tstaff ORDER BY salary DESC LIMIT 11, 5;


# WHERE 구에서 연산하기
SELECT * FROM tcity WHERE popu * 10000 / area < 1000;
SELECT *, (popu * 10000/area) `인구밀도` FROM tcity WHERE (popu * 10000 / area) < 1000;
-- SELECT *, (popu * 10000 / area) `인구밀도` FROM tcity WHERE `인구밀도` DESC;

# ORDER BY 구에서 연산하기
-- FROM > WHERE > SELECT > ORDER BY 순서로 동작
SELECT * FROM tcity ORDER BY (popu * 10000 / area) DESC;
SELECT *, (popu * 10000 / area) `인구밀도` FROM tcity ORDER BY `인구밀도` DESC;

# NULL 계산
SELECT NULL * 1, NULL - 1, NULL + 1, NULL / 1, 1 / NULL;


# 산술 함수
SELECT 10 % 3 AS `연산자 나머지 연산`, MOD(10, 3) AS `함수 나머지 연산`, ROUND(10.5) `반올림`, ROUND(3.1415926, 2) `반올림`, 
ROUND(3141.5926, -3) `반올림`;
SELECT TRUNCATE(10.5, 0) `버림`, TRUNCATE(3.1415926, 3) `버림`, TRUNCATE(3131.5926, -3) `버림`;

-- tstaff 테이블에서 score가 짝수면 0, 홀수면 1을 표시하는 '홀짝' 열 출력
SELECT score, TRUNCATE(score, 0) % 2 `홀짝` FROM tstaff;
SELECT score, MOD(TRUNCATE(score, 0), 2) `홀짝` FROM tstaff;
SELECT *, CASE WHEN score % 2 = 0 THEN 0 ELSE 1 END AS `홀짝` FROM tstaff ;

-- emp 테이블에서 EMPNO가 홀수인 데이터의 모든 컬럼을 조회
SELECT * FROM emp WHERE MOD(EMPNO, 2) = 1;
SELECT * FROM emp WHERE EMPNO % 2 = 1;

-- tstaff 테이블에서 score을 소수점 첫째자리에서 반올림하여 데이터를 조회
SELECT *, ROUND(score, 1) AS `반올림한 score` FROM tstaff;


# 문자 관련 함수
SELECT CONCAT(price, "원") `개당 가격`, CONCAT(amount, "개") `재고 수량`, concat(price * amount, "원") `총 가격` FROM buytbl;

-- usertbl 테이블에서 name과 name의 길이를 조회
SELECT name, cONCAT(FLOOR(length(name)/3), "글자") AS `name의 길이` FROM usertbl;

-- emp 테이블의 hiredate 컬럼을 통해 4자리 연도, 2자리 달을 출력
SELECT hiredate, SUBSTRING(hiredate, 0, 4) FROM emp;
SELECT hiredate, YEAR(HIREDATE) AS year, LPAD(MONTH(hiredate), 2, '0') AS month FROM emp;


# 날짜
SELECT CURRENT_TIME();
SELECT CURRENT_TIME()  + INTERVAL 3600 SECOND; -- 1시간 뒤
SELECT CURRENT_TIME() + INTERVAL 60 MINUTE;
SELECT CURRENT_TIME() + INTERVAL 1 HOUR;
SELECT ADDDATE(CURTIME(), INTERVAL 1 HOUR);
SELECT SUBDATE(CURTIME(), INTERVAL 1 HOUR);

SELECT CURRENT_DATE();
SELECT CURRENT_DATE() - INTERVAL 365 DAY; -- 1년 전 (윤년)
SELECT CURRENT_DATE() - INTERVAL 12 MONTH;
SELECT CURRENT_DATE() - INTERVAL 1 YEAR;
SELECT ADDDATE(CURRENT_DATE(), INTERVAL 1 YEAR); -- 1년 후
SELECT SUBDATE(CURRENT_DATE(), INTERVAL 1 YEAR); -- 1년 전

SELECT CURRENT_TIMESTAMP();


-- tstaff 테이블에서 오늘 날짜까지 입사 후 며칠이 지났는지 조회
-- datediff, current_date
SELECT *, DATEDIFF(CURRENT_DATE, joindate) AS `오늘까지 입사 후 계산` FROM tstaff;


-- usertbl 테이블에서 birthyear와 mdate 컬럼을 사용해, 만 나이 조회
-- year, curdate, right
-- RIGHT(CURDATE(), 5) : 현재 날짜 (연도 제외)
-- RIGHT(mdate, 5) : 태어난 연도의 날짜 (연도 제외)
SELECT name, 
YEAR(CURDATE()) - birthyear - (RIGHT(CURDATE(), 5) < RIGHT(mdate, 5)) AS `만나이` FROM usertbl;



-- tstaff 테이블에서 salary가 300 이상이면 salary의 30%
-- 그렇지 않으면 salary의 50%로 계솬한 성과급 컬럼을 추가하여 데이터 조회
SELECT *, IF(salary >= 300, salary * 0.30, salary*0.50) AS `성과급` FROM tstaff;

-- tstaff 테이블에서 grade가 사원이면 100, 대리이면 200, 나머지는 300으로 성과급 컬럼을 추가하여 데이터 조회
SELECT *, IF(grade="사원", 100, IF(grade="대리", 200, 300)) AS `성과급` FROM tstaff;


-- tCity 테이블을 이용하여 "전라"의 도시들의 인구 총합을 구하는 SQL 쿼리를 작성하시오
SELECT SUM(popu) AS total FROM tCity WHERE region = "전라";

-- tStaff의 테이블을 이용하여 특정 부서(영업부)의 직원 수를 구하는 SQL 쿼리를 작성하시오
SELECT COUNT(*) AS `직원 수` FROM tStaff WHERE depart = '영업부';

-- emp 테이블에서 연봉이 3000 이상 4000 이하인 직원들의 이름과 연봉을 조회하시오
SELECT ENAME, SAL FROM emp WHERE SAL BETWEEN 3000 AND 4000;

-- buytbl 테이블을 이용하여 '운동화'를 구매한 사용자 아이디와 구매 수량을 조회
SELECT userid, amount FROM buytbl WHERE productname = "운동화";

-- tcar 테이블을 이용하여 가격이 3000 이상인 자동차의 이름과 제조사를 조회
SELECT car, maker FROM tcar WHERE price >= 3000;

-- usertbl을 이용하여 1990년대에 태어난 사용자들의 이름과 생년을 조회하시오
SELECT * FROM usertbl;
SELECT name, birthyear FROM usertbl WHERE birthyear BETWEEN 1990 AND 1999;


-- tstaff 테이블에서 남자 직원들의 평균 연봉
SELECT AVG(salary) AS `남자 직원들의 평균 연봉` FROM tstaff WHERE gender="남";


-- tstaff 테이블에서 '과장' 직급의 직원들의 이름과 부서를 조회하시오
SELECT * FROM tstaff;
SELECT name, depart FROM tstaff WHERE grade="과장";


-- tcar '현대' 제조사의 자동차 목록을 조회하시오
SELECT * FROM tcar;
SELECT * FROM tcar WHERE maker="현대";

-- promotion_tbl 'Product C'의 프로모션 메세지를 조회하시오
SELECT * FROM promotion_tbl;
SELECT promotion_msg FROM promotion_tbl WHERE product_name = "Product C";