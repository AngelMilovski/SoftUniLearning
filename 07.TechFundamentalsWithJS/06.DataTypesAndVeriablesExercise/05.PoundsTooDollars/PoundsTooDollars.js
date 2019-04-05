function solve(input) {
    const pounds = +input;
    const priceOfOnePoundInDollars = 1.31;
    const convertedPoundsToDollars = pounds * priceOfOnePoundInDollars;
    return convertedPoundsToDollars.toFixed(3);
}

const result = solve(80);
console.log(result);