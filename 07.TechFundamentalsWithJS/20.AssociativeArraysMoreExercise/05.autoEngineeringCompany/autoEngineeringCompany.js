function solve(params) {
    let carsArray = params.map(e => {
        let carInfo = e.split(' | ');
        return {
            brand: carInfo[0],
            model: carInfo[1],
            produced: +carInfo[2]
        };
    });

    let dataCars = carsArray.reduce((acc, curr) => {
        if (!acc[curr.brand]) {
            acc[curr.brand] = {};
            acc[curr.brand][curr.model] = curr.produced;
            return acc;
        }
        if (!acc[curr.brand][curr.model]) {
            acc[curr.brand][curr.model] = curr.produced;
            return acc;
        }
        acc[curr.brand][curr.model] += curr.produced;
        return acc;
    }, {});

    Object
        .entries(dataCars)
        .forEach(item => {
            console.log(item[0]);
            Object
                .keys(item[1])
                .forEach(model => {
                    console.log(`###${model} -> ${item[1][model]}`);
                });
        });
}

solve([
    'Audi | Q7 | 1000',
    'Audi | Q7 | 2000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10'
]);