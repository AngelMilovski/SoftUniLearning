function solve(params) {
    let homesCount = +params[0];
    let initialPresents = +params[1];
    let presentsNumber = initialPresents;
    let homes = [];
    let additionalPresentsTaken = 0;
    let countHeWentBack = 0;

    for (let i = 2; i < params.length; i++) {
        homes.push(+params[i]);
    }

    for (let i = 1; i <= homesCount; i++) {
        let reminderHomes = homes.length - i;
        let children = homes[i - 1];
        if (presentsNumber < children) {
            let neededPresents = children - presentsNumber;
            presentsNumber = parseInt(initialPresents / i) * reminderHomes + neededPresents;
            additionalPresentsTaken += presentsNumber;
            presentsNumber -= neededPresents;
            countHeWentBack += 1;
        } else {
            presentsNumber -= children;
        }
    }

    if (countHeWentBack > 0) {
        console.log(countHeWentBack);
        console.log(additionalPresentsTaken);
    } else {
        console.log(presentsNumber);
    }
}

// solve([
//     '5',
//     '20',
//     '2',
//     '1',
//     '3',
//     '9',
//     '5'
// ]);
solve([
    '4',
    '20',
    '12',
    '10',
    '3',
    '9',
    
]);