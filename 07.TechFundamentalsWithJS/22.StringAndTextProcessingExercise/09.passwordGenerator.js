function passwordGenerator(params) {
    let array = (params[0] + params[1]).split('');
    let word = params[2];
    let vowels = ['a', 'i', 'e', 'o', 'u'];
    let index = 0;
    for (let i = 0; i < array.length; i++) {
        let currentLetter = array[i].toLowerCase();
        if (vowels.includes(currentLetter)) {
            let letter = word[index].toUpperCase();
            array[i] = letter;
            index = (index + 1) % word.length;
        }
    }

    let password = array.reverse().join('');
    return `Your generated password is ${password}`;
}

let result = passwordGenerator(['ilovepizza', 'ihatevegetables', 'orange']);
console.log(result);
result = passwordGenerator(['easymoneyeazylife', 'atleasttencharacters', 'absolute']
);
console.log(result);
result = passwordGenerator(['areyousureaboutthisone', 'notquitebutitrustyou', 'disturbed']);
console.log(result);

