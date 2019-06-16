function cmd(a, b) {
    if (a === b) {
        return a;
    }

    if (a > b) {
        a = a - b;
    } else {
        b = b - a;
    }

    return cmd(a, b);
}

console.log(cmd(2154, 458));