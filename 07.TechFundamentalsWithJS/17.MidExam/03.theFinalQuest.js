function solve(params) {
    let array = params.shift().split(' ');
    params.pop();
    
    for (let line of params) {
        let tokens = line.split(' ');
        let command = tokens[0];
        switch (command) {
            case 'Delete':
                let index = +tokens[1];
                if (index >= 0 && index < array.length - 1) {
                    array.splice(index + 1, 1);
                }
                break;
        
            case 'Swap':
                let firstWord = tokens[1];
                let secondWord = tokens[2];
                let firstIndex = array.indexOf(firstWord);
                let secondIndex = array.indexOf(secondWord);
                if (firstIndex > -1 && secondIndex > -1) {
                    array.splice(firstIndex, 1, secondWord);
                    array.splice(secondIndex, 1, firstWord);
                }
                break;

            case 'Put':
                let word = tokens[1];
                let currentIndex = +tokens[2];
                let prevIndex = currentIndex - 1;
                if (prevIndex >= 0 && prevIndex <= array.length) {
                    array.splice(prevIndex, 0, word);
                }
                break;

            case 'Sort':
                array = array.sort((a, b) => b.localeCompare(a));
                break;

            case 'Replace':
                let word1 = tokens[1];
                let word2 = tokens[2];
                let word2Index = array.indexOf(word2);
                if (word2Index > -1) {
                    array.splice(word2Index, 1, word1);
                }
                break;
        }
    }

    return array.join(' ');
}

let result = solve([
    'Congratulations! You last also through the have challenge!',
    'Swap have last',
    'Replace made have',
    'Delete 2',
    'Put it 4',
    'Stop'
]);
console.log(result);

result = solve([
    'This the my quest! final',
    'Put is 2',
    'Swap final quest!',
    'Delete 2',
    'Stop'
]);
console.log(result);