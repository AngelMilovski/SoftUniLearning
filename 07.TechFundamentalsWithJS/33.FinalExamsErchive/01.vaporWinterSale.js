function solve(params) {
    let games = {};
    let input = params[0];
    input
        .split(', ')
        .forEach((l) => {
            if (l.includes('-')) {
                let [gameName, price] = l.split('-');
                games[gameName] = +price;
            } else if (l.includes(':')) {
                let [gameName, dlc] = l.split(':');
                if (games.hasOwnProperty(gameName)) {
                    let increasedPrice = games[gameName] + (games[gameName] / 100 * 20);
                    let dlcName = {
                        dlc, 
                        price: increasedPrice
                    };
                    games[gameName] = dlcName;
                }
            }
        });

        Object
            .keys(games)
            .filter(key => games[key].hasOwnProperty('dlc'))
            .sort((a, b) => {
                let aPrice = games[a].price;
                let bPrice = games[b].price;
                return aPrice - bPrice;
            })
            .forEach((game) => {
                let price = games[game].price - (games[game].price / 100 * 50);
                console.log(`${game} - ${games[game].dlc} - ${price.toFixed(2)}`);
            });

        Object
            .keys(games)
            .filter(key => !games[key].hasOwnProperty('dlc'))
            .sort((a, b) => {
                let aPrice = games[a];
                let bPrice = games[b];
                return bPrice - aPrice;
            })
            .forEach((game) => {
                let price = games[game] - (games[game] / 100 * 20);
                console.log(`${game} - ${price.toFixed(2)}`);
            });
}

solve(['Center Strike-14.99, FortLite-25, BattleShield 5-64.74, BattleShield 5:CoD edition, Dog of War-45, Dead Red Redemption-100, Dead Red Redemption:no DLC']);