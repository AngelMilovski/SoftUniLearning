function solve() {
  let text = document.getElementById('input').textContent;
  let div = document.getElementById('output');
  let textArr = text
    .split('.')
    .filter(e => e !== '' && e !== ' ')
    .map(e => e + '.');

  while (textArr.length > 0) {
    let p = document.createElement('p');
    let result = '';
    textArr.splice(0, 3).forEach((s) => result += s);
    p.textContent = result;
    div.appendChild(p);
  }
  
  document.getElementById('input').textContent = '';
}