function solve(arr) {
    const streets = arr.shift().split(', ');
    let neighborhoods = {};
    for (let street of streets) {
        neighborhoods[street] = [];

    }

    for (let string of arr) {
        const parts = string.split(' - ');
        const [streetName, personName] = parts;
        if (neighborhoods.hasOwnProperty(streetName)) {
            neighborhoods[streetName].push(personName);
        }
    }
    Object
        .entries(neighborhoods)
        .sort((a, b) => sorted(a, b))
        .forEach((item) => {
            console.log(`${item[0]}: ${item[1].length}`);
            for (let person of item[1]) {
                console.log('--' + person);
            }
        });

    function sorted(a, b) {
        return b[1].length - a[1].length;
    }
}

solve([
    'Abbey Street, Herald Street, Bright Mews',
    'Bright Mews - Garry',
    'Bright Mews - Andrea',
    'Invalid Street - Tommy',
    'Abbey Street - Billy'
]);