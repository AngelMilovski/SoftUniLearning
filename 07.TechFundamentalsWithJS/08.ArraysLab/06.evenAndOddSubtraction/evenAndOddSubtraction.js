function evenAndOddSubtraction(arr) {
    const array = arr.map(Number);
    const sumOfEvenEl = array
        .filter(el => el % 2 === 0)
        .reduce((acc, curr) => {
            acc += curr;
            return acc;
        }, 0);

    const sumOfOddEl = array
        .filter((el) => {
            return el % 2 === 1 || el % 2 === -1;
        })
        .reduce((acc, curr) => {
            acc += curr;
            return acc;
        }, 0);

    return sumOfEvenEl - sumOfOddEl;
}

const result = evenAndOddSubtraction([0, -1, 2 , 3, 4]);
console.log(result);