// 배열 메서드 reduce
// 배열을 통해 하나의 값을 만든다

const arr = [1, 2, 3, 4, 5];

const value = arr.reduce((acc, cur) => {
  return acc + cur;
});

const value2 = arr.reduce((acc, cur) => {
  return acc + cur;
}, 900);

console.log(value); // 15
console.log(value2); // 915

const lastArr = arr.reduce((acc, cur) => {
  if (cur % 2 === 0) {
    acc.push(cur);
  }
  return acc;
}, []);

console.log(lastArr); // [ 2, 4 ]
