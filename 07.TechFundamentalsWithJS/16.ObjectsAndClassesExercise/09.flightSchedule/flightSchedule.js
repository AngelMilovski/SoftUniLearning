function flightSchedule(params) {
    const status = params.pop()[0];
    const checkStatus = params.pop();
    let flights = {};

    for (const data of params[0]) {
        const [flight, destination] = data.split(' ');
        if (!flights.hasOwnProperty(flight)) {
            flights[flight] = {};
            flights[flight].destination = destination;
        }
    }
    
    for (const line of checkStatus) {
        const flightNumber = line.split(' ')[0];
        if (flights[flightNumber]) {
            flights[flightNumber].status = status;
        }
    }

    if (status === 'Cancelled') {
        Object.values(flights)
            .filter(f => f.status === status)
            .forEach((v) => {
                console.log(`{ Destination: '${v.destination}', Status: '${status}' }`);
            });
    } else {
        Object.values(flights)
            .filter(f => f.status !== status)
            .forEach((v) => {
                console.log(`{ Destination: '${v.destination}', Status: '${status}' }`);
            });
    }
}

flightSchedule([
    [
        'WN269 Delaware',
        'FL2269 Oregon',
        'WN498 Las Vegas',
        'WN3145 Ohio',
        'WN612 Alabama',
        'WN4010 New York',
        'WN1173 California',
        'DL2120 Texas',
        'KL5744 Illinois',
        'WN678 Pennsylvania'
    ],
    [
        'DL2120  Cancelled',
        'WN612 Cancelled',
        'WN1173 Cancelled',
        'SK430 Cancelled'
    ],
    ['Ready to fly']
]);