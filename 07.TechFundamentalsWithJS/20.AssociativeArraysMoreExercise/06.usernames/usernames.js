function usernames(params) {
    params
        .filter((e, i) => params.indexOf(e) === i)
        .sort((a, b) => {
            if (a.length - b.length != 0) {
                return a.length - b.length;
            } else {
                return a.localeCompare(b);
            }
        })
        .forEach(e => console.log(e));
}

usernames([
    'Ashton',
    'Kutcher',
    'Ariel',
    'Lilly',
    'Keyden',
    'Aizen',
    'Billy',
    'Braston'
]);