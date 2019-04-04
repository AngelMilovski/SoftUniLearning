function solve(params) {
    const rooms = params[0].split('|');
    let currentHealth = 100;
    let currentCoins = 0;
    let bestRoom = 0;
    for (const line of rooms) {
        bestRoom += 1;
        let [command, number] = line.split(' ');
        number = +number;
        switch (command) {
            case 'potion':
                let healNumber = number;
                const heal = Math.min(currentHealth + healNumber, 100);
                console.log(`You healed for ${heal - currentHealth} hp.`);
                currentHealth = heal;
                console.log(`Current health: ${currentHealth} hp.`);
                break;

            case 'chest':
                const foundedCoins = number;
                currentCoins += foundedCoins;
                console.log(`You found ${foundedCoins} coins.`);
                break;

            default:
                const monsterName = command;
                const monsterDamage = number;
                currentHealth -= monsterDamage;
                if (currentHealth > 0) {
                    console.log(`You slayed ${monsterName}.`);
                } else {
                    console.log(`You died! Killed by ${monsterName}.`);
                    console.log('Best room: ' + bestRoom);
                    return;
                }
                break;
        }
    }

    console.log("You've made it!");
    console.log('Coins: ' + currentCoins);
    console.log('Health: ' + currentHealth);
}

solve(['potion 30|orc 200|chest 10|snake 25|chest 110']);