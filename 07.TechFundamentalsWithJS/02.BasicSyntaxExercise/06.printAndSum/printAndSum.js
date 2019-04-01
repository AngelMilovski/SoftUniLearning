function printAndSum(firstItem, secondItem) {
    const start = +firstItem;
    const end = +secondItem;
    let numbers = '';
    let sum = 0;

    for (let i = start; i <= end; i++) {
        numbers += i + ' ';
        sum += i;
    }
    console.log(numbers.trim());
    console.log(`Sum: ${sum}`);
}

printAndSum(5, 10);