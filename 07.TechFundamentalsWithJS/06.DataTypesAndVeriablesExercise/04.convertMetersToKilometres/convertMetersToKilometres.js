function solve(input) {
    const meters = +input;
    const convertedToKm = meters / 1000;
    return convertedToKm.toFixed(2);
}

const result = solve(798);
console.log(result);