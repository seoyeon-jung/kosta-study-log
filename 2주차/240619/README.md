## 목차

1. [화살표 함수](#화살표-함수)
2. [객체](#객체)
3. [배열](#배열)

<br/>
<br/>
<br/>

# 화살표 함수

- function 키워드 생략하고 화살표를 이용하는 형식
- `() => {}`

<br/>
<br/>
<br/>

# 객체

```javascript
const menu1 = {
  productName: "Americano",
  price: 3000,
  category: "coffee",
};
```

- 객체 정의
  - 데이터만 가지는 객체
  - 데이터와 기능을 함께 가지는 객체
- 객체의 속성은 변수와 같이 모든 타입의 자료형을 가질 수 있다
- 객체의 메서드 호출: `menu1.price()`
- 객체의 속성을 동적으로 추가

<br/>
<br/>
<br/>

# 배열

- 한개의 변수에 여러 개의 값을 순차적으로 저장할 때 사용
- 배열 안에 들어있는 값들을 요소(element, item, etc)라고 한다.
- 배열은 크기를 조정이 가능하고, 다양한 데이터 형식을 혼합하여 저장할 수 있다.
- 번호가 메겨진 인덱스를 갖는 특별한 유형의 객체이다.

```javascript
var fruits = ["apple", "orange", "banana"];
fruits[0]; // 결과 : apple

var fruits = { first: "apple", second: "orange", third: "banana" };
fruits.first; // 결과 : apple
```

#### 배열과 객체의 차이점

- 배열은 숫자 인덱스를 사용한다.
- 객체는 이름으로 된 인덱스를 사용한다.
- 요소 이름이 문자열이 되도록 하려면 객체를 사용해야 한다.
- 요소 이름을 숫자로 하려면 배열을 사용해야 한다.
- 요소들의 정렬이 필요할 경우 배열을 사용한다.

<br/>
<br/>
<br/>

# JSON

- JSON 타입의 형식 변환해줄 때 사용
- object => JSON 변환 / JSON => object
