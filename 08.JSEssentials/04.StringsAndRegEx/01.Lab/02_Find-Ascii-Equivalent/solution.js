function solve() {
  let text = document.getElementById('text').value;
  let message = document.getElementById('result');

  if (text) {
    Array.from(message.children).map((ch) => {
      let parent = ch.parentNode;
      parent.removeChild(ch);
    });
    let matchedWords = text.match(/[^0-9\s]+/g);
    let matchedDigits = text.match(/\d+/g);
    let arr = [];
    if (matchedWords) {
      matchedWords.forEach((word) => {
        let ascii = word
          .split('')
          .map(ch => ch.charCodeAt(0))
          .join(' ');
        arr.push(ascii);
      });
    }

    if (matchedDigits) {
      let word = matchedDigits.map(d => String.fromCharCode(d)).join('');
      arr.push(word);
    }


    arr
      .forEach((e) => {
        let pElement = document.createElement('p');
        pElement.textContent = e;
        message.appendChild(pElement);
      });
    document.getElementById('text').value = '';
  }
}