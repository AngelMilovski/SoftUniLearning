const Calculator = require('../models/Calculator');

module.exports = {
    indexGet: (req, res) => {
        console.log(req.params);
        res.render('home/index');
    },

    indexPost: (req, res) => {
        const leftOperand = +req.body.calculator.leftOperand;
        const operator = req.body.calculator.operator;
        const rightOperand = +req.body.calculator.rightOperand;
        const calculator = new Calculator(leftOperand, operator, rightOperand);
        const result = calculator.calculateResult();
        const model = {
            calculator,
            result
        };
        res.render('home/index', model);
    }
};