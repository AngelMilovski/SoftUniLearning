function solve(arr, command) {
    const sortArray = (function () {
        return {
            ascending(array) {
                return array
                    .map(Number)
                    .sort((a, b) => a -b);
            },
            descending(array) {
                return array
                    .map(Number)
                    .sort((a, b) => b - a);
            }
        };
    }());

    switch (command) {
        case 'asc':
            return sortArray.ascending(arr);
    
        case 'desc':
            return sortArray.descending(arr);
    }
}

console.log(solve([14, 7, 17, 6, 8], 'asc'));
console.log(solve([14, 7, 17, 6, 8], 'desc'));