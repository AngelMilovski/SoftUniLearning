function circleArea(r) {
    return typeof r === 'number' ?
    (r ** 2 * Math.PI).toFixed(2) :
    `We can not calculate the circle area, because we receive a ${typeof r}.`;
}

let result = circleArea(0);
console.log(result);
result = circleArea(5);
console.log(result);