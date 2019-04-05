function solve(params) {
    let array = [];
    for (let i = 1; i < params.length - 1; i++) {
        array.push(createObject(params[i]));
    }

    let bestSample = array.sort((a, b) => {
        if (b.length - a.length != 0) {
            return b.length - a.length;
        } else if (a.index - b.index != 0) {
            return a.index - b.index;
        } else {
            return b.sum - a.sum;
        }
    })[0];

    let bestSequenceIndex = params.indexOf(bestSample.string, 1);
    console.log(`Best DNA sample ${bestSequenceIndex} with sum: ${bestSample.sum}.`);
    console.log(bestSample.string.split(/[!]+/).join(' '));

    function createObject(str) {
        let obj = getObjOfLongestSequenceAndIndex(str);
        obj.sum = getSum(str);
        obj.string = str;
        return obj;
    }

    function getSum(str) {
        return str.split(/[!]+/).map(Number).reduce((p, c) => p += c, 0);
    }

    function getObjOfLongestSequenceAndIndex(str) {
        let sequence = {};
        let currentDna = str.split('').filter(e => e === '1' || e === '0').join('');
        let bestSequence = currentDna.split('0').sort((a, b) => b.length - a.length)[0];
        sequence.length = bestSequence.length;
        sequence.index = currentDna.indexOf(bestSequence);
        return sequence;
    }
}

solve([
    '4',
    '**1!0!1!1!0!1',
    '1!0!0!1',
    '1!1!0!0',
    'Clone them!'
]);
// solve([
//     '1',
//     '1',
//     '0!0!1!0!0',
//     'Clone them!'
// ]);