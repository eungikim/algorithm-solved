const fs = require("fs");
const inputPath =
  process.platform === "darwin" ? __dirname + "/data.txt" : "/dev/stdin";
const [A, B, V] = fs
  .readFileSync(inputPath)
  .toString()
  .trim()
  .split(" ")
  .map(Number);

solve(A, B, V);

function solve(climb, slide, height) {
  const hc = height - climb;
  const cs = climb - slide;
  console.log(Math.ceil(hc / cs) + 1);
}