function solve(params) {
    let days = +params.shift();
    let users = +params.shift();
    let moneyPerSearch = +params.shift();
    let moneyFromSingleDay = 0;
    let totalMoney = 0;

    for (let i = 1; i <= users; i++) {
        let money = moneyPerSearch;
        if (i % 3 === 0) {
            money *= 3;
        }

        let userWords = +params.shift();
        if (userWords > 5) {
            continue;
        }

        if (userWords === 1) {
            money *= 2;
        }

        moneyFromSingleDay += money;
    }

    totalMoney = days * moneyFromSingleDay;
    console.log(`Total money earned for ${days} days: ${totalMoney.toFixed(2)}`);
}

solve([10,
    10,
    6,
    5,
    4,
    1]);

// console.log(6 * 3)