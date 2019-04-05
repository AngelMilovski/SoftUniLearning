function solve(input) {
    let students = {};

    for (const string of input) {
        const tokens = string.split(' ');
        const name = tokens.shift();
        let grades = tokens.map(Number);

        if (!students.hasOwnProperty(name)) {
            students[name] = [];
        }
        students[name] = students[name].concat(grades);
    }

     Object
        .entries(students)
        .sort((a, b) => average(a, b))
        .forEach((value) => {
            console.log(`${value[0]}: ${value[1].join(', ')}`);
        });

    function average(a, b) {
        const aSum = a[1].reduce((curr, occ) => {
            occ += curr;
            return occ;
        }, 0);
        const bSum = b[1].reduce((curr, occ) => {
            occ += curr;
            return occ;
        }, 0);

        const aAverage = aSum / a[1].length;
        const bAverage = bSum / b[1].length;
        return aAverage - bAverage;
    }
}

solve(['Lilly 4 6 6 5',
    'Tim 5 6',
    'Tammy 2 4 3',
    'Tim 6 6'
]);