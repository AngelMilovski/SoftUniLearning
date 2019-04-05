function rosettaStone(params) {
    let lengthOfTemplate = +params.shift();
    let template = [];
    for (let i = 0; i < lengthOfTemplate; i++) {
        let line = params.shift().split(' ').map(Number);
        template.push(line);
    }

    let message = [];
    for (let i = 0; i < params.length; i++) {
        message.push(params[i].split(' ').map(Number));
    }

    for (let i = 0; i < message.length; i += template.length) {
        for (let j = 0; j < message[i].length; j += template[0].length) {
            getPairNumbers(message, template, i, j);
        }
    }

    let wheelOfLetter = [];
    for (let i = 0; i < 26; i++) {
        let letter = 65 + i;
        wheelOfLetter.push(String.fromCharCode(letter));
    }
    wheelOfLetter.unshift(' ');
    let decodedMessage = [];

    for (let i = 0; i < message.length; i++) {
        for (let j = 0; j < message[i].length; j++) {
            let number = message[i][j];
            decodedMessage.push(wheelOfLetter[number % wheelOfLetter.length]);
        }
    }

    return decodedMessage.join('');

    function getPairNumbers(message, template, row, col) {
        for (let i = 0; i < template.length; i++) {
            if (row + i >= message.length) {
                break;
            }
            for (let j = 0; j < template[i].length; j++) {
                if (col + j >= message[row].length) {
                    break;
                }
                message[row + i][j + col] += template[i][j];
            }
        }
    }
}

const output = rosettaStone([
    '1',
    '1 3 13',
    '12 22 14 13 25 0 4 24 23',
    '18 24 2 25 22 0 0 11 18',
    '8 25 6 26 8 23 13 4 14',
    '14 3 14 10 6 1 6 16 14',
    '11 12 2 10 24 2 13 24 0',
    '24 24 10 14 15 25 18 24 12',
    '4 24 0 8 4 22 19 22 14',
    '0 11 18 26 1 19 18 13 15',
    '8 15 14 26 24 14 26 24 14',
]);

console.log(output);

// console.log(36 % 27);