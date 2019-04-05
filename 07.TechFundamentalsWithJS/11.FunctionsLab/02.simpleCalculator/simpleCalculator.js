function calculate(first, second, operator) {
    first = +first;
    second = +second;

    switch (operator) {
        case 'multiply':  return ((a, b) => a * b)(first, second);

        case 'divide': return ((a, b) => a / b)(first, second);

        case 'add': return ((a, b) => a + b)(first, second);
    
        case 'subtract': return ((a, b) => a - b)(first, second);
    }
}
const result = calculate(10, 100, 'multiply');
console.log(result);
