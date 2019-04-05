function solve(input) {
    String.prototype.isCapitalLetter = function () {
        let letter = this;
        return letter == letter.toUpperCase();
    };

    String.prototype.isSmallLetter = function () {
        let letter = this;
        return letter == letter.toLowerCase();
    };

    String.prototype.isLetter = function () {
        let ch = this;
        return ch.toLowerCase() != ch.toUpperCase();
    };

    let arr = [];

    let text = input.split(' ').filter(e => e != '');

    for (let i = 0; i < text.length; i++) {
        let element = text[i];
        if (element.startsWith('*') && element.endsWith('*')) {
            element = element.substring(1);

            if (element[0].isLetter() && element[0].isCapitalLetter()) {
                for (let j = 1; j < element.length; j++) {
                    const ch = element[j];
                    if (ch.isLetter() && ch.isSmallLetter()) {
                        if (element[j + 1] === '*') {
                            arr.push(text[i]);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    arr.forEach(function(el) {
        text = text.filter(e => e !== el);
    });

    console.log(arr.join(', '));
    console.log('********************');
    console.log(text.join(' '));
}

solve("Oh my *Rudolf* dwarfs! This *Dasher* year's christmas *Prancer is about to be Comet* ruined because Santa has lost his deer and.");