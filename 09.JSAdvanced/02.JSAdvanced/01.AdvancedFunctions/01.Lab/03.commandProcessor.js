function solution() {
    let result = '';
    return {
        append(str) {
            result += str;

            return this;
        },
        removeStart(n) {
            result = result.substring(n);

            return this;
        },
        removeEnd(n) {
            result = result.slice(0, -n);

            return this;
        },
        print() {
            console.log(result);

            return this;
        },
    };
}

let firstZeroTest = solution();
firstZeroTest.append('hello');
firstZeroTest.append('again');
firstZeroTest.removeStart(3);
firstZeroTest.removeEnd(4);
firstZeroTest.print();