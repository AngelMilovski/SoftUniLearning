function solve() {
  let rightAnswers = ['onclick', 'JSON.stringify()', 'A programming API for HTML and XML documents'];
  let countOfRightAnswers = 0;
  let pAnswers = document.getElementsByTagName('p');
  [...pAnswers].forEach(p => p.addEventListener('click', checkAnswer));
  let countOfAnswers = 0;
  let countOfPElements = 0;

  function checkAnswer(evt) {
    let answer = evt.currentTarget.textContent;
    let target = evt.currentTarget.parentNode.parentNode.parentNode.parentNode;
    let message = document.querySelector('#results h1');
    let result = '';
    evt.target.removeEventListener(evt.type, checkAnswer);
    target.style.display = 'none';
    
    if (answer === rightAnswers[countOfAnswers++]) {
      countOfRightAnswers += 1;
    }

    if (countOfPElements < 2) {
      document.getElementsByClassName('hidden')[countOfPElements++].style.display = 'block';
    } else {
      if (countOfRightAnswers === 3) {
        result = 'You are recognized as top JavaScript fan!';
      } else {
        result = `You have ${countOfRightAnswers} right answers`;
      }
      message.textContent = result;
      document.querySelector('#results').style.display = 'block';
    }
  }
}