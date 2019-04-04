function isLeapYear(input) {
    const year = +input;
    if ((year % 4 === 0 && year % 100 !== 0) || year % 400 === 0) {
        return 'yes';
    }
    return 'no';
}

console.log(isLeapYear(1984));
console.log(isLeapYear(1615));
console.log(isLeapYear(4));