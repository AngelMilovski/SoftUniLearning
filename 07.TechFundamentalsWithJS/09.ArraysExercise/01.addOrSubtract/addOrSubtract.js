function addOrSubtract(args) {
    const array = args.slice();
    let newArray = [];
    for (let i = 0; i < array.length; i++) {
        let element = array[i];
        if (element % 2 === 1 || element % 2 === -1) {
            element -= i;
        } else {
            element += i;
        }
        newArray.push(element);
    }

    console.log(newArray);
    const sumOfOriginArray = array.reduce((acc, curr) => {
        acc += curr;
        return acc;
    }, 0);

    console.log(sumOfOriginArray);

    const sumOfNewArray = newArray.reduce((acc, curr) => {
        acc += curr;
        return acc;
    }, 0);
    console.log(sumOfNewArray);
}

addOrSubtract([5, 15, 23, 56, 35]);