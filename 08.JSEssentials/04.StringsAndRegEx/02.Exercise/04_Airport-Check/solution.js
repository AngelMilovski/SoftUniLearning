function solve() {
    let [text, command] = (document.getElementById('string').value).split(', ');
    let result = document.getElementById('result');
    let nameRegex = / [A-Z]\w*-([A-Z]\w*\.-)?[A-Z]\w* /;
    let airportRegex = / [A-Z]{3}\/[A-Z]{3} /;
    let flightNumberRegex = / [A-Z]{1,3}\d{1,5} /;
    let companyRegex = /- [A-Z]\w*\*[A-Z]\w* /;
    let airports = getAirports();
    switch (command) {
        case "name":
            result.textContent = `Mr/Ms, ${getName()}, have a nice flight!`;
            break;
        case "flight":
            result.textContent = `Your flight number ${getFlight()} is from ${airports[0]} to ${airports[1]}.`;
            break;
        case "company":
                result.textContent = `Have a nice flight with ${getCompany()}.`;
            break;
        case "all":
            airports = getAirports();
            result.textContent = `Mr/Ms, ${getName()}, your flight number ${getFlight()} is from ${airports[0]} to ${airports[1]}. Have a nice flight with ${getCompany()}.`;
            break;
    }

    function getName() {
        let name = text.match(nameRegex)[0];
        return name.substring(1, name.length - 1).replace('-', ' ').replace('-', ' ');
    }

    function getFlight() {
        let flight = text.match(flightNumberRegex)[0];
        return flight.substring(1, flight.length - 1);
    }

    function getAirports() {
        let airport = text.match(airportRegex)[0];
        airport = airport.substring(1, airport.length - 1);
        return function airport() {
            return airport.split('/');
        };
    }

    function getCompany() {
        let company = text.match(companyRegex)[0];
        return company.substring(2, company.length - 1).replace('*', ' ');
    }
}