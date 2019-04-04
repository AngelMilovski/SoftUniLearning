function sorting(array) {
    array.sort((a, b) => a - b);
    let ourArray = [];
    while (array.length != 0) {
        let biggestEl = array.pop();
        let smallestEl = array.shift();
        ourArray.push(biggestEl);
        ourArray.push(smallestEl);
    }

    console.log(ourArray.join(' '));
}

sorting([1, 21, 3, 52, 69, 63, 31, 2, 18, ]);