## 목차

1. [Event](#event)
2. [Class](#class)
3. [회원관리 프로그램](./mini-project/README.md)

<br/>
<br/>
<br/>

# Event

## DOMContendLoaded

- 돔트리 분석이 끝나면 발생
- 돔이 생성되기 전 돔을 조작하는 자바스크립트 코드가 실행되어 원하지 않는 결과를 내는 것을 막을 수 있다

## addEventListener

- document 요소에 event를 부여할 때 사용
- `.addEventListener('이벤트', 함수명)`
- `.addEventListener('이벤트', 익명함수정의);`
  -. `.addEventListener('이벤트', ()=>{});`

## 자주 하는 이벤트의 종류

### UI Event

- `load`: 페이지가 가지고 있는 모든 요소(이미지, 스크립트 및 광고)가 전부 로드되었을때만 발생함
  ```javascript
   .window.addEventListener('load', setup, false);
  ```
- `unload`: 웹 페이지가 언로드될 때 다른 페이지로 이동하거나 탭을 닫을 때 발생함.
- `error`: 브라우저가 자바스크립트 오류를 만났거나 요청한 자원이 존재하지 않는 경우 발생함.
- `scroll`: 스크롤바를 드래그하거나 키보드, 마우스휠로 스크롤 할 때 발생함. 전체 페이지 뿐만 아니라 특정 요소(스크롤바 가진 textarea)에서도 적용

### KeyBoard Event

- `input`: input/textarea요소 값이 변경될 때 발생함.
- `keydown`: 사용자가 키를 처음 눌렀을 때 (키가 눌린 동안은 계속해서 발생함)
- `keypress`: 사용자가 눌렀던 키의 문자가 입력되었을 때 발생함.
- `keyup`: 키보드 키 눌렀다 뗄 때. 화면에 문자가 나타난 이후에 발생함.

### Mouse Event

- `click`: 마우스 버튼을 눌렀다 뗄 때 발생함.
- `mouseover`: 요소 위로 마우스를 움직였을 때 발생함.
- `mouseout`: 요소 바깥으로 마우스를 움직였을 때 발생함.
- `mouseup`: 눌렀던 마우스 버튼을 뗄 때 발생함.
- `mousedown`: 마우스 버튼을 누르고 있을 때 발생함.

### Focus Event

- focus: 해당 HTML 요소가 포커스를 얻었을 때 발생함.
- blur: 해당 HTML 요소가 포커스를 잃었을 때 발생함.

### Change Event

- 값에 변화가 생길 시 발생하는 이벤트
- 텍스트 입력 요소인 경우에는 요소 변경이 끝날 때가 아니라 포커스를 벗어날 때 이벤트가
  발생합니다.

### 이벤트 예시 - 투두리스트

[투두리스트 바로가기](./js_todo.html)

<br/>
<br/>
<br/>

# Class

- 객체 => {}
- 객체 생성을 위한 틀
- new 틀() => 틀에서 정의된 변수나 함수로 이루어진 객체 생성

```jascript
 class [클래스 이름] {변수, 함수} => new 클래스이름()  // 인스턴스 생성
```
