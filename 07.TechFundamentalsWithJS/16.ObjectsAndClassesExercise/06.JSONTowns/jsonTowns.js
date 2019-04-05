function jsonTowns(params) {
    let arr = [];
    let keys = params.shift().split(/[\s|]+/).filter(v => v != '');
    for (const line of params) {
        let table = {};
        let [town, latitude, longitude] = line.split(/[\s|]+/).filter(v => v != '');
        latitude = +latitude;
        longitude = +longitude;
        table[keys[0]] = town;
        table[keys[1]] = +latitude.toFixed(2);
        table[keys[2]] = +longitude.toFixed(2);
        arr.push(JSON.stringify(table));
    }

    console.log(`[${arr.join(',')}]`);
}

jsonTowns([
    '| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |'
]);