function solve(params) {
    let towns = {};

    for (const line of params) {
        let [town, population] = line.split(' <-> ');
        if (!towns[town]) {
            towns[town] = 0;
        }

        towns[town] += +population;
    }

    Object
        .entries(towns)
        .forEach(([town, population]) => {
            console.log(`${town} : ${population}`);
        });
}

solve([
    'Sofia <-> 1200000',
    'Montana <-> 20000',
    'New York <-> 10000000',
    'Washington <-> 2345000',
    'Las Vegas <-> 1000000'
]);