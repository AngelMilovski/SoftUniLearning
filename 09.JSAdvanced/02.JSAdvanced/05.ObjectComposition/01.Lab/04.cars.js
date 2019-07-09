function solve(array) {
    let allCars = {};
    let cars = (function () {
        const createCar = function name(params) {
            if (params.length == 1) {
                allCars[params[0]] = Object.create({});
            } else {
                allCars[params[0]] = Object.create(allCars[params[1]]);
            }
        };

        const set = function (name, key, value) {
            allCars[name][key] = value;
        };

        const print = function (carName) {
            let newArr = [];
            for (const key in allCars[carName]) {
                newArr.push(`${key}:${allCars[carName][key]}`);
            }

            console.log(newArr.join(', '));
        };

        return {
            createCar,
            set,
            print
        };
    })();

    array
        .forEach((line) => {
            const parts = line.split(' ');
            if (parts.length === 2) {
                if (parts.includes('create')) {
                    cars.createCar([parts[1]]);
                } else {
                    cars.print(parts[1]);
                }
            } else {
                if (parts.includes('create')) {
                    const carName = parts[1];
                    const parentCar = parts[3];
                    cars.createCar([carName, parentCar]);
                } else {
                    cars.set(parts[1], parts[2], parts[3]);
                }
            }
        });
}

solve([
    'create c1',
    'create c2 inherit c1',
    'set c1 color red',
    'set c2 model new',
    'print c1',
    'print c2']);