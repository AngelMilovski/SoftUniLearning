function solve() {
  let numberToBeMultiplied = +document.getElementById('num1').value;
  let multiplier = +document.getElementById('num2').value;
  let message = document.getElementById('result');
  message.innerHTML = '';
  console.log(message);

  if (numberToBeMultiplied > multiplier) {
    message.textContent = 'Try with other numbers.';
  } else {
    for (let i = numberToBeMultiplied; i <= multiplier; i++) {
      let p = document.createElement('p');
      p.textContent = (`${i} * ${multiplier} = ${i * multiplier}`);
      message.appendChild(p);
    }
  }
}