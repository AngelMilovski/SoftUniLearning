function solve(params) {
    for (const line of params) {
        // let arr = line.split('=');

        // if ((/^([#$%*&])[a-zA-Z]+\1$/g).test(arr[0])) {
        //     let [count, text] = [arr[1].slice(0, arr[1].indexOf('!!')), arr[1].slice(arr[1].indexOf('!!') + 2)];
        //     count = +count;
        //     if (text.length === count) {
        //         let name = arr[0].substring(1, arr[0].length - 1);
        //         text = text
        //                 .split('')
        //                 .map((ch) => {
        //                     return String.fromCharCode(ch.charCodeAt(0) + count);
        //                 })
        //                 .join('');
        //         console.log(`Coordinates found! ${name} -> ${text}`);
        //         return;
        //     } else {
        //         console.log('Nothing found!');
        //     }
        // } else {
        //     console.log('Nothing found!');
        // }

        // let matched = /^([#$%*&])(?<name>[a-zA-Z]+)\1=(?<count>\d+)!!(?<text>.+)$/g.exec(line);
        // if (matched) {
        //     let name = matched.groups.name;
        //     let count = +matched.groups.count;
        //     let text = matched.groups.text;

        //     if (text.length === count) {
        //         text = text
        //             .split('')
        //             .map((ch) => {
        //                 return String.fromCharCode(ch.charCodeAt(0) + count);
        //             })
        //             .join('');
        //         console.log(`Coordinates found! ${name} -> ${text}`);
        //         return;
        //     } else {
        //         console.log('Nothing found!');
        //     }
        // } else {
        //     console.log('Nothing found!');
        // }

        let tokens = line.split('=');
        let symbols = ['#', '$', '%', '*'];
        if ((symbols.includes(tokens[0].charAt(0)) && tokens[0].charAt(0) === tokens[0].charAt(tokens[0].length - 1))) {

            if (areLetters(tokens[0].substring(1, tokens[0].length - 1))) {
                let name = tokens[0].substring(1, tokens[0].length - 1);
                let digits = +tokens[1].substring(0, tokens[1].indexOf('!!'));
                let text = tokens[1].substring(tokens[1].indexOf('!!') + 2);
                if (text.length === digits) {
                    text = text
                        .split('')
                        .map(ch => String.fromCharCode(ch.charCodeAt(0) + digits))
                        .join('');
                    console.log(`Coordinates found! ${name} -> ${text}`);
                    return;
                }
            }
			
            console.log('Nothing found!');
        } else {
            console.log('Nothing found!');
        }
    }

    function areLetters(name) {
        for (const ch of name) {
            if (!isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    function isLetter(ch) {
        return ch.toUpperCase() != ch.toLowerCase();
    }
}

solve([
    '%G#iacomoAgostini%=7!!hbqw',
    '&GeoffDuke*=6!!vjh]zi',
    'JoeyDunlop=10!!lkd,rwazdr',
    'Mike??Hailwood=5!![pliu',
    '#SteveHislop#=16!!df%TU[Tj(h!!TT[S',
]);