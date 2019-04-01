function solve(input) {
    let grade = +input;
    return (grade >= 5.50) ? 'Excellent' : 'Not excellent';
}

console.log(solve(5.50));