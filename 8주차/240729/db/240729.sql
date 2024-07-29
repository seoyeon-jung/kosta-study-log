# database 선택
use study_db;

SELECT IF(10>20 , "참", "거짓");
SELECT CASE 10 WHEN 1 THEN '일' WHEN 5 THEN '오' WHEN 10 THEN '십' ELSE '모름' END;

-- 성과급 추가하여 데이터 조회
SELECT *, CASE grade WHEN '사원' THEN 100 WHEN '대리' THEN 200 ELSE 300 END `성과급` FROM tstaff;

# CASE 문은 조건에 따른 값을 지정한다
# CASE 문은 검색 CASE 문과 단순 CASE 문으로 구분할 수 있다

-- tstaff 테이블에서 score가 null인 경우, 0으로 바꾸어 출력
SELECT *, CASE WHEN score IS NULL THEN 0 ELSE score END FROM tstaff;
SELECT *, IFNULL(score, 0) FROM tstaff;

-- tstaff 테이블에서 gender가 '남'인 경우 1으로, '여'인 경우 2로 바꾸어 `성별` 컬럼을 추가해서 출력
SELECT *, CASE WHEN gender = "남" THEN 1 WHEN gender = "여" THEN 2 ELSE '알 수 없음' END AS `성별` FROM tstaff;

# CASE문은 SELECT구 뿐만 아니라 WHERE구와 ORDER BY 구에서도 사용 가능
# ELSE를 생략하면 자동으로 ELSE null 처리
# 단순 CASE문에서의 NULL 값 비교 불가능
-- grade별로 각각 번호를 지정하여 검색
SELECT * FROM tstaff WHERE CASE grade
								WHEN '사원' THEN 1
                                WHEN '대리' THEN 2
                                WHEN '차장' THEN 3
                                WHEN '과장' THEN 4
                                WHEN '부장' THEN 5
                                WHEN '이사' THEN 6
							END BETWEEN 3 AND 6;
                            
-- grade별로 각각 번호를 지정하여 정렬
SELECT * FROM tstaff ORDER BY CASE grade
								WHEN '사원' THEN 1
                                WHEN '대리' THEN 2
                                WHEN '차장' THEN 3
                                WHEN '과장' THEN 4
                                WHEN '부장' THEN 5
                                WHEN '이사' THEN 6
                                ELSE NULL
							END;

# GROUP BY - 그룹화
SELECT grade, AVG(salary) AS `직급별 평균 임금`, SUM(salary) `직급별 임금 합계`, COUNT(*) `직급별 직원 수` FROM tstaff GROUP BY grade;

# 그룹화할 때는 2개 이상의 컬럼 지정도 가능하다.
SELECT depart, gender, COUNT(*) `부서, 성별에 따른 직원 수` FROM tstaff GROUP BY depart, gender ORDER BY depart, gender;


-- 문자열 데이터의 합계 구하기 > 0 으로 나온다
-- MAX, MIN 값은 사전식 정렬을 통한 최대, 최소값을 반환한다.
SELECT SUM(grade), AVG(grade), MAX(grade) FROM tstaff GROUP BY depart;

SELECT addr, COUNT(*), SUM(mdate), AVG(mdate), MAX(mdate), MIN(mdate) FROM usertbl GROUP BY addr;

-- tstaff 테이블이 가진 데이터 개수(총 직원수) 조회
SELECT COUNT(*) `총 직원 수` FROM tstaff;

-- tstaff 테이블에서 급여가 400 이상인 직원 수 조회
SELECT * FROM tstaff;
SELECT COUNT(*) `급여가 400 이상인 직원 수` FROM tstaff WHERE salary >= 400;

-- tstaff 테이블에서 직급별 직원수 조회
SELECT grade, COUNT(*) `직급별 직원수` FROM tstaff GROUP BY grade;

-- tstaff 테이블에서 직급 종류 개수 조회
SELECT COUNT(DISTINCT grade) `직급 종류 개수` FROM tstaff;

-- tstaff 테이블에서 score 값이 없는 직원 수 조회
SELECT COUNT(*) `score 값이 없는 직원 수` FROM tstaff WHERE score IS NULL;
SELECT COUNT(*) - COUNT(score) FROM tstaff;

