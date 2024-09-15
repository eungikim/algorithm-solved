const fs = require("fs");
const inputPath =
  process.platform === "darwin" ? __dirname + "/data.txt" : "/dev/stdin";
const [N, W, H, L] = fs
  .readFileSync(inputPath)
  .toString()
  .split(" ")
  .map(Number);

solve(N, W, H, L);

function solve(numOfCow, width, height, sizeOfRoom) {
  if (width < sizeOfRoom || height < sizeOfRoom) {
    console.log(0);
  } else {
    const widthQuotient = Math.floor(width / sizeOfRoom);
    const heightQuotient = Math.floor(height / sizeOfRoom);
    const result = widthQuotient * heightQuotient;

    console.log(Math.min(result, numOfCow));
  }
}