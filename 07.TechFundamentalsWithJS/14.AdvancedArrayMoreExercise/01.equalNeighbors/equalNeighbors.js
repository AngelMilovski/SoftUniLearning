// function equalNeighbors(matrix) {
//     let count = 0;

//     for (let i = 0; i < matrix.length - 1; i++) {
//         let currentArrayFromMatrix = matrix[i];
//         let nextArrayFromMatrix = matrix[1 + i];
//         for (let j = 0; j < matrix[i].length; j++) {
//             let currentEl = currentArrayFromMatrix[j];
//             let nextColEl = nextArrayFromMatrix[j];
//             let nextRowEl = currentArrayFromMatrix[1 + j];
//             if (currentEl === nextColEl) {
//                 count += 1;
//             }

//             if (currentEl === nextRowEl) {
//                 count += 1;
//             }
//         }
//     }

//     for (let i = 0; i < matrix[matrix.length - 1].length; i++) {
//         let curr = matrix[matrix.length - 1][i];
//         let next = matrix[matrix.length - 1][1 + i];
//         if (curr === next) {
//             count += 1;
//         }
        
//     }

//     return count;
// }

function equalNeighbors(arr) {
    let arr2 = arr.slice();
    let countInFirstElement = arr.shift().length;
    let result = '';
    let count = 0;
    for (let i = 0; i < arr2.length; i++) {

        result += arr2[i] + ',';
    }
    let k = result.split(",");
    for (let j = 0; j < k.length; j++) {

        if (k[j] == k[j + countInFirstElement]) {

            count++;
        }

    }
    console.log(count);

}


const output = equalNeighbors([
    ['test', 'yes', 'yo', 'ho'],
    ['well', 'done', 'yo', '6'],
    ['not', 'done', 'yet', '5']]);

console.log(output);


// [2, 2, 2, 2, 2], 4
// [2, 2, 2, 2, 2], 4
// [2, 2, 2, 2, 2]  4
//  2, 2, 2, 2, 2   12 + 10 = 22