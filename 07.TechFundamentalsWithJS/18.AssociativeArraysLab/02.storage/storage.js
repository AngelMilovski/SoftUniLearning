function solve(input) {
    let storage = {};
    for (const item of input) {
        const parts = item.split(' ');
        const product = parts[0];
        const quantity = +parts[1];
        if (!storage.hasOwnProperty(product)) {
            storage[product] = quantity;
        } else {
            let currentQuantity = storage[product];
            currentQuantity += quantity;
            storage[product] = currentQuantity;
        }
    }

    Object.keys(storage).forEach((key) => {
        console.log(`${key} -> ${storage[key]}`);
    });
    // for (const product in storage) {
    //     console.log(`${product} -> ${storage[product]}`);
    // }

    // let storage = new Map();
    // for (const item of input) {
    //     const parts = item.split(' ');
    //     const product = parts[0];
    //     let quantity = +parts[1];
    //     if (storage.has(product)) {
    //         quantity += storage.get(product);
    //     }
    //     storage.set(product, quantity);
    // }

    // [...storage].forEach((value) => {
    //     console.log(value[0], value[1]);
    // });

}

solve([
    'tomatoes 10',
    'coffee 5',
    'olives 100',
    'coffee 40'
]);