-- tstaff 테이블에서 인사과의 평균 급여 조회
SELECT AVG(salary) `인사과의 평균 급여` FROM tstaff WHERE depart = "인사과";

-- tcity 테이블에서 인구의 총합과 평균을 조회
SELECT * FROM tcity;
SELECT SUM(popu)*10000 `인구의 총합`, AVG(popu)*1000 `인구의 평균` FROM tcity;

-- tcity 테이블에서 면적의 최소값과 최대값을 조회
SELECT MIN(area) `면적의 최소값`, MAX(area) `면적의 최대값`  FROM tcity;

-- emp 테이블에서 총 인원수, 최대 급여, 최소 급여, 급여의 평균
SELECT * FROM emp;
SELECT COUNT(*) `총 인원수`, MAX(SAL) `최대 급여`, MIN(SAL) `최소 급여`, AVG(SAL) `급여의 평균` FROM emp;

-- emp 테이블에서 업무(job)별 인원수, 최대 급여, 최소 급여, 급여의 평균
SELECT job, COUNT(*) `총 인원수`, MAX(SAL) `최대 급여`, MIN(SAL) `최소 급여`, AVG(SAL) `급여의 평균` FROM emp GROUP BY JOB;

-- emp 테이블에서 최대 급여와 최소 급여의 차이
SELECT MAX(SAL) `최대 급여`, MIN(SAL) `최소 급여`, MAX(SAL) - MIN(SAL) `최대 급여와 최소 급여의 차이` FROM emp;


## HAVING - 그룹화 조건 (GROUP BY와 함께 쓰여, 출력할 그룹의 조건을 지정)
SELECT depart, AVG(salary) FROM tstaff GROUP BY depart HAVING AVG(salary >= 350);


# 2개 이상의 테이블로부터 데이터를 추출
SELECT deptno FROM dept; -- 4개
SELECT deptno FROM emp; -- 14개

SELECT deptno FROM dept UNION SELECT deptno FROM emp; -- 4개 (중복 제거된 합 집합)
SELECT deptno FROM dept UNION ALL SELECT deptno FROM emp; -- 18개 (중복을 포함하는 합 집합)

SELECT deptno FROM dept INTERSECT SELECT deptno FROM emp; -- 3개 (교집합)
SELECT deptno FROM dept EXCEPT SELECT deptno FROM emp; -- 1개 
SELECT deptno FROM emp EXCEPT SELECT deptno FROM dept; -- 0개 (3개 - 4개 아서 아무것도 안나옴)


# 서브 쿼리
SELECT * FROM dept WHERE deptno IN (SELECT deptno FROM emp WHERE ename IN("SMITH", "ALLEN"));

-- EMP 테이블을 이용해 평균 급여보다 더 많은 급여를 받는 사원을 검색
SELECT * FROM emp WHERE SAL > (SELECT AVG(SAL) FROM emp);

-- EMP 테이블에서 MILLER와 같은 부서(deptno)에서 근무하는 사원을 검색
SELECT * FROM emp WHERE DEPTNO = (SELECT DEPTNO FROM emp WHERE ENAME="MILLER");

-- EMP 테이블에서 MILLER와 동일한 job을 가진 사원을 검색
SELECT * FROM emp WHERE JOB = (SELECT JOB FROM emp WHERE ENAME="MILLER");

-- EMP 테이블에서 MILLER의 급여(SAL)와 동일하거나 더 많이 받는 사원을 검색
SELECT * FROM emp WHERE SAL >= (SELECT SAL FROM emp WHERE ENAME="MILLER");

-- EMP 테이블에서 deptno을 이용해 LOC가 DALLAS인 사원 검색 (DEPT 테이블 활용)
SELECT * FROM emp WHERE deptno = (SELECT deptno FROM dept WHERE LOC="DALLAS");

-- EMP 테이블에서 직속상관(MGR)의 이름이 KING인 사원 검색
SELECT * FROM emp WHERE MGR = (SELECT empno FROM emp WHERE ename="KING");

-- 안중근과 동일한 deaprt와 gender인 사람
SELECT * FROM tstaff WHERE (depart, gender) = (SELECT depart,gender FROM tstaff WHERE name="안중근");


