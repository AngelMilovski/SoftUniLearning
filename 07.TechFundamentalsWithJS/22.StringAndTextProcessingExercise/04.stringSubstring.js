function stringSubstring(searchedWord, str) {
    str = str.toLowerCase();
    let regex = new RegExp(`\\b${searchedWord}\\b`, 'gi');
    let search = str.search(regex);
    if (search > -1) {
        return searchedWord;
    } else {
        return searchedWord + ' not found!';
    }
}

let result = stringSubstring('javascript', 'JavaScript is the best programming language');
console.log(result);
result = stringSubstring('python', 'JavaScript is the best programming language');
console.log(result);