function login(args) {
    const username = args.shift();
    let countOfWrongPassword = 0;
    let passwords = args;
    for (const item of passwords) {
        const reversedItem = reverseStr(item);
        if (username === reversedItem) {
            console.log(`User ${username} logged in.`);
        } else {
            countOfWrongPassword += 1;
            if (countOfWrongPassword === 4) {
                console.log(`User ${username} blocked!`);
                return;
            }
            console.log('Incorrect password. Try again.');
        }
    }

    function reverseStr(str) {
        const splitStr = str.split('');
        const reverseArr = splitStr.reverse();
        const joinArr = reverseArr.join('');
        return joinArr;
    }
}

login(['Acer','login','go','let me in','recA']);
