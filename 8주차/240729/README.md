## 목차
- [CASE](#case)
- [그룹화 - GROUP BY](#그룹화---group-by)
- [데이터 집계](#데이터-집계)
- [그룹화 조건 - HAVING](#그룹화-조건---having)
  - [SELECT 문이 실행되는 과정](#select-문이-실행되는-과정)
- [집합 연산자 (SET operator)](#집합-연산자-set-operator)
- [서브 쿼리 (Sub Query)](#서브-쿼리-sub-query)
  - [다중 열(Multi Column) 서브 쿼리](#다중-열multi-column-서브-쿼리)
  - [다중 행(Multi Row) 서브 쿼리](#다중-행multi-row-서브-쿼리)
    - [IN 연산자](#in-연산자)
    - [ALL 연산자](#all-연산자)

<br/>
<br/>
<br/>
<br/>

# CASE
- 조건에 따른 값을 지정하기 위해 사용
- 이를 통해 기존 연산자와 함수로 처리가 불가능한 것들 중 간단한 것들을 처리할 수 있다.
- CASE 문은 `검색 CASE`와 `단순 CASE`로 나눌 수 있다.

<br/>

[예제]
![alt text](image.png)

- SELECT구 뿐만 아니라 WHERE구와 ORDER BY구에서도 사용할 수 있다.
- ELSE를 생략하면 자동적으로 ELSE null로 처리된다.
- 단순 CASE문에서의 NULL 값 비교는 불가능하다.

<br/>

[예제]
![alt text](image-1.png)

<br/>
<br/>
<br/>
<br/>

# 그룹화 - GROUP BY
- 집계 함수는 그룹화와 함께 사용하여 SELECT 문의 활용 범위를 넓힌다.
- `GROUP BY` 구에는 그룹화할 열을 지정하며, 복수의 컬럼 지정도 가능하다.

<br/>

[예제]
![alt text](image-2.png)

<br/>
<br/>
<br/>
<br/>

# 데이터 집계
- 복수의 값에서 하나의 값을 계산해내는 함수
- 데이터를 그룹화해서 통계를 계산해주는 함수로 숫자나 날짜 데이터에 사용된다.
- 문자열 데이터는 최소값과 최대값 조회만 가능하다.
![alt text](image-3.png)
  -  MAX, MIN 값은 사전식 정렬을 통한 최대, 최소값을 반환한다.

- `SUM()` : 그룹의 누적 합계를 반환
- `AVG()` : 그룹의 평균을 반환
- `COUNT()` : 그룹의 총 개수를 반환
- `MAX()` : 그룹의 최대값을 반환
- `MIN()` : 그룹의 최소값을 반환
- `STDDEV()`: 그룹의 표준편차를 반환
- `VARIANCE()`: 그룹의 분산을 반환

<br/>
[예제]
![alt text](image-4.png)


<br/>
<br/>
<br/>
<br/>

# 그룹화 조건 - HAVING
- GROUP BY와 함께 쓰이며, 출력할 그룹의 조건을 지정한다.

![alt text](image-5.png)

<br/>
<br/>

## SELECT 문이 실행되는 과정
![alt text](image-6.png)


<br/>
<br/>
<br/>
<br/>

# 집합 연산자 (SET operator)
- 2개 이상의 SELECT 문을 연결하여 작성 가능하다
- SELECT 문의 컬럼 개수와 데이터 타입은 일치해야 한다.
- 검색 결과의 헤더는 앞쪽 SELECT 문에 의해 결정된다.
- ORDER BY 절을 사용할 때는 문장의 제일 마지막에 사용한다 
  
  <br/>

- `UNION` : 합집합 (중복되는 값은 한번 출력)
- `UNION ALL` : 합집합 (중복되는 값 모두 출력)
- `INTERSECT` : 교집합
- `EXCEPT` : 차집합 (다른 DBMS에서 MINUS)

![alt text](image-7.png)

<br/>
<br/>
<br/>
<br/>

# 서브 쿼리 (Sub Query)
- 하나의 SQL 안에 포함되어 있는 SQL 문
- 메인 쿼리가 서브 쿼리를 포함하는 종속적인 관계이다.
- 항상 Main Query의 기준으로 결과를 나타낸다.
- Sub Query는 반드시 괄호로 감싸서 사용한다.
- Sub Query는 Main Query 실행 전에 한 번 실행된다.
- Sub Query에서 ORDER BY 절은 사용 불가하다.
- FROM 절에 Sub Query를 사용하는 것을 ‘인라인 뷰’라 한다.

<br/>

[예제]
![alt text](image-8.png)

<br/>
<br/>

## 다중 열(Multi Column) 서브 쿼리
- Sub Query의 수행 결과가 여러 개의 열로 된 경우

![alt text](image-9.png)
## 다중 행(Multi Row) 서브 쿼리
- Sub Query에서 반환되는 결과가 하나 이상의 행일 때 사용
- 다중 행 서브 쿼리는 다중 행 연산자와 함께 사용

### IN 연산자
- 반환되는 여러 개의 행 중에서 하나만 참이 되어도 참

![alt text](image-10.png)
### ALL 연산자
- Sub Query 결과와 모든 값이 일치하면 참

![alt text](image-11.png)
### ANY 연산자
- Sub Query의 검색 결과에서 하나만 일치하면 참

![alt text](image-12.png)
### EXISTS 연산자
- Sub Query로 어떤 데이터 존재 여부를 확인 (참 또는 거짓 반환)

![alt text](image-13.png)