function partyTime(input) {
    let quests = {
        VIP: [],
        regular: []
    };
    
    while ((input[0] !== 'PARTY')) {
        let quest = input.shift();
        
        if (!isNaN(+quest.charAt(0))) {
            quests.VIP.push(quest);
        } else {
            quests.regular.push(quest);
        }
    }

    input.shift();
    let questsWhoAreCome = [];
    for (let str of input) {
        questsWhoAreCome.push(str);
    }
    for (let quest of questsWhoAreCome) {
        if (quests.VIP.includes(quest)) {
            let deletionIndex = quests.VIP.indexOf(quest);
            quests.VIP.splice(deletionIndex, 1);

        } else if (quests.regular.includes(quest)) {
            let deletionIndex = quests.regular.indexOf(quest);
            quests.regular.splice(deletionIndex, 1);
        }
    }

    let questCount = quests.VIP.length + quests.regular.length;
    console.log(questCount);
    quests.VIP.forEach(el => console.log(el));
    quests.regular.forEach(el => console.log(el));
}

partyTime([
    '7IK9Yo0h',
    '7IK9Yo0h',
    '9NoBUajQ',
    'Ce8vwPmE',
    'SVQXQCbc',
    'tSzE5t0p',
    'PARTY',
    '7IK9Yo0h',
    '9NoBUajQ',
    'Ce8vwPmE',
    'SVQXQCbc'
]);