const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

/**
 * Different ways to format output in JavaScript.
 *
 * Prompts the user to enter their name, age and weight and then
 * displays the entered values in three different ways:
 *
 * 1. Using basic concatenation.
 * 2. Using template literals and formatting numbers.
 * 3. Using template literals with expressions.
 *
 * @see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Template_literals
 *
 * @function main
 */
function main() {
  console.log('---------------------');
  console.log('Output Formatting Program');
  console.log('---------------------');
  console.log();

  rl.question('Enter your name: ', (name) => {
    rl.question('Enter your age: ', (age) => {
      rl.question('Enter your weight: ', (weight) => {
        console.log();

        // Example 1 = Basic Concatenation:
        console.log('1. My name is ' + name + ', I am ' + age + ' years old and I weigh ' + weight + 'Kg');
        // Example 2 = Using Template Literals and formatting numbers:
        console.log(`2. My name is ${name}, I am ${age} years old and I weigh ${parseFloat(weight).toFixed(2)}Kg`);
        // Example 3 = Using Template Literals with expressions:
        console.log(`3. My name is ${name}, I am ${age} years old and I weigh ${weight}Kg`);

        rl.close();
      });
    });
  });
}

main();
