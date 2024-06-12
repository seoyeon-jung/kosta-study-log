## 목차
1. [CSS3 선택자](#css3-선택자)  
2. [CSS3 단위](#css3-단위)   

<br/>
<br/>


# CSS3 선택자
### 반응 선택자
- 사용자의 반응으로 생성되는 특정한 상태를 선택

|선택자 형태|설명|
|----|----|
|`:active`|사용자가 마우스로 클릭한 태그 선택|
|`:hover`|사용자가 마우스 커서를 올린 태그 선택|
```html
<style>
    h1:hover {
        color: red;
    }
    h1:active {
        color: blue;
    }
</style>
<body>
    <h1>User Action Selector</h1>
</body>
```
### 상태 선택자
- 입력 양식의 상태를 선택할 때 사용
   
|선택자 형태|설명|
|---|---|
|`:checked`|체크 상태의 input 태그 선택|
|`:focus`|초점이 맞추어진 input 태그 선택|
|`:enabled`|사용 가능한 input 태그 선택|
|`:disabled`|사용 불가능한 input 태그 선택|

```html
<style>
    input:enabled {
        background-color: white;
    }
    input:disabled {
        background
    input:focus {
        background-color: orange;
    }
</style>
```
### 구조 선택자
- 특정한 위치에 있는 태그를 선택할 때 사용

|선택자 형태         |설명|
|-------------|------|
|`:first-child`|형제 관계에서 첫 번째로 등장하는 태그 선택|
|`:last-child`|형제 관계에서 마지막으로 등장하는 태그 선택|
|`:nth-child`(수열)|형제 관계에서 앞에서 수열 번째로 등장하는 태그 선택|
|`:nht-last-child`(수열)|형제 관계에서 뒤에서 수열 번째로 등장하는 태그 선택|

```html
<style>
    ul {
        overflow: hidden;
    }
    li {
        list-style: none;
        float: left;
        padding: 15px;
        color: white;
    }
    li:first-child {
        border-radius: 10px 0 0 10px;
    }
    li:last-child {
        border-radius: 0 10px 10px 0;
    }
    li:nth-child(2n) {
        background-color: #FF0003;
    }
    li:nth-child(2n+1) {
        background-color: #800000;
    }
</style>

<body>
    <ul>
        <li>First</li>
        <li>Second</li>
        <li>Third</li>
        <li>Fourth</li>
        <li>Fifth</li>
        <li>Sixth</li>
        <li>Seventh</li>
    </ul>
</body>
```
### 문자 선택자
- 태그 내부의 특정한 조건의 문자를 선택하는 선택자
#### 시작 문자 선택자

|선택자 형태|설명|
|---|---|
|`::first-letter`|첫 번째 글자 선택|
|`::first-line`|첫 번째 줄 선택|

```html
<style>
    p::first-letter {
        font-size: 3em;
    }
    p::first-line {
        color: red;
    }
</style>
<body>
    <h1>Lorem ipsum dolor sit amet</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adi
    piscing elit.</p>
    <p>Aenean ac erat et massa vehicula laoreet co
    nsequat et sem.</p>
</body>
```
#### 반응 문자 선택자
- 사용자가 문자와 반응해서 생기는 영역을 선택하는 선택자
- `::selection` : 사용자가 드래그한 글자를 선택   
```html
<style>
    p::selection {
        background: black;
        color: red;
    }
</style>
<body>
    <h1>Lorem ipsum dolor sit amet</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adi
    piscing elit.</p>
    <p>Nunc nisl turpis, aliquet et gravida non, f
    acilisis a sem.</p>
</body>
```
### 링크 선택자
- `href` 속성을 가지고 있는 `a` 태그와 헌 번 이상 다녀온 링크를 선택할 수 있는 선택자

|선택자 형태|설명|
|---|---|
|`:link`|href 속성을 가지고 있는 a 태그 선택|
|`:visited`|방문했던 링크를 가지고 있는 a 태그 선택|

```html
<style>
    a {
        text-decoration: none;
    }
    a:visited {
        color: red;
    }
    a:link::after {
        content: ' - 'attr(href);
    }
</style>
<body>
    <h1><a>Nothing</a></h1>
    <h1><a href="http://www.naver.com">Naver</a></h1>
    <h1><a href="http://www.w3.org/">W3C</a></h1>
    <h1><a href="https://github.com/">Github</a></h1>
```
### 부정 선택자
- 지금까지 배운 선택자를 모두 반대로 적용할 수 있게 만드는 선택자
- `:not(선택자)`

<br/>
<br/>

# CSS3 단위
### 키워드 단위
#### 1. 크기 단위
- CSS3에서 가장 많이 사용하는 단위
- `%`(상대적 크기), `em`(배수), `mm`, `inch`, `px`(픽셀)
#### 2. 색상 단위
- `rgb`(red, green, blue) : 0~255 사이의 숫자 입력
- `rgba`(red, green blue, alpha): 알파 값은 투명도, 0.0~1.0 사이의 숫자 입력
- `#000000` (HEX 코드 단위) : RGB 색상 조합을 16진수로 입력
#### 3. URL 단위
- 이미지나 글꼴 파일을 불러올 때 사용
- background-image 속성 사용 (url(경로) 형태로 입력)
### 박스 속성
- `width`와 `height` 속성
    - 글자를 감싸는 영역의 크기를 지정
- `boder` 속성
    - 테두리의 두께를 지정
- `margin` 속성
    - 테두리와 다른 태그와의 간격을 지정
- `padding` 속성
    - 테두리와 글자 사이의 간격을 지정
#### 테두리 속성
- `border-width` 속성
    - 테두리의 두께 지정
    - 크기 단위 또는 키워드 입력 가능
- `border-style` 속성
    - 테두리의 형태 지정
    - 키워드 입력 가능
- `border` 속성
    - border-width, border-style, border-color 속성 한 번에 입력 가능
- `border-radius` 속성
    - 테두리가 둥근 사각형 또는 원 생성 가능
### display 속성
|키워드 이름|설명|
|---|---|
|none|태그를 화면에서 보이지 않게|
|block|태그를 블록 형식으로 지정|
|inline|태그를 인라인 형식으로 지정|
|inline-block|태그을 인라인-블록 형식으로 지정|
### 배경 속성
|속성 이름|설명|
|---|---|
|background-image| 배경 이미지 지정|
|background-size| 배경 이미지의 크기 지정|
|background-repeat| 배경 이미지의 반복 형태 지정|
|background-attachment| 배경 이미지의 부착 형태 지정|
|background-position| 배경 이미지의 위치 지정|
|background| 한 번에 모든 배경 속성 지정|
### 글자 속성
- `font-size` 속성
    - 글자 크기를 지정하는 속성
    - 크기 단위나 키워드를 입력
- `font-family` 속성
    - 글꼴을 지정하는 속성
- font-family 속성을 여러 개 입력
    - 사용자의 컴퓨터에 글꼴이 없는 경우 대비
- 웹 폰트 설정하기
    ```html
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Song+Myung&display=swap" rel="stylesheet">
        <style>
            * {
                font-family: 'Song Myung', serif;
            }
        </style>
        <body>
            <h1>안녕하세요.</h1>
            <p>그들의 장비와 기구는 모두 살아 있다.</p>
            <p>안녕하세요.</p>
        </body>
    ```
- `font-style` 속성 : 글자의 두께 조정
- `font-weight` : 글자의 기울기 조정
- `text-align` : 글자의 정렬 지정
- `line-height` : 글자의 높이 지정 (수직 정렬할 때 사용)