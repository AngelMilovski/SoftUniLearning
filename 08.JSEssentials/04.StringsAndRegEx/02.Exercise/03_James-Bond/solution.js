function solve() {
    let array = JSON.parse(document.getElementById('array').value);
    let word = array[0];
    let text = array.slice(1);

    let regex = new RegExp(`(?<=\\s|^)${word}\\s+([A-Z!%$#]{8,})(?=(\\s|\\.|,|$))`, 'gi');
    
    text.forEach((line) => {

        let matched = regex.exec(line);
    
        while (matched) {
            let message = matched[1];
            if (message.toUpperCase() === message) {
                let newMessage = message
                    .split('')
                    .map((ch) => {
                        switch (ch) {
                            case '!': return 1;
                            case '%': return 2;
                            case '#': return 3;
                            case '$': return 4;
                            default: return ch.toLowerCase();
                        }
                    })
                    .join('');
                line = line.replace(message, newMessage);
            }
            matched = regex.exec(line);
        }
    
        let pElement = document.createElement('p');
        pElement.textContent = line;
        document.getElementById('result').appendChild(pElement);
    });
}


