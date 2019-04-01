function legendaryFarming(params) {
    let array = params.split(' ');
    let shadowmourne = {
        shards: 0,
        fragments: 0,
        motes: 0,
        junk: {}
    };
    let valanyr = {
        shards: 0,
        fragments: 0,
        motes: 0,
        junk: {}
    };
    let dragonwrath = {
        shards: 0,
        fragments: 0,
        motes: 0,
        junk: {}
    };

    for (let i = 1; i < array.length; i += 2) {
        let amount = +array[i - 1];
        let material = array[i].toLowerCase();
        switch (material) {
            case 'shards':
                shadowmourne.shards += amount;
                valanyr.shards += amount;
                dragonwrath.shards += amount;
                if (shadowmourne.shards >= 250) {
                    shadowmourne.shards -= 250;
                    printHeroMaterials(shadowmourne, 'Shadowmourne');
                    return;
                }
                break;

            case 'fragments':
                shadowmourne.fragments += amount;
                valanyr.fragments += amount;
                dragonwrath.fragments += amount;
                if (valanyr.fragments >= 250) {
                    valanyr.fragments -= 250;
                    printHeroMaterials(valanyr, 'Valanyr');
                    return;
                }
                break;

            case 'motes':
                shadowmourne.motes += amount;
                valanyr.motes += amount;
                dragonwrath.motes += amount;
                if (dragonwrath.motes >= 250) {
                    dragonwrath.motes -= 250;
                    printHeroMaterials(dragonwrath, 'Dragonwrath');
                    return;
                }
                break;

            default:
                if (!shadowmourne.junk.hasOwnProperty(material)) {
                    shadowmourne.junk[material] = amount;
                } else {
                    shadowmourne.junk[material] += amount;
                }
                if (!valanyr.junk.hasOwnProperty(material)) {
                    valanyr.junk[material] = amount;
                } else {
                    valanyr.junk[material] += amount;
                }
                if (!dragonwrath.junk.hasOwnProperty(material)) {
                    dragonwrath.junk[material] = amount;
                } else {
                    dragonwrath.junk[material] += amount;
                }
                break;

        }
    }

    function printHeroMaterials(obj, hero) {
        let junk = Object.keys(obj.junk).sort((a, b) => a.localeCompare(b));

        console.log(hero + ' obtained!');
        Object
            .keys(obj)
            .sort((a, b) => {
                let result = obj[b] - obj[a];
                if (result === 0) {
                    result = a.localeCompare(b);
                }

                return result;
            })
            .forEach(key => {
                if (key != 'junk') {
                    console.log(`${key}: ${obj[key]}`);
                }
            });
        junk.forEach(j => {
            console.log(`${j}: ${obj.junk[j]}`);
        });
    }
}

legendaryFarming('3 Motes 5 stones 5 Shards 6 leathers 255 fragments 7 Shards');