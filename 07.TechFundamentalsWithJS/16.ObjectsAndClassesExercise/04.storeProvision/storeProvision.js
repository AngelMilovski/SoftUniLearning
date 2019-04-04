function storeProvision(params) {
    let store = {};
    const currentStock = params[0];
    for (let i = 0; i < currentStock.length; i++) {
        if (i % 2 === 0) {
            store[currentStock[i]] = +currentStock[i + 1];
        }
    }

    const orderedDelivery = params[1];
    for (let i = 0; i < orderedDelivery.length; i++) {
        const name = orderedDelivery[i];
        const quantity = +orderedDelivery[i + 1];
        if (i % 2 === 0) {
            if (store.hasOwnProperty(name)) {
                store[name] += quantity;
            } else {
                store[name] = quantity;
            }
        }
    }
    
    console.log(store);
}

storeProvision([
    ['Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'],
    ['Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30']
]);