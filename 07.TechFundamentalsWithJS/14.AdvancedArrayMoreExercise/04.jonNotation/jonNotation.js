function jonNotation(params) {
    let firstOperand,
        secondOperand,
        sum;
    let numbers = [];

    for (let item of params) {
        if (isNaN(item)) {
            switch (item) {
                case '+':
                if (numbers.length > 1) {
                    secondOperand = numbers.pop();
                    firstOperand = numbers.pop();
                    sum = firstOperand + secondOperand;
                    numbers.push(sum);
                } else {
                    console.log('Error: not enough operands!');
                    return;
                }
                    break;

                case '-':
                if (numbers.length > 1) {
                    secondOperand = numbers.pop();
                    firstOperand = numbers.pop();
                    sum = firstOperand - secondOperand;
                    numbers.push(sum);
                } else {
                    console.log('Error: not enough operands!');
                    return;
                }
                    break;

                case '*':
                if (numbers.length > 1) {
                    secondOperand = numbers.pop();
                    firstOperand = numbers.pop();
                    sum = firstOperand * secondOperand;
                    numbers.push(sum);
                } else {
                    console.log('Error: not enough operands!');
                    return;
                }
                    break;

                case '/':
                if (numbers.length > 1) {
                    secondOperand = numbers.pop();
                    firstOperand = numbers.pop();
                    sum = firstOperand / secondOperand;
                    numbers.push(sum);
                } else {
                    console.log('Error: not enough operands!');
                    return;
                }
                    break;
            }
        } else {
            numbers.push(item);
        }
    }

    if (numbers.length > 1) {
        console.log('Error: too many operands!');
    } else {
        console.log(numbers.pop());
    }
}

jonNotation([-2, 1, '+', 101, '*', 18, '+', 3, '/']);