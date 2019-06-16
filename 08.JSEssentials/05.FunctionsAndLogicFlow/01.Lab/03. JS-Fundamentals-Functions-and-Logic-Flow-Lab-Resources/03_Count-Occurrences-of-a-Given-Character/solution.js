function solve() {
  let string = document.getElementById('string');
  let character = document.getElementById('character');
  let resultMessage = document.getElementById('result');
  findCharCount(string, character);

  function findCharCount(string, character) {
    if (string && character) {
      let str = string.value;
      let char = character.value;
      let charCount = str
        .split('')
        .filter(ch => ch === char)
        .length;

      evenOrOddCount(charCount, char);
    }
  }

  function evenOrOddCount(charCount, char) {
    if (charCount % 2 === 0) {
      resultMessage.textContent = `Count of ${char} is even.`;
    } else {
      resultMessage.textContent = `Count of ${char} is odd.`;
    }
  }
}