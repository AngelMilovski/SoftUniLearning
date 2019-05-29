function solve () {
    let input = document.querySelector('input').value;
    let weight = input;
  
    while (weight > 9) {
      weight = weight
        .toString()
        .split('')
        .map(Number)
        .reduce((a, b) => a + b, 0);
    }
  
    let test = input
      .slice(weight, input.length - weight)
      .match(/.{1,8}/g);
    let result = test
      .map(segment => String.fromCharCode(parseInt(segment, 2)))
      .filter(x => /[A-Za-z\s]/.test(x))
      .join('');
  
    document.querySelector('#resultOutput').textContent = result;
    document.getElementById('input').value = '';
  }