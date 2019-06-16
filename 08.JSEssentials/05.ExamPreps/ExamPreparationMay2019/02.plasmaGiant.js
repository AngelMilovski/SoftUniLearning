// function solve(array, number) {
//     let smallestNum = Math.min.apply(null, array);
//     let biggestNum = Math.max.apply(null, array);
//     let firstPartArr = array.slice(0, array.length / 2);
//     let secondPartArr = array.slice(array.length / 2);
//     let firstGiant = [];
//     let secondGiant = [];


//     while (firstPartArr.length) {
//         firstGiant.push(firstPartArr.splice(0, number));
//         secondGiant.push(secondPartArr.splice(0, number));
//     }
//     firstGiant = firstGiant
//         .map((arr) => {
//             return arr.reduce((acc, cur) => acc * cur, 1);
//         }, 0)
//         .reduce((acc, cur) => acc + cur, 0);

//     secondGiant = secondGiant
//         .map((arr) => {
//             return arr.reduce((acc, cur) => acc * cur, 1);
//         }, 0)
//         .reduce((acc, cur) => acc + cur, 0);


//     let rounds = 1;
//     if (smallestNum > 0) {
//         while (firstGiant > biggestNum && secondGiant > biggestNum) {
//             rounds += 1;
//             firstGiant -= smallestNum;
//             secondGiant -= smallestNum;
//         }
//     }

//     if (firstGiant > secondGiant) {
//         console.log(`First Giant defeated Second Giant with result ${firstGiant} - ${secondGiant} in ${rounds} rounds`);
//     } else if (secondGiant > firstGiant) {
//         console.log(`Second Giant defeated First Giant with result ${secondGiant} - ${firstGiant} in ${rounds} rounds`);
//     } else {
//         console.log(`Its a draw ${firstGiant} - ${secondGiant}`);
//     }
// }

function solve(arr, num) {
    let [damagePerHit, stopNumber, rounds] = [
        Math.min(...arr),
        Math.max(...arr),
        1
    ]

    let test = arr
    .slice(0, arr.length / num);
    let test2 = test.reduce((acc, el, i) => {
        acc.push(arr.splice(0, num))
        return acc
    }, [])
    let test3 = test2.map(x => x.reduce((acc, el) => acc * el, 1))
    console.log(test3);
    // let products = test
    //     .slice(0, arr.length / num
    //     .reduce((acc, el, i) => {
    //         acc.push(arr.splice(0, num))
    //         return acc
    //     }, [])
    //     .map(x => x.reduce((acc, el) => acc * el, 1))

    let [firstGiant, secondGiant] = [
        products.slice(0, products.length / 2).reduce((acc, el) => acc + el, 0),
        products.slice(products.length / 2).reduce((acc, el) => acc + el, 0)
    ]

    if (damagePerHit !== 0) {
        while (firstGiant > stopNumber && secondGiant > stopNumber) {
            firstGiant -= damagePerHit
            secondGiant -= damagePerHit
            rounds++
        }
    }

    console.log(
        firstGiant === secondGiant
            ? `Its a draw ${firstGiant} - ${secondGiant}`
            : firstGiant > secondGiant
                ? `First Giant defeated Second Giant with result ${firstGiant} - ${secondGiant} in ${rounds} rounds`
                : `Second Giant defeated First Giant with result ${secondGiant} - ${firstGiant} in ${rounds} rounds`
    )
}
solve([3, 3, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4], 4);