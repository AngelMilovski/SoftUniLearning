function solve() {
  let degrees = +document.getElementById('num1').value;
  let type = document.getElementById('type').value.toLowerCase();
  let resultMessage = document.getElementById('result');

  if (degrees && type) {
    resultMessage.textContent = '';
    if (type === 'celsius') {
      resultMessage.textContent = convertToFahrenheit(degrees);
    } else if (type === 'fahrenheit') {
      resultMessage.textContent = convertToCelsius(degrees);
    } else {
      resultMessage.textContent = 'Error!';
    }
  }

  function convertToFahrenheit(degrees) {
    return Math.round((degrees * 9 / 5) + 32);
  }

  function convertToCelsius(degrees) {
    return Math.round((degrees - 32) * 5 / 9);
  }
}