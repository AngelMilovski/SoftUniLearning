function equalSum(args) {
    if (args.length <= 1) {
        return 0;
    }

    const array = args.map(Number);
    let index = 0;
    for (let i = 0; i < array.length; i++) {
        let leftSum = 0;
        let rightSum = 0;
        const currentIndex = i;
        for (let j = currentIndex - 1; j >= 0; j--) {
            const element = array[j];
            leftSum += element;
        }
        for (let k = currentIndex + 1; k < array.length; k++) {
            const element = array[k];
            rightSum += element;
        }

        if (leftSum === rightSum) {
            index = currentIndex;
        }
    }
    if (index != 0) {
        return index;
    } else {
        return 'no';
    }
}

const result = equalSum([]);
console.log(result);