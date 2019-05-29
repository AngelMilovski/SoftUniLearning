function stringLength(firstStr, secondStr, thirdStr) {
    let sum = firstStr.length + secondStr.length + thirdStr.length;
    let averageSum = Math.floor(sum / 3);
    console.log(sum);
    console.log(averageSum);
}

stringLength('pasta', '5', '22.3');