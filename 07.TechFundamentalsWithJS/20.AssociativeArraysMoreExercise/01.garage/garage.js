function garage(params) {
    let garage = new Map();
    for (const line of params) {
        let parts = line.split(' - ');
        let number = parts[0];
        let carInfo = parts[1];

        if (!garage.has(number)) {
            garage.set(number, []);
        }
        garage.get(number).push(carInfo);
    }

    [...garage.entries()]
        .forEach((g) => {
            console.log(`Garage № ${g[0]}`);
            g[1]
                .forEach(kvp => {
                    kvp = kvp.replace(/: /g, ' - ');
                    console.log(`--- ${kvp}`);
                });
        });
}

garage([
    '1 - color: blue, fuel type: diesel',
    '1 - color: red, manufacture: Audi',
    '2 - fuel type: petrol',
    '4 - color: dark blue, fuel type: diesel, manufacture: Fiat'
]);