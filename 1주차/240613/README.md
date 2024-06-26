## 목차
1. [CSS3 속성](#css3-속성)  
2. [CSS3 flex, grid](#css3-flex-grid)   

<br/>
<br/>


# CSS3 속성
### 위치 속성
- 절대 위치 좌표: 요소의 X 좌표와 Y 좌표를 설정해 절대 위치 지정
- 상대 위치 좌표: 요소를 입력한 순서에 따른 상대 위치 지정

|키워드|설명|
|---|---|
|`static`|상대 위치 좌표 설정|
|`relative`|초기 위치에서 상하좌우로 이동|
|`absolute`|절대 위치 좌표 설정|
|`fixed`|화면을 기준으로 절대 위치 좌표 설정|

- 도형의 순서를 변경하고 싶을 경우 `z-index` 속성 사용
    - 숫자가 클수록 앞에 위치
- `overflow` : 내부의 요소가 부모의 범위를 벗어날 때 요소를 처리하는 방법 지정
    |키워드|설명|
    |---|---|
    |`hidden`|영역을 벗어나는 부분을 보이지 않게 만듦|
    |`scroll`|영역을 벗어나는 부분을 스크롤로 만듦|
### float 속성
- 웹 페이지를 만들 때 가장 많이 사용하는 속성
- 레이아웃을 잡을 때 많이 사용
- `left` : 태그를 왼쪽에 붙임
- `right` : 태그를 오른쪽에 붙임

<br/>
<br/>

# CSS3 flex, grid
- `html` 파일 참고