# 다중 행 서브 쿼리 (서브 쿼리의 결과가 여러 줄)
# IN (서브 쿼리 결과 중 하나라도 일치하면 참)
-- emp 테이블에서 부서별로 가장 급여를 많이 받는 사람들과 동일한 급여를 받는 사원 조회
SELECT * FROM emp WHERE sal IN (SELECT MAX(sal) FROM emp GROUP BY deptno);

# ALL (서브 쿼리 결과 모두 일치하면 참)
-- deptno가 30번인 소속 직원들 중에서 급여를 가장 많이 받는 사원보다 많은 급여를 받는 직원 검색
SELECT * FROM emp WHERE sal > ALL (SELECT sal FROM emp WHERE deptno = 30);
-- 30번 부서 직원의 급여의 최댓값보다 높은 급여를 받는 직원 모두 조회
SELECT * FROM emp WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno = 30); -- 더 효율적임

# ANY, SOME
-- deptno가 30번인 소속 직원들 중에서 급여를 가장 많이 받는 사원보다 많은 급여를 받는 직원 검색
SELECT * FROM emp WHERE sal > ANY (SELECT sal FROM emp WHERE deptno = 30);
SELECT * FROM emp WHERE sal > (SELECT MIN(sal) FROM emp WHERE deptno = 30);


# EXIST - 데이터의 존재 여부 확인
-- EMP 테이블에서 SAL이 2,000을 넘는 사원이 있으면 모든 직원을 조회
SELECt ename, sal FROM emp WHERE EXISTS (SELECT 1 FROm emp WHERE sal > 2000);


-- EMP 테이블에서 부서별로 가장 급여를 많이 받는 사원들과 동일한 급여를 받는 사원 검색
SELECT * FROM emp WHERE sal IN(SELECT MAX(sal) FROM emp GROUP BY deptno);

-- EMP 테이블에서 SAL를 3,000 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원 검색
SELECT * FROM emp WHERE deptno IN(SELECT deptno FROM emp WHERE sal >= 3000);

-- EMP 테이블에서 JOB이 MANAGER인 사람이 속한 부서 정보 검색
SELECT * FROM dept WHERE deptno IN(SELECT DISTINCT deptno FROM emp WHERE job = "MANAGER");

-- EMP 테이블에서 BLAKE와 동일한 부서에 있는 모든 사원 검색
SELECT * FROM emp WHERE deptno = (SELECT deptno FROM emp WHERE ENAME = "BLAKE");

-- EMP 테이블에서 평균 급여(SAL) 이상을 받는 모든 사원 검색. 급여가 많은 순으로 출력
SELECT * FROM emp WHERE sal >= (SELECT AVG(sal) FROM emp) ORDER BY sal DESC;

-- EMP 테이블에서 이름에 “T”가 있는 사원이 근무하는 부서에 있는 모든 사원 검색. 사원번호 순으로 출력
SELECT * FROM emp WHERE deptno IN (SELECT DISTINCT deptno FROM emp WHERE ename LIKE "%T%") ORDER BY empno;

-- EMP 테이블에서 근무 지역이 DALLAS인 사원 정보 검색
SELECT * FROM emp WHERE deptno IN (SELECT deptno FROM dept WHERE LOC="DALLAS");


# JOIN (2개 이상의 테이블을 엮어서 테이터를 조회)
SELECT * FROM tcar, tmaker;
# CROSS JOIN (모든 집합 JOIN - A 테이블 행의 개수 * B 테이블 행의 개수 = 카티션 곱)
SELECT * FROM tcar CROSS JOIN tmaker;
-- 테이블명도 별명을 지을 수 있다.
SELECT c.maker, m.maker FROM tcar c CROSS JOIN tmaker m;

SELECT * FROM tcar, tmaker WHERE tcar.maker = tmaker.maker;
SELECT * FROM tcar CROSS JOIN tmaker WHERE tcar.maker = tmaker.maker;
-- JOIN에서 테이블 별명을 붙인 후에는 WHERE 절에서 별명을 사용하는 것이 필수!
SELECT * FROM tcar c CROSS JOIN tmaker m WHERE c.maker = m.maker;


# INNER JOIN
SELECT * FROM tcar INNER JOIN tmaker ON tcar.maker = tmaker.maker;
SELECT * FROM tcar c INNER JOIN tmaker m ON c.maker = m.maker;
SELECT c.*, m.* FROM tcar c INNER JOIN tmaker m ON c.maker = m.maker;


