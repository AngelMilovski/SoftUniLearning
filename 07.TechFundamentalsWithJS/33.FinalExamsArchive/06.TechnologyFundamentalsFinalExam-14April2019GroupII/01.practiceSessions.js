function solve(params) {
    let roads = {};

    let i = 0;
    for (const line of params) {
        if (params[i++] === 'END') {
            break;
        }
        let tokens = line.split('->');
        let command = tokens[0];
        switch (command) {
            case 'Add':
                let [road, racer] = [tokens[1], tokens[2]];
                if (!roads.hasOwnProperty(road)) {
                    roads[road] = [];
                }
                roads[road].push(racer);
                break;

            case 'Move':
                let [currentRoad, racerName, nextRoad] = [tokens[1], tokens[2], tokens[3]];
                    if (roads[currentRoad].includes(racerName)) {
                        let index = roads[currentRoad].indexOf(racerName);
                            let racer = roads[currentRoad].splice(index, 1)[0];
                            roads[nextRoad].push(racer);
                        }
                break;
            case 'Close':
                let roadName = tokens[1];
                if (roads.hasOwnProperty(roadName)) {
                    roads = removeRoad(roads, roadName);
                }
                break;
        }
    }

    console.log('Practice sessions:');
    Object
        .entries(roads)
        .sort((a, b) => {
            if (b[1].length - a[1].length !== 0) {
                return b[1].length - a[1].length;
            } else {
                return a[0].localeCompare(b[0]);
            }
        })
        .forEach((road) => {
            console.log(road[0]);
            roads[road[0]].forEach(racer => console.log('++' + racer));
        });

    function removeRoad(obj, road) {
        return Object
            .entries(obj)
            .filter(e => e[0] !== road)
            .reduce((acc, cur) => {
                acc[cur[0]] = cur[1];
                return acc;
            }, {});
    }
}

// solve([
//     'Add->Glencrutchery Road->Giacomo Agostini',
//     'Add->Braddan->Geoff Duke',
//     'Add->Peel road->Mike Hailwood',
//     'Add->Glencrutchery Road->Guy Martin',
//     'Move->Glencrutchery Road->Giacomo Agostini->Peel road',
//     'Close->Braddan',
//     'END'
// ]);
solve([
    'Add->Glen Vine->Steve Hislop',
    'Add->Ramsey road->John McGuinness ',
    'Add->Glen Vine->Ian Hutchinson',
    'Add->Ramsey road->Dave Molyneux',
    'Move->Ramsey road->Hugh Earnsson->Glen Vine',
    'Add->A18 Snaefell mountain road->Mike Hailwood',
    'Add->Braddan->Geoff Duke',
    'Move->A18 Snaefell mountain road->Mike Hailwood->Braddan',
    'Move->Braddan->John McGuinness->Glen Vine',
    'Close->A18 Snaefell mountain road',
    'END'
]);