const fs = require("fs");
const inputPath =
  process.platform === "darwin" ? __dirname + "/exp_data.txt" : "/dev/stdin";
const [input0, input1] = fs.readFileSync(inputPath).toString().split(" ");
// readFileSync('dd', {encoding:'utf8', flag:'r'})

const result = solve(input0, input1);
console.log(result);

function solve(firstStr, secondStr) {
  const numA = Number(firstStr);
  const numB = Number(secondStr);
  return numA + numB;
}
