function breadFactory(params) {
    const events = params[0].split('|');
    let currentEnergy = 100;
    let currentCoins = 100;
    for (const line of events) {
        let [command, number] = line.split('-');
        number = +number;
        switch (command) {
            case 'rest':
                let energyNumber = number;
                const energy = Math.min(currentEnergy + energyNumber, 100);
                console.log(`You gained ${energy - currentEnergy} energy.`);
                currentEnergy = energy;
                console.log(`Current energy: ${currentEnergy}.`);
                break;

            case 'order':
                const earnedCoins = number;
                if (currentEnergy - 30 < 0) {
                    console.log(`You had to rest!`);
                    currentEnergy += 50;
                } else {
                    currentEnergy -= 30;
                    currentCoins += earnedCoins;
                    console.log(`You earned ${earnedCoins} coins.`);
                }
                break;

            default:
                const ingredient = command;
                const ingredientCoins = number;
                currentCoins -= ingredientCoins;
                if (currentCoins > 0) {
                    console.log(`You bought ${ingredient}.`);
                } else {
                    console.log(`Closed! Cannot afford ${ingredient}.`);
                    return;
                }
                break;
        }
    }

    console.log('Day completed!');
    console.log('Coins: ' + currentCoins);
    console.log('Energy: ' + currentEnergy);
}

breadFactory(['rest-2|order-10|eggs-100|rest-10']);