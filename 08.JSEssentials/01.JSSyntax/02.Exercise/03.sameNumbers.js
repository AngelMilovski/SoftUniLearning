function sameNumbers(int) {
    let strArr = int.toString().split('');
    console.log(strArr.every(ch => ch === strArr[0]));
    console.log(strArr.reduce((acc, cur) => acc + (+cur), 0));
}

sameNumbers(1234);