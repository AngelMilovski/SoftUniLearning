function songEncryption(params) {
    String.prototype.isLetter = function () {
        return this.toLowerCase() != this.toUpperCase();
    };

    String.prototype.isCapitalLetter = function () {
        return this == this.toLocaleUpperCase();
    };

    String.prototype.isSmallLetter = function () {
        return this == this.toLowerCase();
    };

    let encryptedSongs = [];
    let i = 0;
    for (const line of params) {
        if (params[i++] === 'end') {
            break;
        }
        let matched = (/^(?<artist>[A-Z][a-z' ]+):(?<song>[A-Z ]+)$/g).exec(line);
        if (matched) {
            let keyLength = matched.groups.artist.length;
            let song = '';
            for (let ch of line) {
                if (ch.isLetter()) {
                    let charCode = ch.charCodeAt(0);
                    if (ch.isCapitalLetter()) {
                        if (charCode + keyLength > 90) {
                            charCode = ((charCode + keyLength) - 91) + 65;
                        } else {
                            charCode += keyLength;
                        }
                    } else if (ch.isSmallLetter()) {
                        if (charCode + keyLength > 122) {
                            charCode = ((charCode + keyLength) - 123) + 97;
                        } else {
                            charCode += keyLength;
                        }
                    }
                    song += String.fromCharCode(charCode);

                } else if (ch === ':') {
                    ch = '@';
                    song += ch;
                } else {
                    song += ch;
                }
            }
            console.log('Successful encryption: ' + song);
        } else {
            console.log('Invalid input!');
        }
    }
}

songEncryption([
    'Eminem:VENOM',
    'Linkin park:NUMB',
    'Drake:NONSTOP',
    'Adele:HELLO',
    'end'
]);
songEncryption([
    'Michael Jackson:ANOTHER PART OF ME',
    'Adele:ONE AND ONLY',
    "Guns n'roses:NOVEMBER RAIN",
    'Christina Aguilera: HuRt',
    'end'
]);
