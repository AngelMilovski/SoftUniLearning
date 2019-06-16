function solve() {
  let firstInput = document.getElementById('firstNumber');
  let secondInput = document.getElementById('secondNumber');
  let thirdInput = document.getElementById('firstString');
  let fourthInput = document.getElementById('secondString');
  let fifthInput = document.getElementById('thirdString');
  let resultMessage = document.getElementById('result');
  getResult();

  function getResult() {
    if (firstInput && secondInput && thirdInput && fourthInput && fifthInput) {
      let firstNum = +firstInput.value;
      let secondNum = +secondInput.value;
      let firstString = thirdInput.value;
      let secondString = fourthInput.value;
      let thirdString = fifthInput.value;
      
      for (let i = firstNum; i <= secondNum; i++) {
        if (i % 3 === 0 && i % 5 === 0) {
          resultMessage.innerHTML += `<p>${i} ${firstString}-${secondString}-${thirdString}</p>`;
        } else if (i % 3 === 0) {
          resultMessage.innerHTML += `<p>${i} ${secondString}</p>`;
        } else if (i % 5 === 0) {
          resultMessage.innerHTML += `<p>${i} ${thirdString}</p>`;
        } else {
          resultMessage.innerHTML += `<p>${i}</p>`;
        }
      }
    }
  }
}