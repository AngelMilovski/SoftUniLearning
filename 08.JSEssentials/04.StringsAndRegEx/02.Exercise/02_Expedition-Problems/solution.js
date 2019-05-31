function solve() {
    let word = document.getElementById('string').value;
    let text = document.getElementById('text').value;
    let result = document.getElementById('result');

    if (word && text) {
        result.innerHTML = '';
        let north = '';
        let east = '';
        let regex = /(east|north).*?(\d{2})[^,]*?,[^,]*?(\d{6})/gim;
        let matched = regex.exec(text);
        
        while (matched) {
            if (matched[1].toLowerCase() === 'east') {
                east = `${matched[2]}.${matched[3]} E`;
            } else if (matched[1].toLowerCase() === 'north') {
                north = `${matched[2]}.${matched[3]} N`;
            }

            matched = regex.exec(text);
        }
        
        let message = 'Message: ' + text.match(new RegExp(`(?<=${word}).*(?=${word})`));
        let pNorth = document.createElement('p');
        let pEast = document.createElement('p');
        let pMessage = document.createElement('p');
        pNorth.textContent = north;
        pEast.textContent = east;
        pMessage.textContent = message;
        result.appendChild(pNorth);
        result.appendChild(pEast);
        result.appendChild(pMessage);

        word = document.getElementById('string').value = '';
        text = document.getElementById('text').value = '';
    }
}

// function solve() {
//     let word = document.getElementById('string').value;
//     let text = document.getElementById('text').value;
//     let result = document.getElementById('result');

//     if (word && text) {
//         result.innerHTML = '';
//         let matched = text.match(/(east|north).*?\d{2}[^,]*?,[^,]*?\d{6}/gim);
//         let nString = '';
//         let eString = '';
//         let message = '';
//         if (matched) {
            
//             let north = matched.filter(e => e[0].toLowerCase() === 'n');
//             let northMatched = (/north.*?(\d{2})[^,]*?,[^,]*?(\d{6})/gim).exec(north[north.length - 1]);
//             nString = `${northMatched[1]}.${northMatched[2]} N`;
//             let east = matched.filter(e => e[0].toLowerCase() === 'e');
//             let eastMatched = (/east.*?(\d{2})[^,]*?,[^,]*?(\d{6})/gim).exec(east[east.length - 1]);
//             eString = `${eastMatched[1]}.${eastMatched[2]} E`;
//             message = `Message: ${text.match(new RegExp(`(?<=${word}).+(?=${word})`, 'g'))[0]}`;
//         }
        
//         let pNorth = document.createElement('p');
//         pNorth.textContent = nString;
//         let pEast = document.createElement('p');
//         pEast.textContent = eString;
//         let pMessage = document.createElement('p');
//         pMessage.textContent = message;
//         result.appendChild(pNorth);
//         result.appendChild(pEast);
//         result.appendChild(pMessage);

//         word = document.getElementById('string').value = '';
//         text = document.getElementById('text').value = '';
//     }
// }