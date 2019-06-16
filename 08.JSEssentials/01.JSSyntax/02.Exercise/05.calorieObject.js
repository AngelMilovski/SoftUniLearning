function calorieObject(params) {
    return params
        .reduce((acc, cur, inx) => {
            if (inx % 2 === 0) {
                acc[cur] = 0;
            } else {
                acc[params[inx - 1]] = +cur;
            }
            return acc;
        }, {});
}

console.log(calorieObject(['Yoghurt', 48, 'Rise', 138, 'Apple', 52]));