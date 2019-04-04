function solve(params) {
    params.pop();
    let messages = [];

    for (let line of params) {
        let data = line.split(' ');
        let command = data.shift();
        let message = data[0];

        if (command === 'Spam') {
            messages.splice(messages.length, 0, ...data);
            continue;
        }


        let index = messages.indexOf(message);
        switch (command) {
            case 'Chat':
                if (index < 0) {
                    messages.push(message);
                }
                break;

            case 'Delete':
                if (index > -1) {
                    messages.splice(index, 1);
                }
                break;

            case 'Edit':
                if (index > -1) {
                    let newMessage = data[1];
                    messages.splice(index, 1, newMessage);
                }
                break;

            case 'Pin':
                if (index > -1) {
                    messages.splice(index, 1);
                    messages.push(message);
                }
                break;
        }
    }

    messages.forEach(m => console.log(m));
}

solve([
    'Chat Hello',
    'Chat darling',
    'Edit darling Darling',
    'Spam how are you',
    'Delete Darling',
    'end'
]);