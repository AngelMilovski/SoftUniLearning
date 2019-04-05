function activationKeys(params) {
    String.prototype.splice = function (startIndex, count, newItem) {
        let target = this;
        newItem = (newItem !== undefined) ? (newItem) : '';
        let firstPart = target.slice(0, startIndex);
        let secondPart = target.slice(startIndex + Math.abs(count));
        let str = firstPart + newItem;
        str += secondPart;
        return str.replace('  ', ' ');
    };
    
    let input = params[0];
    let inputArray = input.split('&');
    let words = inputArray.filter(s => (/^\w+$/).test(s));

    let keys = words
        .map((w) => {
            if (w.length === 16) {
                for (let i = 4; i < w.length; i += 5) {
                    w = w.splice(i, 0, '-');
                }
                w = w.toUpperCase();
                w = subtractNumbers(w);
                

            } else if (w.length === 25) {
                for (let i = 5; i < w.length; i += 6) {
                    w = w.splice(i, 0, '-');
                }
                w = w.toUpperCase();
                w = subtractNumbers(w);
            }
            return w;
        })
        .join(', ');

        return keys;

        function subtractNumbers(word) {
            for (let i = 0; i < word.length; i++) {
                if (!isNaN(word[i])) {
                    let number = 9 - (+word[i]);
                    word = word.splice(i, 1, '' + number);
                }
            }

            return word;
        }
}

let result = activationKeys(['t1kjZU764zIME6Dl9ryD0g1U8&-P4*(`Q>:x8\yE1{({X/Hoq!gR.&rg93bXgkmILW188m&KroGf1prUdxdA4ln&U3WH9kXPY0SncCfs']);
console.log(result);
result = activationKeys(['xPt8VYhUDalilWLvb6uMSGEEf&KWQ{R.@/HZCbbV++1o]V+oG@@fF^93&y6fT5EGFgZHqlFiS']);
console.log(result);