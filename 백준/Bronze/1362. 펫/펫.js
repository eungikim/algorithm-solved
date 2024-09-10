
const fs = require("fs");
const inputPath =
  process.platform === "darwin" ? __dirname + "/data.txt" : "/dev/stdin";
const scenario = fs.readFileSync(inputPath).toString().trim().split("\n");

const PetStatus = {
  HAPPY: ":-)",
  SAD: ":-(",
  DIED: "RIP",
};

solve(scenario);

function solve(petScenario) {
  let scenarioNumber = 0;
  while (true) {
    let [appropriateWeight, currentWeight] = petScenario
      .shift()
      .split(" ")
      .map(Number);
    if (appropriateWeight === 0) break;
    scenarioNumber++;
    let isDead = false;

    while (true) {
      const [cmd, value] = petScenario.shift().split(" ");
      if (cmd === "E" && !isDead) {
        currentWeight -= Number(value);
        if (currentWeight <= 0) {
          isDead = true;
        }
      } else if (cmd === "F" && !isDead) {
        currentWeight += Number(value);
      } else if (cmd === "#") {
        printPetStatus(scenarioNumber, appropriateWeight, currentWeight);
        break;
      }
    }
  }
}

function printPetStatus(scenarioNumber, appropriateWeight, currentWeight) {
  if (currentWeight <= 0) {
    console.log(`${scenarioNumber} ${PetStatus.DIED}`);
  } else if (
    appropriateWeight / 2 < currentWeight &&
    currentWeight < appropriateWeight * 2
  ) {
    console.log(`${scenarioNumber} ${PetStatus.HAPPY}`);
  } else {
    console.log(`${scenarioNumber} ${PetStatus.SAD}`);
  }
}
