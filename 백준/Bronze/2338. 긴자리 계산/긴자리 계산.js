const fs = require("fs");
const inputPath =
  process.platform === "darwin" ? __dirname + "/data.txt" : "/dev/stdin";
const [input0, input1] = fs.readFileSync(inputPath).toString().split("\n");

solve(input0, input1);

function solve(firstStr, secondStr) {
  const numA = BigInt(firstStr);
  const numB = BigInt(secondStr);
  console.log(String(numA + numB));
  console.log(String(numA - numB));
  console.log(String(numA * numB));
}