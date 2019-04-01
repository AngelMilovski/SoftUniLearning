function lowerOrUpper(input) {
    const str = input;
    return str == str.toUpperCase() ? 'upper-case' : 'lower-case';
}

const result = lowerOrUpper('F');
console.log(result);