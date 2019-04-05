function solve(args) {
    let numbers = args.slice();
    const endIndex = numbers.length - 1;
    for (let i = 0; i < endIndex; i++) {
        let condensed = [];
        for (let j = 0; j < numbers.length - 1; j++) {
            const current = numbers[j];
            const next = numbers[j + 1];
            condensed.push(current + next);
        }
        numbers = condensed.slice();
    }
    return numbers[0];
}

const result = solve([2, 10, 3]);
console.log(result);