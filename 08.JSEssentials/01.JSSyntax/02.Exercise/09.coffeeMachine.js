function coffeeMachine(params) {
    let machineCoins = 0;

    params.forEach((line) => {
        let data = line.split(', ');
        let insertedCoins = +data[0];
        let type = data[1];
        let sugar = +data[data.length - 1];
        let coast = type === 'coffee' && data[2] === 'decaf' ? 0.90 : 0.80;

        if (data.length >= 4 && data[2] === 'milk' || data[3] === 'milk') {
            coast = +(coast + (coast / 100 * 10)).toFixed(1);
        }

        if (sugar > 0) {
            coast += 0.10;
        }

        let diff = Math.abs(insertedCoins - coast).toFixed(2);
        if (insertedCoins >= coast) {
            console.log(`You ordered ${type}. Price: $${coast.toFixed(2)} Change: $${diff}`);
            machineCoins += coast;
        } else {
            console.log(`Not enough money for ${type}. Need $${diff} more.`);
        }
    });

    console.log(`Income Report: $${machineCoins.toFixed(2)}`);
}

coffeeMachine(['1.00, coffee, caffeine, milk, 4', '0.40, tea, milk, 2', '1.00, coffee, decaf, 0']);