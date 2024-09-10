
const fs = require("fs");
const inputPath =
  process.platform === "darwin" ? __dirname + "/data.txt" : "/dev/stdin";
const [A, B] = fs
  .readFileSync(inputPath)
  .toString()
  .trim()
  .split(" ")
  .map(Number);

if (A > B) solve(B, A);
else solve(A, B);

function solve(firstNum, secondNum) {
  let result = 0;
  const HAP = firstNum + secondNum;
  const size = getSize(firstNum, secondNum);

  result = (HAP * size) / 2;
  console.log(result);
}

function getSize(firstNum, secondNum) {
  return secondNum - firstNum + 1;
}
