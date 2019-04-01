function solve(params) {
    let arr = params[0].split('#');
    let array = [];
    for (const line of arr) {
        let parts = line.split(' = ');
        let type = parts[0];
        let value = +parts[1];
        let isHigh = value >= 81 && value <= 125 && type === 'High';
        let isMedium = value >= 51 && value <= 80 && type === 'Medium';
        let isLow = value >= 1 && value <= 50 && type === 'Low';
        if  (isHigh || isMedium || isLow) {
                array.push(value);
        }
    }

    let water = +params[1];
    array = array.filter((e) => {
        if (water - e >= 0) {
            water -= e;
            return true;
        }
        return false;
    });
    
    let totalFire = array.reduce((p, c) => p += c, 0);
    console.log('Cells:');
    array.forEach(e => console.log(' - ' + e));
    let effort = totalFire / 100 * 25;
    console.log('Effort: ' + effort.toFixed(2));
    console.log('Total Fire: ' + totalFire);
}

solve([
    'High = 89#Meduim = 53#Low = 28#Medium = 77#Low = 23',
    '1250'
]);

// solve([
//     'High = 150#Low = 55#Medium = 86#Low = 40#High = 110#Medium = 77',
//     '220'
// ]);