function catalogue(params) {
    let productsCatalogue = {};
    let objOfKey;
    for (const line of params) {
        const data = line.split(' : ');
        const [productName, productPrice] = data;
        const key = productName.substring(0, 1);
        if (!productsCatalogue.hasOwnProperty(key)) {
            objOfKey = productsCatalogue[key] = {};
            addProduct(objOfKey, productName, productPrice);
        } else {
            if (!productsCatalogue[key].hasOwnProperty(productName)) {
                objOfKey = productsCatalogue[key];
                addProduct(objOfKey, productName, productPrice);
            }
        }
    }

    printCatalogue(productsCatalogue);

    function addProduct(objOfKey, productName, productPrice) {
        objOfKey[productName] = productPrice;
    }

    function printCatalogue(productsCatalogue) {
        const sortedKeys = Object.keys(productsCatalogue).sort((a, b) => a.localeCompare(b));
        for (const key of sortedKeys) {
            console.log(key);
            printProducts(productsCatalogue[key]);
        }

        function printProducts(obj) {
            Object.entries(obj)
                .sort((a, b) => a[0].localeCompare(b[0]))
                .forEach(p => console.log(`  ${p[0]}: ${p[1]}`));
        }
    }
}

catalogue([
    'Appricot : 20.4',
    'Appricot : 20.4',
    'Apple : 1.25',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10'
]);