function roadRadar(params) {
    let roads = {
        motorway: 130,
        interstate: 90,
        city: 50,
        residential: 20
    };

    if (params[0] - roads[params[1]] > 40) {
        return 'reckless driving';
    } else if (params[0] - roads[params[1]] > 20 && params[0] - roads[params[1]] <= 40) {
        return 'excessive speeding ';
    } else if (params[0] - roads[params[1]] > 0 && params[0] - roads[params[1]] <= 20) {
        return 'speeding';
    } else {
        return '';
    }
}

console.log(roadRadar([21, 'residential']));

