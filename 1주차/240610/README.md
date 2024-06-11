## 목차
1. [웹의 동작 원리](#웹의-동작-원리)  
2. [웹 표준 기술](#웹-표준-기술)   
3. [HTML5 기본 구조와 작성법](#html5-기본-구조와-작성법)   
4. [HTML5 기본 태그](#html5-기본-태그)     

*참고 : [HTML 문서](https://developer.mozilla.org/ko/docs/Web/HTML)   

<br/>
<br/>


# 웹의 동작 원리
- 클라이언트(사용자) : 요청하는 쪽
- 서버(제공자) : 응답하는 쪽
- 웹 : 클라이언트가 서버에 요청하면 요청에 응답하여 웹 페이지를 제공하는 장소

#### 서버 프로그램
- 서버에서 실행되는 프로그램   
- 클라이언트의 요청에 따라 적절한 파일과 데이터를 제공   
- 자바, C#, 루비, 파이썬, 자바스크립트와 같은 언어로 개발   
- 기본 웹 프레임워크, MVC 프레임워크, 비동기 프레임워크로 개발   

#### 클라이언트 프로그램
- 클라이언트에서 실행되는 프로그램   
- 웹 브라우저에서 작동하는 프로그램   
- HTML로 요소 생성, CSS로 디자인, 자바스크립트로 프로그래밍 요소를 부여

<br/>
<br/>


# 웹 표준 기술
#### HTML5
- 큰 의미 : 웹 표준 기술 총칭
- 작은 의미 : 웹 문서의 문법      
- HTML5는 마크업 언어    
    - 마크업은 대상이 화면에 어떻게 보일지 나타내기 위해 사용하는 일련의 문자.
#### CSS
- Casacading Style Sheet
- HTML 웹 페이지의 스타일을 지정할 때 사용하는 언어
- 현재는 CSS3 버전을 사용 중
#### JavaScript
- HTML 페이지에서 사용자 반응 등을 처리하는데 사용
- 표준 명칭은 ECMAScript6
- 1994년 넷스케이프의 브랜든 아이히가 모카라는 이름으로 개발
- 자바스크립트 기술 규격이 ECMA-262라는 이름으로 정식 채택되고 ECMAScript 표준으로 불림

<br/>
<br/>


# HTML5 기본 구조와 작성법
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>0610 practice</title>
    <style>
        * {color: blueviolet;}
    </style>
    <link rel="stylesheet" href="default.css"></link>
    <script>console.log('hello')</script>
    <script src="app.js"></script>
</head>
<body>
    <h1>Hello</h1>
</body>
</html>
```
- `<meta charset="UTF-8">`   
    - meta 태그의 charset 속성으로 인코딩 방식을 지정하는 것이다.
    - 다양한 브라우저상에서 인코딩 방식의 통일을 주기 위해 작성한다.
    - 작성하지 않으면 html 파일의 글씨가 깨질 수 있다
- `<body></body>` : 사용자에게 실제로 보여지는 부분
- `<head></head>` : body 태그에서 필요한 스타일시트와
자바스크립트를 제공하는데 사용
- `<style></style>`
    - 내부 스타일시트
        - 스타일시트를 가장 손쉽게 사용할 수 있는 방법
        - `style` 태그 사용
    - 외부 스타일시트
        - 프로젝트의 규모가 큰 경우
        - link 태그의 href 속성을 통해 HTML 페이지로 불러옴
- `<script></script>`
    - 내부 자바 스크립트
        - HTML 페이지 내부에 자바스크립트 코드를 바로 입력
        - `script` 태그 사용
    - 외부 자바 스크립트
        - script 태그의 `src` 속성에 파일의 경로 입력

<br/>
<br/>


# HTML5 기본 태그
### 1. 글자 태그
- `<h1></h1> ~ <h6></h6>` : 제목 글자 태그 (1이 가장 크다)
- 특수 문자
    - `&nbsp;` : 공백 문자 
    - `&lt;` : <
    - `&gt;` : >
    - `&amp;` : & 
- `<p></p>` : 본문 글자 태그
- `<br/>` : 개행을 하는 태그. 다른 글자 내부에 삽입 가능
- `<hr/>` : 라인을 표현하는 태그. 다른 글자 내부에 삽입 불가능하나 정상적으로 출력됨
- `<a href="이동페이지">출력문구</a>` : 하이퍼텍스트 태그 (바로가기)
    <details>
    <summary>a 태그 예시</summary>
    <div markdown="1">

        
        <!-- 하이퍼링크 -->
        <a href="http://www.bitcamp.co.kr">비트캠프</a><br>
        <a href="http://www.naver.com/">네이버</a><br>
        <a href="http://www.daum.com/">다음</a><br>

        <!-- 하위 폴더로 이동하기 -->
        <a href="./link/link.html">link.html</a>
        <a href="./intro/intro.html">intro.html</a>

        <!-- 상위 폴더로 이동하기 -->
        <a href="../index.html">index.html로 돌아가기</a>
        
        

    </div>
    </details>
- 웹 페이지 내부에 연결하기
    1. h1 태그에서 id 속성 입력 후
    2. a 태그의 속성에 `#id 속성` 입력
### 2. 목록 태그
- 글머리 기호 목록
    - `<ul></ul>`(unordered list) : 글머리 기호 목록 태그
    - `<li></li>`(list item) : 목록 요소

- 태그 이름 설명
    - `<ol></ol>`(ordered list) : 순서 번호 목록 태그
    - `<li></li>`(list item) : 목록 요소
<details>
    <summary>목록  태그 예시</summary>
    <div markdown="1">

    
        <ul>
            <li>사과</li>
            <li>바나나</li>
            <li>오렌지</li>
        </ul>
        <ol>
            <li>사과</li>
            <li>바나나</li>
            <li>오렌지</li>
        </ol>
   

    </div>
</details>

### 3. 테이블 태그
```html
    <table>
        <tr>
            <td>1, 1</td>
            <td>1, 2</td>
            <td>1, 3</td>
        </tr>
        <tr>
            <td>2, 1</td>
            <td>2, 2</td>
            <td>2, 3</td>
        </tr>
        <tr>
            <td>3, 1</td>
            <td>3, 2</td>
            <td>3, 3</td>
        </tr>
    </table>
```
- table 병합
    - `colspan` : 가로로 병합
    - `rowspan` : 세로로 병합