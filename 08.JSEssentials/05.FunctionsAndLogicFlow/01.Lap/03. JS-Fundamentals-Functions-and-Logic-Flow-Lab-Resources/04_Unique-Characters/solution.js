function solve() {
  let string = document.getElementById('string');
  let messageResult = document.getElementById('result');
  getUniqueChars(string);

  function getUniqueChars(string) {
    if (string) {
      let str = string.value;
      messageResult.textContent = str
        .split(' ')
        .filter(e => e !== '')
        .map((word) => {
          return word
            .split('')
            .filter((c, i) => word.indexOf(c) === i)
            .join('');
        })
        .join(' ');
    }
  }
}