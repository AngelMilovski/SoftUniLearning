function cutAndReverse(params) {
    let firstParts = params
        .substring(0, params.length / 2)
        .split('')
        .reverse()
        .join('');

    let secondParts = params
        .substring(params.length / 2)
        .split('')
        .reverse()
        .join('');
    
    console.log(firstParts);
    console.log(secondParts);
}

cutAndReverse('sihToDtnaCuoYteBIboJsihTtAdooGoSmI');