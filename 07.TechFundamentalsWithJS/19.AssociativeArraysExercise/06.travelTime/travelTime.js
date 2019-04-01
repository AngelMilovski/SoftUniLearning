function solve(input) {
    let destinations = {};
    for (let line of input) {
        let [country, city, cost] = line.split(' > ');
        if (!destinations.hasOwnProperty(country)) {
            destinations[country] = {};
            destinations[country][city] = cost;
        } else {
            if (destinations[country].hasOwnProperty(city)) {
                const cityTravelCost = destinations[country][city];
                cost = cityTravelCost < cost ? cityTravelCost : cost;
            }
            destinations[country][city] = cost;
        }
    }
    
    let countries = Object.keys(destinations).sort((a, b) => a.localeCompare(b));
    for (let country of countries) {

        let obj = Object.entries(destinations[country])
            .sort((a, b) => a[1] - b[1]).reduce((prev, curr) => {
                prev[curr[0]] = curr[1];
                return prev;
            }, {});

        let values = Object.entries(obj)
            .reduce((prev, curr) => {
                prev += `${curr[0]} -> ${curr[1]} `;
                return prev;
            }, '');
        console.log(`${country} -> ${values}`);
    }
}

solve([
    "Bulgaria > Sofia > 500",
    "Bulgaria > Sopot > 800",
    "Bulgaria > Sofia > 200",
    "France > Paris > 2000",
    "Albania > Tirana > 1000",
]);