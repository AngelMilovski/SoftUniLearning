function solve(params) {
    let arr = params.slice(0);
    let countOfNumbers = arr.shift();
    let firstNumsArr = arr.slice(0, countOfNumbers);
    arr.reverse();
    let lastNumsArr = arr.slice(0, countOfNumbers);
    lastNumsArr.reverse();
    console.log(firstNumsArr.join(' '));
    console.log(lastNumsArr.join(' '));
}

solve([2, 7, 8, 9]);