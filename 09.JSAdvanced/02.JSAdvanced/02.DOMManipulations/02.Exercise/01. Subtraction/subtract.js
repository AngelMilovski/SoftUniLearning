function subtract() {
    const num1 = +document.querySelector('#firstNumber').value;
    const num2 = +document.querySelector('#secondNumber').value;
    const result = num1 - num2;
    document.querySelector('#result').innerHTML = result;
}