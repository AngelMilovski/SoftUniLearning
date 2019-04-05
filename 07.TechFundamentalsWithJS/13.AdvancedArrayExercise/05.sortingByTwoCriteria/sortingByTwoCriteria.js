function sortingByTwoCriteria(params) {
    params.sort((a, b) => {
        if (a.length - b.length != 0) {
            return a.length - b.length;
        } else {
            return a.localeCompare(b);
        }
    })
    .forEach((e) => console.log(e));
}

sortingByTwoCriteria([
    'test',
    'Deny',
    'omen',
    'Default'
]);