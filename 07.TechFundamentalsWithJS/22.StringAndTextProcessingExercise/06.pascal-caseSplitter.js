function solve(params) {
    return params
        .split('')
        .reduce((acc, curr) => {
            if (isCapitalLetter(curr)) {
                acc += ' '; 
            }
            acc += curr;
            return acc;
        }, '')
        .trim()
        .split(' ')
        .join(', ');

    function isCapitalLetter(letter) {
        let char = letter;
        return char === letter.toUpperCase();
    }
}

let result = solve('SplitMeIfYouCanHaHaYouCantOrYouCan');
console.log(result);
result = solve('HoldTheDoor');
console.log(result);
result = solve('ThisIsSoAnnoyingToDo');
console.log(result);