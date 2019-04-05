function solve(array) {
    let initialList = array.shift().split('&');
    array.pop();
    for (let i = 0; i < array.length; i++) {
        let token = array[i].split(' ');
        let command = token[0];
        let name = token[1];
        let index = initialList.indexOf(name);
        let exist = index >= 0;
        switch (command) {
            case 'Bad':
                if (!exist) {
                    initialList.unshift(name);
                }
                break;
        
            case 'Good':
                if (exist) {
                    initialList.splice(index, 1);
                }
                break;

            case 'Rename':
                const newName = token[2];
                if (exist) {
                    initialList.splice(index, 1, newName);
                }
                break;

            case 'Rearrange':
                if (exist) {
                    initialList.splice(index, 1);
                    initialList.push(name);
                }
                break;
        }
    }

    return initialList.join(', ');
}

const output = solve([
    'Joshua&Aaron&Walt&Dustin&William',
    'Good Walt',
    'Bad Jon ',
    'Rename Aaron Paul',
    'Rearrange Jon',
    'Rename Peter George',
    'Finished!'
]);

console.log(output);