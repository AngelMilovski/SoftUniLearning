function palindromes(params) {
    let palindromesArray = [];
    for (const str of params) {
        let word = str.split(' ').join('');
        if (isPalindrome(word)) {
            palindromesArray.push(word);
        }
    }

    if (palindromesArray.length > 0) {
        return palindromesArray.join(', ');
    } else {
        return 'No palindromes found';
    }

    function isPalindrome(word) {
        for (let i = 0; i < word.length / 2; i++) {
            let first = word[i];
            let last = word[(word.length - 1) - i];
            if (first !== last) {
                return false;
            }
        }
        return true;
    }
}

let result = palindromes([' sa', 'not a palindrome']);
console.log(result);
result = palindromes(['stella won wallets', 'not a palindrome']);
console.log(result);