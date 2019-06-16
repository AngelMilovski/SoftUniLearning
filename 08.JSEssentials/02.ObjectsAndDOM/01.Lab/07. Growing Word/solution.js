function growingWord() {
  let colors = ['red', 'blue', 'green'];
  let p = document.querySelector('#exercise p');
  p.clicks = p.clicks + 1 || 1;
  p.style.color = colors[p.clicks % colors.length];
  p.style.fontSize = `${2 ** p.clicks}px`;
}