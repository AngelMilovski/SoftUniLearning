function create(words) {
   const divContent = document.querySelector('#content');

   words.forEach((word) => {
      const divEl = document.createElement('div');
      divEl.addEventListener('click', showWord);
      const pEl = document.createElement('p');
      pEl.textContent = word;
      pEl.style.display = 'none';
      divEl.appendChild(pEl);
      divContent.appendChild(divEl);
   });

   function showWord(evt) {
      evt.target.firstChild.style.display = 'block';
   }
}