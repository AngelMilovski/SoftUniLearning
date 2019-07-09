(function () {
    let currentStr = '';

    String.prototype.ensureStart = function (stringForInsert) {
        currentStr = getCurrentStr(this);
        if (!currentStr.startsWith(stringForInsert)) {
            currentStr = stringForInsert + currentStr;
        }

        return currentStr;
    };

    String.prototype.ensureEnd = function (stringForAppend) {
        currentStr = getCurrentStr(this);
        if (!currentStr.endsWith(stringForAppend)) {
            currentStr += stringForAppend;
        }

        return currentStr;
    };

    String.prototype.isEmpty = function () {
        currentStr = getCurrentStr(this);
        return currentStr === '';
    };

    String.prototype.truncate = function (count) {
        currentStr = getCurrentStr(this);
        let ellipsis = '...';
        if (count < 3) {
            ellipsis = ellipsis.slice(0, count);
        }

        if (count >= currentStr.length || count <= 0) {
            return currentStr;
        } else {
            currentStr = currentStr.slice(0, count - 1);
            const lastIndex = currentStr.lastIndexOf(' ');
            if (lastIndex != -1) {
                currentStr = currentStr.slice(0, lastIndex);
            } else {
                count = count - 3;
            }

            if (currentStr.length + ellipsis.length > count) {
                const removeCount = currentStr.length + ellipsis.length - count;
                currentStr = currentStr.slice(0, -removeCount);
            }

            currentStr += ellipsis;
            return currentStr;
        }
    };

    String.format = function (string, ...params) {
        params
            .forEach((t, i) => string = string.replace(`{${i}}`, t));
        return string;
    };

    function getCurrentStr(arrayLike) {
        return Array.from(arrayLike).join('');
    }
})();

let string = 'hello my string';
string = string.truncate(14);
console.log(string);
string = String.format('The {0} {1} fox','quick', 'brown', 'mox');
console.log(string);