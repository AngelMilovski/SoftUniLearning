function getOddAndEvenSum(input) {
    let numberToString = function convertNumberToString(num) {
        return '' + num;
    };
    input = numberToString(input);
    
    let arr = input.split('').map(Number);
    const oddSum = arr
        .filter(n => n % 2 != 0)
        .reduce((acc, curr) => {
            acc += curr;
            return acc;
        }, 0);

    const evenSum = arr
        .filter(n => n % 2 == 0)
        .reduce((acc, curr) => {
            acc += curr;
            return acc;
        }, 0);

    return `Odd sum = ${oddSum}, Even sum = ${evenSum}`;
}

const output = getOddAndEvenSum(1000435);
console.log(output);