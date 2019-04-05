function minerTask(input) {
    let resources = {};
    for (let i = 1; i <= input.length; i += 2) {
        const resource = input[i - 1];
        let quantity = +input[i];
        if (!resources.hasOwnProperty(resource)) {
            resources[resource] = 0;
        }
        const currentQuantity = resources[resource];
        quantity += currentQuantity;
        resources[resource] = quantity;
    }
    Object
        .keys(resources)
        .forEach((key) => {
            console.log(`${key} -> ${resources[key]}`);
        });
}

minerTask([
    'gold',
    '155',
    'silver',
    '10',
    'copper',
    '17',
    'gold',
    '15'
]);