function presentDelivery(array) {
    let houses = array.shift().split('@').map(Number);
    array.pop();
    let lastPosition = 0;
    for (let i = 0; i < array.length; i++) {
        const jump = +array[i].split(' ')[1];
        lastPosition = (lastPosition + jump) % houses.length;
        houses[lastPosition] -= 2;
        if (houses[lastPosition] < 0) {
            console.log(`House ${lastPosition} will have a Merry Christmas.`);
        }
    }

    console.log(`Santa's last position was ${lastPosition}.`);
    houses = houses.filter(h => h > 0);
    if (houses.length > 0) {
        console.log(`Santa has failed ${houses.length} houses.`);
    } else {
        console.log('Mission was successful.');
    }
}

presentDelivery([
    '2@4@2',
    'Jump 2',
    'Jump 2',
    'Jump 8',
    'Jump 3',
    'Jump 1',
    'Merry Xmas!'
]);