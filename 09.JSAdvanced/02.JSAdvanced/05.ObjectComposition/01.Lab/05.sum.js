function result() {
    let number1;
    let number2;
    let result;
    return {
        init: function (num1, num2, res) {
            number1 = document.querySelector(num1);
            number2 = document.querySelector(num2);
            result = document.querySelector(res);
        },
        add: function () {
            result.value = +number1.value + (+number2.value);
        },
        subtract: function () {
            result.value = +number1.value - (+number2.value);
        }
    };
}
