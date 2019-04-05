function piccolo(arr) {
    
    let parking = [];
    for (let str of arr) {
        let [direction, carNumber] = str.split(', ');
        if (direction.toLowerCase() === 'in') {
            if (parking.indexOf(carNumber) === -1) {
                carNumber = carNumber;
                parking.push(carNumber);
            }
        } else {
            parking = parking.filter(number => number !== carNumber);
        }
    }
    
    if (parking.length !== 0) {
        parking
            .sort((a, b) => a.localeCompare(b))
            .forEach(n => console.log(n));
    } else {
        console.log('Parking Lot is Empty');
    }
}

piccolo([
    'IN, CA2844AA',
    'IN, CA2844AA',
]);