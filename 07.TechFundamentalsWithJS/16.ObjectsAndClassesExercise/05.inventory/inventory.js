function inventory(params) {
    let registerForTheHeroes = [];
    for (const line of params) {
        let hero = {};
        const data = line.split(' / ');
        hero.name = data[0];
        hero.level = +data[1];
        hero.items = data[2].split(', ');
        registerForTheHeroes.push(JSON.stringify(hero));
    }

    console.log(`[${registerForTheHeroes.join(',')}]`);
}

inventory([
    "Isacc / 25 / Apple, GravityGun",
    "Derek / 12 / BarrelVest, DestructionSword",
    "Hes / 1 / Desolator, Sentinel, Antara"
]);