function train(args) {
    let passengersInWagonsStr = args.shift();
    let passengersInWagons = passengersInWagonsStr.split(' ').map(Number);
    let capacityOfWagon = +args.shift();

    for (let passengers of args) {
        if (isNaN(passengers)) {
            passengers = +passengers.split(' ')[1];
            passengersInWagons.push(passengers);
        } else {
            for (let i = 0; i < passengersInWagons.length; i++) {
                let currentPassengers = passengersInWagons[i];
                passengers = +passengers;
                if (currentPassengers + passengers <= capacityOfWagon) {
                    passengersInWagons[i] = currentPassengers + passengers;
                    break;
                }
            }
        }
    }

    return passengersInWagons.join(' ');
}

const output = train([
    '32 54 21 12 4 0 23',
    '75',
    'Add 10',
    'Add 0',
    '30',
    '10',
    '75']);
console.log(output);