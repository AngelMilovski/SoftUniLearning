function solve() {
  let input = document.getElementById('text').value;
  let namingConvention = document.getElementById('naming-convention').value;
  let message = document.getElementById('result');

  let fixedText = function switchCase(text, currentCase) {
    let words = text.split(' ');
    let firstWord = words[0];
    let stringArray = words.slice(1);
    switch (currentCase) {
      case 'camel case':
        return (function convertToCamelCase() {
          firstWord = firstWord.split('').map((ch, i) => {
            if (i === 0) {
              return ch.toLowerCase();
            } else {
              return ch.toLowerCase();
            }
          })
            .join('');
          stringArray = stringArray.map(fixedWord);
          stringArray.splice(0, 0, firstWord);
          return stringArray.join('');
        })();

      case 'pascal case':
        return (function convertToPascalCase() {
          firstWord = firstWord.split('').map((ch, i) => {
            if (i === 0) {
              return ch.toUpperCase();
            } else {
              return ch.toLowerCase();
            }
          })
            .join('');
          stringArray = stringArray.map(fixedWord);
          stringArray.splice(0, 0, firstWord);
          return stringArray.join('');
        })();

      default:
        return (function sendError() {
          return 'Error!';
        })();
    }
  };

  if (input && namingConvention) {
    message.textContent = '';
    namingConvention = namingConvention.toLowerCase();
    let result = fixedText(input, namingConvention);
    message.textContent = result;
    document.getElementById('text').value = '';
    document.getElementById('naming-convention').value = '';
  }

  function fixedWord(word) {
    return word
      .split('')
      .map((ch, i) => {
        if (i === 0) {
          return ch.toUpperCase();
        } else {
          return ch.toLowerCase();
        }
      })
      .join('');
  }
}