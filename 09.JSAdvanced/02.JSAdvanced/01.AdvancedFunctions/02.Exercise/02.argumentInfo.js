function solve(...params) {
    let argumentsTypeCount = new Map();
    const argumentsInfo = params.reduce((acc, cur) => {
        const type = typeof cur;
        if (argumentsTypeCount.get(type)) {
            let count = argumentsTypeCount.get(type) + 1;
            argumentsTypeCount.set(type, count);
        } else {
            argumentsTypeCount.set(type, 1);
        }

        acc.push({
            [type]: cur
        });
        return acc;
    }, []);

    argumentsInfo
        .forEach((argument) => {
            Object
                .entries(argument)
                .forEach((arg) => {
                    console.log(`${arg[0]}: ${arg[1]}`);
                });
        });

    Array
        .from(argumentsTypeCount)
        .sort((a, b) => b[1] - a[1])
        .forEach((argument) => {
            console.log(`${argument[0]} = ${argument[1]}`);
        });
}

solve('cat', 42, function () { console.log('Hello world!'); });