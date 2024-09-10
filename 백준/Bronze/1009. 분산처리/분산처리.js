const fs = require("fs");
const inputPath =
  process.platform === "darwin" ? __dirname + "/data.txt" : "/dev/stdin";
const input = fs.readFileSync(inputPath).toString().trim().split("\n");
input.shift();
// const T = Number(input[0]);

for (let index = 0; index < input.length; index++) {
  let [a, b] = input[index].split(" ").map(Number);

  // console.log(`a:${a}, b:${b} a^b:${BigInt(a) ** BigInt(b)}`);
  a = getLastDigit(a);
  if (a === 0) console.log(10);
  else if (a === 1) console.log(1);
  else if (a === 5) console.log(5);
  else if (a === 6) console.log(6);
  else solve(a, b);
}

function solve(a, b) {
  let lastDigitResult = a;
  const repeateTime = getRepeateTime(a);
  b = b % getRepeateTime(a);
  // console.log(`나머지 ${b}`);
  if (b === 0) {
    b = repeateTime;
  }
  for (let index = 0; index < b - 1; index++) {
    const c = a * lastDigitResult;
    lastDigitResult = getLastDigit(c);
  }
  console.log(lastDigitResult);
}

function getLastDigit(num) {
  if (10 > num) return num;
  const str = String(num);
  return Number(str[str.length - 1]);
}

function getRepeateTime(num) {
  const repeateArr = [num];
  while (true) {
    repeateArr.push(getLastDigit(num * repeateArr[repeateArr.length - 1]));
    if (repeateArr[0] === repeateArr[repeateArr.length - 1]) {
      repeateArr.pop();
      break;
    }
  }
  // console.log(`getRepeateTime ${repeateArr.length}`);
  return repeateArr.length;
}