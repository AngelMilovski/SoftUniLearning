function largestNumber(num1, num2, num3) {
    return `The largest number is ${Math.max(...Array.call(null, num1, num2, num3))}.`;
}

let result = largestNumber(-3, -5, -22.5);
console.log(result);