function emoticonFinder(params) {
    let pattern = /(?<=:).(?=$|\s)/g;
    let chars = params.match(pattern);
    if (chars !== null) {
        chars.map(ch => ':' + ch).forEach(e => console.log(e));
    }
}

emoticonFinder('There are so many emoticons nowadays :P I have many ideas :O what input to place here :)');