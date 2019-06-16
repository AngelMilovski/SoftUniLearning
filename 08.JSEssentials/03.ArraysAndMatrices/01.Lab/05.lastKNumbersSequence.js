function solve(n, k) {
    let output = [1];
    // while (n !== 1) {
    //     let sliced = output.slice(-k);
    //     output.push(sliced.reduce((a, b) => a + b, 0));
    //     n--;
    // }

    return output.slice(0);
}

console.log(solve(2, 1));