function solve(params) {
    const searchedCar = params;
    const engines = [
        { power: 90, volume: 1800 },
        { power: 120, volume: 2400 },
        { power: 200, volume: 3500 }
    ];

    const carriages = {
        hatchback: { type: 'hatchback', color: `${searchedCar.color}` },
        coupe: { type: 'coupe', color: `${searchedCar.color}` }
    };

    const wheelsCount = 4;
    const wheels = Array.from({ length: wheelsCount }, () => {
        return params.wheelsize % 2 === 0 ?
            params.wheelsize - 1 :
            params.wheelsize;
    });

    return {
        model: searchedCar.model,
        engine: engines.find(e => e.power >= params.power),
        carriage: carriages[params.carriage],
        wheels
    };
}

const result = solve({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
});

console.log(result);