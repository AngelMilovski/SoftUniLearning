function questsJournal(array) {
    let quests = array.shift().split(', ');
    array.pop();
    for (let i = 0; i < array.length; i++) {
        const [command, quest] = array[i].split(' - ');
        let index = quests.indexOf(quest);
        switch (command) {
            case 'Start':
                
                if (index < 0) {
                    quests.push(quest);
                }
                break;
        
            case 'Complete':
                if (index >= 0) {
                    quests.splice(index, 1);
                }
                break;

            case 'Side Quest':
                const [searchedQuest, sideQuest] = quest.split(':');
                index = quests.indexOf(searchedQuest);
                if (index >= 0) {
                    if (!quests.includes(sideQuest)) {
                        quests.splice(index + 1, 0, sideQuest);
                    }
                }
                break;

            case 'Renew':
                if (index >= 0) {
                    quests.splice(index, 1);
                    quests.push(quest);
                }
                break;
        }
    }
    return quests.join(', ');
}

const output = questsJournal([
    'Hello World, For loop, If else',
    'Start - While loop',
    'Complete - For loop',
    'Retire!'
]);

// const output = questsJournal([
//     'Hello World, If else',
//     'Complete - Homework',
//     'Side Quest - If else:Switch',
//     'Renew - Hello World',
//     'Retire!'
// ]);

console.log(output);