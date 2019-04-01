function armies(params) {
    let heroes = {};
    for (const line of params) {
        let indexForArrives = line.indexOf(' arrives');
        let indexForDefeated = line.indexOf(' defeated');
        if (indexForArrives > -1) {
            let heroName = line.slice(0, indexForArrives);
            if (!heroes.hasOwnProperty(heroName)) {
                heroes[heroName] = {
                    totalCountArmy: 0
                };
            }
        } else if (indexForDefeated > -1) {
            let heroName = line.slice(0, indexForDefeated);
            heroes = removeHero(heroes, heroName);
        } else {
            let parts = line.split(': ');
            if (parts.length === 1) {
                let [armyName, armyCount] = parts[0].split(' + ');
                armyCount = +armyCount;
                heroes = increaseArmy(heroes, armyName, armyCount);
            } else {
                let heroName = parts[0];
                let [armyName, armyCount] = parts[1].split(', ');
                armyCount = +armyCount;
                if (heroes.hasOwnProperty(heroName)) {
                    heroes[heroName].totalCountArmy += armyCount;
                    heroes[heroName][armyName] = armyCount;
                }
            }
        }
    }

    Object.keys(heroes)
        .sort((a, b) => heroes[b].totalCountArmy - heroes[a].totalCountArmy)
        .forEach(hero => {
            console.log(`${hero}: ${heroes[hero].totalCountArmy}`);
            Object.keys(heroes[hero])
                .filter(a => a !== 'totalCountArmy')
                .sort((a, b) => heroes[hero][b] - heroes[hero][a])
                .forEach(army => console.log(`>>> ${army} - ${heroes[hero][army]}`));
        });

    function increaseArmy(heroes, armyName, armyCount) {
        for (const hero in heroes) {
            if (heroes[hero].hasOwnProperty(armyName)) {
                heroes[hero][armyName] += armyCount;
                heroes[hero].totalCountArmy += armyCount;
                break;
            }
        }

        return heroes;
    }

    function removeHero(heroes, heroName) {
        heroes = Object
            .keys(heroes)
            .filter((key) => key !== heroName)
            .reduce((acc, cur) => {
                acc[cur] = heroes[cur];
                return acc;
            }, {});
        return heroes;
    }
}

let result = armies([
    'Rick Burr arrives',
    'Fergus: Wexamp, 30245',
    'Rick Burr: Juard, 50000',
    'Findlay arrives',
    'Findlay: Britox, 34540',
    'Wexamp + 6000',
    'Juard + 1350',
    'Britox + 4500',
    'Porter arrives',
    'Porter: Legion, 55000',
    'Legion + 302',
    'Rick Burr defeated',
    'Porter: Retix, 3205'
]);