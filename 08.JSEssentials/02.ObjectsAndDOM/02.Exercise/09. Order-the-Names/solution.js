// function solve() {
//     let btn = document.querySelector('button');
//     let input = document.querySelector('input');
//     btn.addEventListener('click', register);
//     input.addEventListener('keyup', callback);
//     let letters = createArrayFromAtoZ();
//     let arrOfLi = Array.from(document.querySelectorAll('ol li'));

//     function register() {
//         let namesArr = (input.value).split(' ');
//         for (let i = 0; i < namesArr.length; i++) {
//             const name = namesArr[i].substring(0, 1).toUpperCase() + namesArr[i].substring(1).toLowerCase();
//             let firstLetter = name[0];
//             let index = letters.indexOf(firstLetter);
//             if (name.match(/[A-Z]/g)) {
//                 if (arrOfLi[index].textContent !== '') {
//                     arrOfLi[index].textContent += ', ' + name;
//                 } else {
//                     arrOfLi[index].textContent += name;
//                 }
//             }

//         }

//         input.value = '';
//     }

//     function callback(evt) {
//         if (evt.keyCode === 13) {
//             evt.preventDefault();
//             register();
//         }
//     }

//     function createArrayFromAtoZ() {
//         return Array
//             .apply(null, { length: 26 })
//             .map((x, i) => String.fromCharCode(65 + i));
//     }
// }

// function solve() {

//     let input = document.querySelector('input');
//     let wholeList = document.querySelectorAll('li');

//     function capitalize(text){
//         return text.charAt(0).toUpperCase() + text.slice(1).toLowerCase();
//     }


//     let addButton = document.querySelector('button');
//     addButton.addEventListener('click', function () {
//         let currentName = input.value;
//         let test = currentName[0].charCodeAt(0);
//         let position = currentName[0].charCodeAt(0) - 97;
//         if (wholeList[position].textContent === ''){
//             wholeList[position].textContent += capitalize(currentName);
//         }
//         else{
//             wholeList[position].textContent += `, ${capitalize(currentName)}`;
//         }
//         console.log(wholeList[position].textContent);
//         console.log(position);
//         input.value = '';
//     });

// }

function solve() {

    let addBtn = document.querySelector('button');

    addBtn.addEventListener('click', addName);

    function addName() {
        let name = document.querySelector('input');
            name = name.value.toLowerCase();
        if (name !== '') {
            listEl = document.querySelectorAll('li');

            let n = name.charCodeAt(0),

            nameImput = name.charAt(0).toUpperCase() + name.slice(1),//capitalize first letter

                liContent = listEl[n - 97].textContent;

            if (liContent === '') {
                listEl[n - 97].textContent = nameImput;
            }
            else {
                listEl[n - 97].textContent += , ${nameImput};
            }
        }
    }
}