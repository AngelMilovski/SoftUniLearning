function deciphering(params) {
    let pattern = /^[d-z{}|#]+$/g;
    let encryptedString = params[0];
    let matched = encryptedString.match(pattern);
    if (matched != null) {
        let strResult = '';
        for (let i = 0; i < matched[0].length; i++) {
            let ch = matched[0].charAt(i);
            ch = ch.charCodeAt(0) - 3;
            strResult += String.fromCharCode(ch);
        }
        let [searchedLetters, replacement] = params[1].split(' ');
        strResult = strResult.replace(new RegExp(`${searchedLetters}`, 'g'), replacement);
        return strResult;
    } else {
        return 'This is not the book you are looking for.';
    }
}

let result = deciphering([
    'wkhfn#|rx#jhqfkr#phf#exw#|rxu#uholf#lv#khfgohg#lq#hfrwkhu#sohfhw',
    'ec an'
]);
console.log(result);
result = deciphering([
    'arx#vkdww#qrw#sdvv',
    't l'
]);
console.log(result);