function anonymousCache(params) {
    let data = {};
    let cache = {};

    let i = 0;
    for (const line of params) {
        if (params[i++] === 'thetinggoesskrra') {
            break;
        }
        let tokens = line.split(' -> ');
        if (tokens.length === 1) {
            let dataSet = tokens[0];
            if (!data.hasOwnProperty(dataSet)) {
                data[dataSet] = {};
                if (cache.hasOwnProperty(dataSet)) {
                    data[dataSet] = cache[dataSet];
                    cache = clearCache(cache, dataSet);
                }
            }

        } else {
            let dataKey = tokens[0];
            let [size, dataSet] = tokens[1].split(' | ');
            size = +size;
            if (!data.hasOwnProperty(dataSet)) {
                if (!cache.hasOwnProperty(dataSet)) {
                    cache[dataSet] = {};
                    cache[dataSet][dataKey] = size;
                } else {
                    if (!cache[dataSet].hasOwnProperty(dataKey)) {
                        cache[dataSet][dataKey] = 0;
                    }
                    cache[dataSet][dataKey] += size;
                }
            } else {
                if (!data[dataSet].hasOwnProperty(dataKey)) {
                    data[dataSet][dataKey] = 0;
                }
                data[dataSet][dataKey] += size;
            }
        }
    }

    let result = Object
        .entries(data)
        .sort((a, b) => {
            let aValues = Object
                .values(data[a[0]])
                .reduce((acc, cur) => acc + cur, 0);
            let bValues = Object
                .values(data[b[0]])
                .reduce((acc, cur) => acc + cur, 0);

            return bValues - aValues;
        })[0];

    if (result) {
        let totalSize = Object.values(result[1]).reduce((acc, cur) => acc += cur, 0);
        console.log(`Data Set: ${result[0]}, Total Size: ${totalSize}`);
        Object
            .keys(result[1])
            .forEach(key => console.log('$.' + key));
    }

    function clearCache(cache, dataSet) {
        return Object
            .entries(cache)
            .filter(e => e[0] !== dataSet)
            .reduce((acc, cur) => acc[cur[0]] = cur[1], {});
    }
}

anonymousCache([
    'Users',
    'BankAccounts',
    'ADDB444 -> 23111 | BankAccounts',
    'Students -> 2000 | Users',
    'Workers -> 24233 | Users',
    'thetinggoesskrra'
]);

// anonymousCache([
//     'Cars',
//     'Car1 -> 233333 | Cars',
//     'Car23 -> 266666 | Cars',
//     'Warehouse2 -> 10000 | Buildings',
//     'Warehouse3 -> 480000 | Buildings',
//     'Warehouse5 -> 100000 | Buildings',
//     'Buildings',
//     'thetinggoesskrra'
// ]);