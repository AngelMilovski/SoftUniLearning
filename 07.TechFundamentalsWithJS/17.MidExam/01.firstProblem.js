function solve(params) {
    let days = +params[0];
    let group = +params[1];
    let energy = +params[2];
    let water = days * group * (+params[3]);
    let food = days * group * +params[4];

    let index = 5;
    for (let i = 1; i <= days; i++) {
        let energyLost = +params[index++];
        energy -= energyLost;
        if (energy <= 0) {
            console.log(`You will run out of energy. You will be left with ${food.toFixed(2)} food and ${water.toFixed(2)} water.`);
            return;
        }
        if (i % 2 === 0) {
            energy = energy + (energy / 100 * 5);
            water = water - (water / 100 * 30);
        }
        if (i % 3 === 0) {
            energy = energy + (energy / 100 * 10);
            food = food - (food / group);
        }
    }

    if (energy > 0) {
        console.log(`You are ready for the quest. You will be left with - ${energy.toFixed(2)} energy!`);
    } else {
        console.log(`You will run out of energy. You will be left with ${food.toFixed(2)} food and ${water.toFixed(2)} water.`);
    }
}

solve([
    '10',
    '7',
    '5035.5',
    '11.3',
    '7.2',
    '942.3',
    '500.57',
    '520.68',
    '540.87',
    '505.99',
    '630.3',
    '784.20',
    '321.21',
    '456.8',
    '330'
]);