# NATURL JOIN (문법)
SELECT * FROM tcar JOIN tmaker USING(maker);
SELECT * FROM tcar NATURAL JOIN tmaker;


# SELF JOIN (구조)
SELECT CONCAT(e.ename, "의 매니저는 ", m.ename) FROM emp e JOIN emp m ON e.mgr = m.empno;


-- DEPT 테이블의 LOC가 'NEW YORK'인 사원의 이름과 급여를 조회
SELECT * FROM emp WHERE deptno = (SELECT DISTINCT deptno FROM dept WHERE loc = "NEW YORK");
SELECT e.ENAME, e.SAL FROM emp e JOIN dept d ON e.deptno = d.deptno WHERE d.LOC = "NEW YORK";
SELECT e.ENAME, e.SAL FROM emp e JOIN dept d USING(deptno) WHERE d.LOC = "NEW YORK";

-- DEPT 테이블의 DNAME 컬럼의 값이 'ACCOUNTING'인 사원의 이름과 입사일을 조회
SELECT e.ENAME, e.HIREDATE FROM emp e JOIN dept d ON e.deptno = d.deptno WHERE d.DNAME = "ACCOUNTING";

-- EMP 테이블의 JOB이 'MANAGER'인 사원의 이름, 부서명을 조회
SELECT e.ENAME, d.DNAME FROM emp e JOIN dept d ON e.deptno = d.deptno WHERE e.JOB = "MANAGER";

-- EMP 테이블와 SALGRADE 테이블을 이용해 각 급여에 해당하는 등급을 매핑하여, 이름, 급여, 등급을 조회
SELECT e.ENAME `이름`, e.SAL `급여`, sg.GRADE `등급` FROM emp e JOIN salgrade sg ON e.SAL BETWEEN sg.LOSAL AND sg.HISAL;

-- EMP 테이블에서 MANAGER가 'KING'인 사원들의 이름, 직급을 조인
SELECT e.ENAME, e.JOB FROM emp e JOIN emp m ON e.mgr = m.EMPNO WHERE m.ENAME = "KING";

# INNER-JOIN (내부 조인, equi join & non-equi join)
# 두 테이블을 조인할 때, 두 테이블에 모두 지정한 열의 데이터가 있어야 한다
# 가장 많이 사용된다 (조인 = 내부 조인)

# CROSS JOIN (상호 조인)
-- 한 쪽 테이블에 다른 쪽 테이블의 모든 행을 교차곱 (카티션 곱)
# SELF JOIN (자체 조인)
-- 자기 자신 조인, 1개의 테이블 사용
-- 별도의 문법이 있는 것이 아니라 테이블 한 개로 조인한 것을 셀프조인이라 한다.


# OUTER JOIN (외부 조인)
-- 두 테이블을 조인할 때, 한 쪽 테이블에만 데이터가 있어됴 결과가 나온다
# LEFT (OUTER) JOIN : 왼쪽 테이블의 모든 값이 출력
# RIGHT (OUTER) JOIN : 오른쪽 테이블의 모든 값이 출력
# FULL (OUTER) JOIN : 왼쪽 또는 오른쪽 테이블의 모든 값이 출력 (MySQL에서는 미지원)
SELECT CONCAT(e.ENAME, "의 매니저는 ", m.ENAME) FROM emp e LEFT JOIN emp m ON e.MGR = m.EMPNO;

SELECT * FROM tcar c LEFT JOIN tmaker m ON c.maker = m.maker; -- tmaker 전체 반환 (왼쪽 전체)
SELECT * FROM tcar RIGHT JOIN tmaker ON tcar.maker = tmaker.maker; -- tcar 전체 반환 (오른쪽 전체)


# 다중 조인 (테이블을 자꾸자꾸 중첩한다)
SELECT * FROM tcar c JOIN tmaker m ON c.maker = m.maker
						JOIN tcity ct ON m.factory = ct.name;


-- 사원(EMP) 테이블과 부서(DEPT) 테이블을 조인하여, 사원명, 부서번호,부서명을 출력
-- 사원 테이블에는 부서번호 40번 데이터가 없지만, 40번 부서의 부서명도 함께 출력
SELECt * FROM dept;
SELECT e.ENAME `사원명`, e.DEPTNO `부서 번호`, d.DNAME `부서명` FROM emp e RIGHT JOIN dept d ON e.DEPTNO = d.DEPTNO
	WHERE d.DEPTNO = 40 OR e.DEPTNO IS NOT NULL;
