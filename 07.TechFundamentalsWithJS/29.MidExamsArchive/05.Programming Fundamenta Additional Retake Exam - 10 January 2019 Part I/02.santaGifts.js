function solve(params) {
    params.shift();
    let steps;
    let houses = params.shift().split(' ').map(Number);
    let currentPosition = 0;
    for (const line of params) {
        let tokens = line.split(' ');
        let command = tokens[0];

        switch (command) {
            case 'Forward':
                steps = +tokens[1];
                if (currentPosition + steps <= houses.length - 1) {
                    currentPosition += steps;
                    houses.splice(currentPosition, 1);
                }
                break;

            case 'Back':
                steps = +tokens[1];
                if (currentPosition - steps >= 0) {
                    currentPosition -= steps;
                    houses.splice(currentPosition, 1);
                }
                break;

            case 'Gift':
                let index = +tokens[1];
                let value = +tokens[2];
                if (index >= 0 && index < houses.length) {
                    currentPosition = index;
                    houses.splice(index, 0, value);
                }
                break;

            case 'Swap':
                let firstHouseValue = +tokens[1];
                let secondHouseValue = +tokens[2];
                let firstHouseIndex = houses.indexOf(firstHouseValue);
                let secondHouseIndex = houses.indexOf(secondHouseValue);
                if (firstHouseIndex >= 0 && secondHouseIndex >= 0) {
                    houses.splice(firstHouseIndex, 1, secondHouseValue);
                    houses.splice(secondHouseIndex, 1, firstHouseValue);
                }
                break;
        }
    }

    console.log('Position: ' + currentPosition);
    console.log(houses.join(', '));
}

// solve([
//     '6',
//     [50, 40, 25, 63, 78, 54, 66, 77, 24, 87],
//     'Forward 4',
//     'Back 3',
//     'Forward 3',
//     'Gift 2 88',
//     'Swap 50 87',
//     'Forward 1'
// ]);
solve([
    '5',
    '55 500 54 78 98 24 30 47 69 58',
    'Forward 1',
    'Swap 54 47',
    'Gift 1 20',
    'Back 1',
    'Forward 3'
]);