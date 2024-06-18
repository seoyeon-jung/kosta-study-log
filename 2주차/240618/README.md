## 목차

1. [switch문](#switch문)
2. [boolean](#boolean)
3. [배열](#배열)
4. [반복문](#반복문)
5. [함수](#함수)

<br/>
<br/>
<br/>

# Switch문

```javascript
swtich (값) {
    case 조건 값 1:
        처리 구문
        break
    case 조건 값 2:
        처리 구문
        break
    ...
    default:
        처리 구문
}
```

<br/>
<br/>

# Boolean

- `||` : 논리값이 `false`일 때 실행

<br/>
<br/>

# 배열

- 변수들의 묶음 (의미가 유사한 데이터의 묶음)
- 배열의 생성 : `[요소, 요소, 요소, ...]`
- 배열 컨트롤 : 창조(접근), 개수, 요소 추가, 요소 삭제
- 요소 추가 : `.push()`
- 요소 삭제 : `.pop()`

<br/>
<br/>

# 반복문

```javascript
for (반복의 조건) {
    반복할 내용
}

while (반복의 조건 bool) {
    반복할 내용
}
```

<br/>
<br/>

# 함수

- 함수는 1급 개체, 변수에 함수를 정의
- 특정 목적을 수행하기 위한 코드들이 집합
- 필요에 따라 값을 받아서 처리(매개변수 정의)
- 필요에 따라 처리된 결과를 반환 (return 값)

```javascript
function 함수명(매개변수) {
  return 값;
}
```

- 매개변수 : 함수가 호출될 때 받은 값을 저장하는 함수
- 가변 매개변수 : 호출할 때 매개변수의 개수가 고정이 아닌 가변일 때 사용

```javascript
function test1(...items) {
  // ...items => 배열 형식으로 받게 된다 (가변 매개변수)
  console.log(items);
}

test1(1, 2);
```

### 콜백 함수

- 함수의 매개변수로 전달되는 함수