SELECT e.ename, de.deptno, d.dname FROM emp e RIGHT JOIN dept d USINg (deptno);

-- NEW YORK에서 근무하고 있는 사원에 대하여 사원명, 업무, 급여, 부서명을 출력
SELECT e.ENAME, e.JOB, e.SAL, d.DNAME FROM emp e JOIN dept d USING (deptno) WHERE d.LOC = "NEW YORK";

-- 보너스(comm)가 null이 아닌 사원에 대하여 사원명, 부서명, 부서 위치(LOC)를 출력
SELECT e.ENAME, d.DNAME, d.LOC FROM emp e JOIN dept d USING(deptno) WHERE e.comm IS NOT NULL;

-- 사원명 중 L자가 있는 사원에 대하여 사원명, 업무, 부서명, 위치를 출력
SELECT e.ENAME, e.JOB, d.DNAME, d.LOC FROM emp e jOIN dept d USING(deptno) WHERE e.ENAME LIKE "%L%";

-- 자신의 관리자보다 먼저 입사한 사원에 대해 이름, 입사일, 관리자 이름, 관리자 입사일을 출력
SELECT e.ENAME, e.HIREDATE, m.ENAME, m.HIREDATE FROM emp e JOIN emp m ON e.MGR = M.empno WHERE e.HIREDATE < m.HIREDATE;


# INSERT
INSERT INTO tCity VALUES('강릉', 1040, 21, 'N', '강원');
INSERT INTO tCity (name, area, popu, metro, region) VALUES ('원주', 867, 35, 'y', '강원');
SELECT * FROM tCity;

DELETE FROM tCity;
INSERT INTO tCity (name, area, popu, metro, region) VALUES
	('서울', 605, 974, 'y', '경기'),
    ('부산', 765, 342, 'y','경상'),
    ('오산', 42, 21, 'n', '경기'),
    ('전주', 205, 65, 'n', '전라'),
    ('순천', 910, 27, 'n', '전라'),
    ('홍천', 1819, 7, 'n', '강원');

INSERT INTO tCity VALUES
	('이천', 461, 21, 'n', '경기'),
    ('대구', 883, 248, 'y', '경상'),
    ('영월', 1127, 4, 'n', '강원');

INSERT INTO tCity (SELECT factory, 940, 83, 'n', '충청' FROM tmaker WHERE maker = "쌍용");
SELECT * FROM tCity;


# DELETE FROM ~ [WHERE] 조건을 필수로 넣어줘야 한다
DELETE FROM tCity WHERE name = '부산';
DELETE FROM tCity WHERE region = '경기';
DELETE FROM tCity WHERE popu > 50;
SELECT * FROM tCity;

-- 영업부 직원을 전부 삭제
DELETE FROM tstaff WHERE depart = "영업부";


DELETE FROM tCity;
INSERT INTO tCity (name, area, popu, metro, region) VALUES
	('서울', 605, 974, 'y', '경기'),
    ('부산', 765, 342, 'y','경상'),
    ('오산', 42, 21, 'n', '경기'),
    ('전주', 205, 65, 'n', '전라'),
    ('순천', 910, 27, 'n', '전라'),
    ('홍천', 1819, 7, 'n', '강원');
INSERT INTO tCity (SELECT factory, 940, 83, 'n', '충청' FROM tmaker WHERE maker = "쌍용");
SELECT * FROM tCity;


# UPDATE 테이블 SET
-- tcity name이 서울인 데이터의 popu는 1000으로 region은 충청으로 수정
UPDATE tcity SET popu = 1000, region = "충청" WHERE name = '서울';
SELECT * FROM tCity;
-- tcity name이 오산인 데이터의 popu 2배로 갱신
UPDATe tCity SET popu = popu *2 WHERE name = '오산';
SELECT * FROM tCity;


-- tstaff에서 여자 사원 모두를 차장으로 갱신
UPDATE tstaff SET grade = "차장" WHERE gender = "여";
SELECT * FROM tstaff;
-- 총무부 직원의 월급을 10% 인상
UPDATE tstaff SET salary  = 1.1 * salary WHERE depart = "총무부"; -- 정수로 변환되어 들어온다