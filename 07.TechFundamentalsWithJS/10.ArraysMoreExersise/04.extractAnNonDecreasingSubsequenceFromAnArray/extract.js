function extract(arr) {
    return arr
        .filter((e, i) => e >= Math.max(...arr.slice(0, i + 1)))
        .join(' ');

}

// function extract(args) {
//     let biggest = 0;
//     let array = args
//         .slice()
//         .map(Number)
//         .filter((num) => {
//             if (num >= biggest) {
//                 biggest = num;
//                 return true;
//             }
//             return false;
//         });
//     // let newArr = [];
//     // let biggestNum = 0;
//     // let lastIndex = newArr.length - 1;
//     // for (let i = 0; i < array.length; i++) {
//     //     const curr = array[i];
//     //     if (curr >= biggestNum) {
//     //         biggestNum = curr;
//     //         newArr[lastIndex] = biggestNum;
//     //     }
//     // }

//     return array.join(' ');
// }

const result = extract([1, 3, 8, 4, 10, 12, 3, 2, 24]);
console.log(result);