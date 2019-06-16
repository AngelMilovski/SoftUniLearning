function solve(params) {
    let towns = {};
    let town;
    for (const input of params) {
        if (isNaN(input)) {
            town = input;
            if (!towns[town]) {
                towns[town] = 0;
            }
        } else {
            towns[town] += +input;
        }
    }

    console.log(JSON.stringify(towns));
}

solve([
    'Sofia',
    '20',
    'Varna',
    '3',
    'Sofia',
    '5',
    'Varna',
    '4'
]);