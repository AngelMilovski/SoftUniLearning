function solve() {
    let output = document.getElementById('expressionOutput');
    let outputResult = document.getElementById('resultOutput');
    let btns = document.querySelectorAll('button');
    [...btns].forEach(btn => btn.addEventListener('click', callback));

    function callback(evt) {
        switch (evt.target.value) {
            case 'Clear':
                clearOutputs();
                break;

            case '=':
                calculate();
                break;

            default:
                fillExpressionOutput(evt.target.value);
                break;
        }
    }

    function fillExpressionOutput(value) {
        if (!/[\d.]/.test(value)) {
            value = ' ' + value + ' ';
        }
        output.textContent += value;
    }

    function clearOutputs() {
        output.textContent = '';
        outputResult.textContent = '';
    }

    function calculate() {
        let array = (output.textContent).split(' ').filter(e => e !== '');
        let result = NaN;
        let leftOperand = +array[0];
        let operator = array[1];
        let rightOperand = +array[2];
        switch (operator) {
            case '+':
                result = leftOperand + rightOperand;
                break;

            case '-':
                result = leftOperand - rightOperand;
                break;

            case '*':
                result = leftOperand * rightOperand;
                break;

            case '/':
                if (rightOperand !== 0) {
                    result = leftOperand / rightOperand;
                } 
                break;
        }

        outputResult.textContent = result;
    }
}
