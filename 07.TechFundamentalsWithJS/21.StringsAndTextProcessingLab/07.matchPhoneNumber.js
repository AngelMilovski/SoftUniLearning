function solve(input) {
    let pattern = /(?<=\s|^)\+359(\s|-)2\1[0-9]{3}\1[0-9]{4}\b/g;
    let validNumbers = [];
    while ((validNumber = pattern.exec(input)) !== null) {
        validNumbers.push(validNumber);
    }
    console.log(validNumbers.join(', '));
}

solve("+359 2 222 2222,359-2-222-2222, +359/2/222/2222, +359-2 222 2222 +359 2-222-2222, +359-2-222-222, +359-2-222-22222 +359-2-222-2222");