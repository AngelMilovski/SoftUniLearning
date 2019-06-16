// function jsonTowns(params) {
//     return JSON.stringify(params
//         .slice(1)
//         .reduce((acc, cur) => {
//             let [town, latitude, longitude] = cur.split(/\s*\|\s*/).filter(v => v != '');
//             acc.push({
//                 Town: town,
//                 Latitude: +latitude,
//                 Longitude: +longitude
//             });
//             return acc;
//         }, []));
// }

// console.log(jsonTowns(['| Town | Latitude | Longitude |',
//     '| Sofia | 42.69| 23.32 |',
//     '| Beijing | 39.91 | 116.36 |'
// ]));


function solve (arr) {
    let input = arr.slice(1);

    for (let i = 0; i < arr.length; i++) {
        let obj = {},
        line = input[i].replace(/\|/gi, '').trim().split(' ');

        obj.Town = line[0];
        obj.lat = +line[1];
        obj.as = +line[2];
        
        console.log(obj);
    }
}

solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.69| 23.32 |',
    '| Beijing | 39.91 | 116.36 |'
])