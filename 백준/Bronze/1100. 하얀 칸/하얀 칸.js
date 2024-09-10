const fs = require("fs");
const inputPath =
  process.platform === "darwin" ? __dirname + "/data.txt" : "/dev/stdin";
const chessRowArr = fs.readFileSync(inputPath).toString().trim().split("\n");

solve(chessRowArr);

function solve(chessRowArr) {
  let whitePieceNumber = 0;
  chessRowArr.forEach((currentRow, index) => {
    whitePieceNumber += getWhiteChessPiece(currentRow, index % 2 == 0);
  });
  console.log(whitePieceNumber);
}

function getWhiteChessPiece(chessRow, startWhiteSquare) {
  let whitePieceNumber = 0;
  for (let index = 0; index < chessRow.length; index++) {
    const pieceInSquare = chessRow[index];
    if (startWhiteSquare && index % 2 == 0 && pieceInSquare === "F")
      whitePieceNumber++;
    else if (!startWhiteSquare && index % 2 == 1 && pieceInSquare === "F")
      whitePieceNumber++;
  }
  return whitePieceNumber;
}