function arenaTier(input) {
    let gladiators = {};

    for (let i = 0; i < input.length; i++) {
        let line = input[i];
        if (line === 'Ave Cesar') {
            break;
        }
        const index = line.indexOf('vs');
        if (index < 0) {
            const parts = line.split(' -> ');
            const [gladiatorName, technique] = [parts[0], parts[1]];
            let skill = +parts[2];
            if (!gladiators.hasOwnProperty(gladiatorName)) {
                gladiators[gladiatorName] = new Map();
                gladiators[gladiatorName].set(technique, skill);
            } else {
                if (gladiators[gladiatorName].has(technique)) {
                    let currentSkill = gladiators[gladiatorName].get(technique);
                    if (currentSkill < skill) {
                        gladiators[gladiatorName].set(technique, skill);
                    }
                } else {
                    gladiators[gladiatorName].set(technique, skill);
                }
            }
        } else {
            const parts = line.split(' vs ');
            const [firstGladiatorName, secondGladiatorName] = parts;
            if (gladiators.hasOwnProperty(firstGladiatorName) && gladiators.hasOwnProperty(secondGladiatorName)) {
                gladiators = fight(gladiators, firstGladiatorName, secondGladiatorName);
            }
        }
    }

    let sortedGladiators = Object.keys(gladiators)
        .sort((a, b) => sorted(a, b))
        .reduce((acc, curr) => {
            acc[curr] = [...gladiators[curr]]
                .reduce((acc, curr) => {
                    acc += +curr[1];
                    return acc;
                }, 0);
            return acc;
        }, {});

    for (let gladiator of Object.entries(sortedGladiators)) {
        console.log(`${gladiator[0]}: ${gladiator[1]} skill`);
        let gladiatorSkill = [...gladiators[gladiator[0]].entries()]
            .sort((a, b) => {
                if (a[1] === b[1]) {
                    return a[0].localeCompare(b[0]);
                } else {
                    return b[1] - a[1];
                }
            });

        for (let skill of gladiatorSkill) {
            console.log(`- ${skill[0]} <!> ${skill[1]}`);
        }
    }

    function sorted(a, b) {
        let aTotalSKill = [...gladiators[a]]
            .reduce((acc, curr) => {
                acc += +curr[1];
                return acc;
            }, 0);
        let bTotalSkill = [...gladiators[b]]
            .reduce((acc, curr) => {
                acc += +curr[1];
                return acc;
            }, 0);
        if (aTotalSKill === bTotalSkill) {
            return a.localeCompare(b);
        } else {
            return bTotalSkill - aTotalSKill;
        }
    }

    function fight(gladiators, firstName, secondName) {
        let firstAndSecondGladiatorsTotalSkill = getTotalSkillForTwoGladiators(gladiators, firstName, secondName);
        const [firstGladiatorTotalSkill, secondGladiatorTotalSkill] = firstAndSecondGladiatorsTotalSkill;

        let firstGladiator = gladiators[firstName];

        for (let firstGladiatorTechnique of [...firstGladiator.entries()]) {
            if (gladiators.hasOwnProperty(firstName) && gladiators.hasOwnProperty(secondName)) {

                if (gladiators[secondName].has(firstGladiatorTechnique[0])) {

                    if (secondGladiatorTotalSkill < firstGladiatorTotalSkill) {
                        gladiators = removeGladiator(gladiators, secondName);
                    } else {
                        gladiators = removeGladiator(gladiators, firstName);
                    }
                } else {
                    continue;
                }
            } else {
                break;
            }

            gladiators = Object.entries(gladiators)
                .filter((val) => {
                    return val[1].size > 0;
                })
                .reduce((acc, curr) => {
                    acc[curr[0]] = curr[1];
                    return acc;
                }, {});
        }
        return gladiators;
    }

    function getTotalSkillForTwoGladiators(gladiators, firstName, secondName) {
        let gladiatorsTotalSkill = [];
        let firstGladiatorTotalSkill = [...gladiators[firstName].entries()]
            .reduce((acc, curr) => {
                acc += +curr[1];
                return acc;
            }, 0);
        let secondGladiatorTotalSkill = [...gladiators[secondName].entries()]
            .reduce((acc, curr) => {
                acc += +curr[1];
                return acc;
            }, 0);
        gladiatorsTotalSkill.push(firstGladiatorTotalSkill);
        gladiatorsTotalSkill.push(secondGladiatorTotalSkill);
        return gladiatorsTotalSkill;
    }

    function removeGladiator(gladiators, name) {
        let obj = Object.entries(gladiators).filter((glad) => {
            return glad[0] !== name;
        }).reduce((acc, curr) => {
            acc[curr[0]] = curr[1];
            return acc;
        }, {});
        return obj;
    }
}

arenaTier([
    'Pesho -> Duck -> 400',
    'Pesho -> Duck -> 40',
    'Pesho -> Suck -> 40',
    'Pesho -> Suck -> 40000',


    // 'Julius -> Shield -> 150',
    // 'Gladius -> Heal -> 200',
    // 'Gladius -> Support -> 250',
    // 'Gladius -> Shield -> 250',
    // 'Pesho vs Gladius',
    // 'Gladius vs Julius',
    // 'Gladius vs Gosho',
    'Ave Cesar'
]);


