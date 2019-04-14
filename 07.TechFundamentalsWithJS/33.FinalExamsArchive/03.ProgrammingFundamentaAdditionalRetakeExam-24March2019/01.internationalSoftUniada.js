function solve(params) {
    let countries = {};
    let i = 0;
    for (const line of params) {
        if (params[i++] === 'END') {
            break;
        }

        let [countryName, contestantName, contestantPoints] = line.split(' -> ');
        contestantPoints = +contestantPoints;
        if (!countries.hasOwnProperty(countryName)) {
            countries[countryName] = {};
            countries[countryName][contestantName] = contestantPoints;
            countries[countryName].totalPoints = contestantPoints;
        } else {
            if (!countries[countryName].hasOwnProperty(contestantName)) {
                countries[countryName][contestantName] = 0;
            }
            countries[countryName][contestantName] += contestantPoints;
            countries[countryName].totalPoints += contestantPoints;
        }
    }

    Object
        .keys(countries)
        .sort((a, b) => {
            return countries[b].totalPoints - countries[a].totalPoints;
        })
        .forEach((country) => {
            console.log(`${country}: ${countries[country].totalPoints}`);
            Object
                .entries(countries[country])
                .forEach((contestant) => {
                    if (contestant[0] !== 'totalPoints') {
                        console.log(`-- ${contestant[0]} -> ${contestant[1]}`);
                    }
                });
        });
}

// solve([
//     'Bulgaria -> Ivan Ivanov -> 25',
//     'Germany -> Otto Muller -> 4',
//     'England -> John Addams -> 10',
//     'Bulgaria -> Georgi Georgiev -> 18',
//     'England -> Valteri Bottas -> 8',
//     'Bulgaria -> Georgi Georgiev -> 6',
//     'END'
// ]);

console.log('------------------------------');

solve([
    'France -> Francois Arnaud -> 10',
    'France -> Pier Armand -> 22',
    'France -> Francois Arnaud -> 3',
    'Norway -> Botel Audun -> 14',
    'Switzerland -> Alexis Andersson -> 18',
    'Bulgaria -> Peter Petrov -> 25',
    'Bulgaria -> Peter Petrov -> 6',
    'END'
]);
