function solve(params) {
    let arr = params.slice(0);
    let smallestNumber = Math.min(...arr);
    let index = arr.indexOf(smallestNumber);
    arr.splice(index, 1);
    let secondSmallest = Math.min(...arr);
    console.log(smallestNumber + ' ' + secondSmallest);
}

solve([30, 15, 50, 5]);