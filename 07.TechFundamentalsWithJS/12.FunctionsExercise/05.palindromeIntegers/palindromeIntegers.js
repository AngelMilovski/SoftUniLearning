function palindromeIntegers(args) {
    let numberToString = function convertNumberToString(num) {
        return '' + num;
    };

    let arr = args.slice();
    let result = [];
    for (const num of arr) {
        let numToStr = numberToString(num);
        let arrayOfChars = numToStr.split('');
        let palindromeOrNot = checkForPalindrome(arrayOfChars);
        result.push(palindromeOrNot);
    }

    return result.join('\n');

    function checkForPalindrome(array) {
        if (array.length === 1) {
            return true;
        }
        for (let i = 0; i < array.length; i++) {
            const forkward = array.shift();
            const backward = array.pop();
            if (forkward != backward) {
                return false;
            }
        }
        return true;
    }
}

const output = palindromeIntegers([32,2,232,1001]);
console.log(output);