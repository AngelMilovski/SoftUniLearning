function solve(input) {
    const words = input.split(' ');
    let occurrences = words
        .reduce((prev, curr) => {
            const str = curr.toLowerCase();
            if (!prev.has(str)) {
                prev.set(str, 0);
            }
            prev.set(str, prev.get(str) + 1);
            return prev;
        }, new Map());

    console.log([...occurrences.entries()]
        .filter((item) => {
            return item[1] % 2 !== 0;
        })
        .map((item) => {
            return item[0];
        })
        .join(' '));
}

solve('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');