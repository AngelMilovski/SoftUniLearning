function houseParty(args) {
    let quests = [];
    for (let line of args) {
        let tokens = line.split(' ');
        let questName = tokens[0];

        if (tokens.length === 3) {
            if (quests.includes(questName)) {
                console.log(`${questName} is already in the list!`);
            } else {
                quests.push(questName);
            }
        } else if (tokens.length === 4) {
            let indexOfQuest = quests.indexOf(questName);
            if (indexOfQuest < 0) {
                console.log(`${questName} is not in the list!`);
            } else {
                quests.splice(indexOfQuest, 1);
            }
        }
    }

    quests.forEach(q => console.log(q));
}

houseParty([
    'Allie is going!',
    'George is going!',
    'John is not going!',
    'George is not going!'
]);