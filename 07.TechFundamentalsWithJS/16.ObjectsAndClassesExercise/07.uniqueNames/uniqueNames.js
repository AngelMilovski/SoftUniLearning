function uniqueNames(names) {
    names
        .filter((n, i) => names.indexOf(n) == i)
        .sort((a, b) => {
            if (a.length - b.length != 0) {
                return a.length - b.length;
            } else {
                return a.localeCompare(b);
            }
        })
        .forEach(n => console.log(n));
}

uniqueNames([
    "Ashton",
    "Kutcher",
    "Ariel",
    "Lilly",
    "Keyden",
    "Aizen",
    "Billy",
    "Braston"
]);