const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

/**
 * Doubles the provided number.
 *
 * Example:
 * doubleNumber(5); // 10
 *
 * @param {number} number The number to double.
 * @return {number} The doubled value of the input number.
 */
function doubleNumber(number) {
  return number * 2;
}

function main() {
  console.log('---------------------');
  console.log('Double Number Program');
  console.log("Type 'exit' to quit the program.");
  console.log('---------------------');
  console.log();

  const askForNumber = () => {
    rl.question('Enter a number: ', (userInput) => {
      if (userInput.toLowerCase() === 'exit') {
        console.log('Exiting program.');
        rl.close();
        return;
      }

      try {
        const inputNumber = parseFloat(userInput);
        const doubledResult = doubleNumber(inputNumber);
        console.log(`Doubled number: ${inputNumber} * 2 = ${doubledResult.toFixed(2)}`);
      } catch (e) {
        console.log('Invalid input. Please enter a valid number or type \'exit\' to quit the program.');
      }
      console.log();
      askForNumber();
    });
  };

  askForNumber();
}

main();
