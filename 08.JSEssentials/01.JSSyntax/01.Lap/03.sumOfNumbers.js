function sumOfNumbers(firstInput, secondInput) {
    let start = +firstInput;
    let end = +secondInput + 1;
    if (start < end) {
        return Array
            .apply(null, Array(end - start))
            .map((element, index) => {
                element = index + start;
                return element;
            })
            .reduce((acc, cur) => acc + cur, 0);
    }
    return 0;
}

let result = sumOfNumbers('1', '5');
console.log(result);
result = sumOfNumbers('-8', '20');
console.log(result);
