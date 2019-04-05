function solve(params) {
    let pattern = /(?<=#)[A-Za-z]+/g;
    let matched = params.match(pattern);
    matched.forEach(w => console.log(w));
}

solve('Nowadays everyone uses # to tag a #special word in #socialMedia');