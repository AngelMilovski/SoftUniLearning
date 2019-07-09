function aggregates(array) {
    console.log(`Sum = ${array.reduce((acc, cur) => acc + cur, 0)}`);
    console.log(`Min = ${Math.min(...array)}`);
    console.log(`Max = ${Math.max(...array)}`);
    console.log(`Product = ${array.reduce((acc, cur) => acc * cur, 1)}`);
    console.log(`Join = ${array.join('')}`);
}

aggregates([2, 3, 10, 5]);
console.log();
aggregates([5, -3, 20, 7, 0.5]);