const readline = require('readline/promises');
const {stdin: input, stdout: output} = require('process');

const rl = readline.createInterface({input, output});

async function main() {
    try {
        const num1 = await rl.question('Enter first number: ');
        const num2 = await rl.question('Enter second number: ');

        const n1 = parseFloat(num1);
        const n2 = parseFloat(num2);

        const addition = n1 + n2;
        const subtraction = n1 - n2;
        const multiplication = n1 * n2;
        const division = n1 / n2;

        console.log();

        console.log(`Addition: ${n1} + ${n2} = ${addition}`);
        console.log(`Subtraction: ${n1} - ${n2} = ${subtraction}`);
        console.log(`Multiplication: ${n1} * ${n2} = ${multiplication}`);
        console.log(`Division: ${n1} / ${n2} = ${division}`);
    } catch (error) {
        console.error('An error occurred:', error);
    } finally {
        rl.close();
    }
}

main();
