
const fs = require("fs");
const inputPath =
  process.platform === "darwin" ? __dirname + "/data.txt" : "/dev/stdin";
const fileNameArray = fs.readFileSync(inputPath).toString().trim().split("\n");
const numberOfFile = Number(fileNameArray.shift());

solve(numberOfFile, fileNameArray);

function solve(numberOfFile, fileNameArray) {
  let result = "";
  for (let i = 0; i < fileNameArray[0].length; i++) {
    const letter = fileNameArray[0][i];
    result += letter;

    for (let j = 1; j < numberOfFile; j++) {
      if (letter != fileNameArray[j][i]) {
        result = result.slice(0, -1) + "?";
        break;
      }
    }
  }
  console.log(result);
}
