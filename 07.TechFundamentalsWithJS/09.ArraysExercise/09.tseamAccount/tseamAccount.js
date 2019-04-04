function tseamAccount(args) {
    let lines = args.slice();
    let games = lines[0].split(' ');
    let linesIndex = 1;
    let line = lines[linesIndex];
    while (true) {
        if (line === 'Play!') {
            break;
        }

        const parts = line.split(' ');
        const [command, game] = [parts[0], parts[1]];
        switch (command) {
            case 'Install':
                if (!games.includes(game)) {
                    games.push(game);
                }
                break;

            case 'Uninstall':
                const index = games.indexOf(game);
                if (index >= 0) {
                    games.splice(index, 1);
                }
                break;

            case 'Update':
                const indexForUpdate = games.indexOf(game);
                if (indexForUpdate >= 0) {
                    games.splice(indexForUpdate, 1);
                    games.push(game);
                }
                break;

            case 'Expansion':
                const [nameOfGame, expansion] = game.split('-');
                const indexForExpansion = games.indexOf(nameOfGame);
                if (indexForExpansion >= 0) {
                    let expansionGame = `${nameOfGame}:${expansion}`;
                    games.splice(indexForExpansion + 1, 0, expansionGame);
                }
                break;
        }
        line = lines[++linesIndex];
    }

    return games.join(' ');
}

const result = tseamAccount([
    'CS WoW Diablo',
    'Install LoL',
    'Uninstall WoW',
    'Update Diablo',
    'Expansion CS-Go',
    'Play!'
]);

console.log(result);