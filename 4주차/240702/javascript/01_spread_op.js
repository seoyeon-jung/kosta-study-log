const [name, ...info] = ["최민식", 50, "서울"];

console.log("name: ", name);
console.log("info: ", info);
/* name:  최민식
info:  [ 50, '서울' ]
*/

const names = ["최민식", "유해진", "이도현", "김고은"];
const stars = ["이도현", ...names, ...names];

console.log(stars);
/* [
  '이도현', '최민식',
  '유해진', '이도현',
  '김고은', '최민식',
  '유해진', '이도현',
  '김고은'
] */

const fruits = ["사과", "오렌지", "딸기", "수박"];
const [apple, orange, ...rest] = fruits;
console.log(rest); // ['딸기', '수박']

let me = {
  my_name: "정서연",
  my_age: 26,
  my_region: "서울",
  my_email: "example@example.com",
};

const { my_name, my_age, ...my_rest } = me;
console.log(my_rest); // { my_region: '서울', my_email: 'example@example.com' }
