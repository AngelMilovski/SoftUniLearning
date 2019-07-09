function getFibonacci() {
    let count = 0;
    let sum = [1, 1];
    return () => {
        if (count < 2) {
            count += 1;
        } else {
            sum.push(sum[sum.length - 1] + sum[sum.length - 2]); 
        }

        return sum[sum.length - 1];
    };
}

let fib = getFibonacci();
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
