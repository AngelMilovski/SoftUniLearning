function solve(item) {
    let number = +item;
    if (number % 10 === 0) {
        return 'The number is divisible by 10';
    } else if (number % 7 === 0) {
        return 'The number is divisible by 7';
    } else  if (number % 6 === 0) {
        return 'The number is divisible by 6';
    } else if (number % 3 === 0) {
        return 'The number is divisible by 3';
    } else if (number % 2 === 0) {
        return 'The number is divisible by 2';
    } else {
        return 'Not divisible';
    }
} 

console.log(solve(30));
console.log(solve(15));
console.log(solve(12));
console.log(solve(1643));