function solve(firstNumber, secondNumber) {
    const m = +firstNumber;
    const n = +secondNumber;
    if (m > n) {
        for (let i = m; i >= n; i--) {
            console.log(i);
        }
    }
}

solve(5, 1);