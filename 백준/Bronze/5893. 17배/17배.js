const fs = require("fs");
const inputPath =
  process.platform === "darwin" ? __dirname + "/data.txt" : "/dev/stdin";
const N = fs.readFileSync(inputPath).toString();

solve(N);

function solve(binaryString) {
  let num = BigInt("0b" + binaryString);
  num = num * 17n;
  console.log(num.toString(2));
}