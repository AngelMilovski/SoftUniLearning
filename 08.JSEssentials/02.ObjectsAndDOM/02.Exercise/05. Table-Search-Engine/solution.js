function solve() {
   let searchField = document.getElementById('searchField');
   let searchBtn = document.getElementById('searchBtn');
   searchBtn.addEventListener('click', search);

   function search(params) {
      let input = searchField.value;
      let rows = Array.from(document.querySelectorAll('table tbody tr'));
      rows.map(tr => tr.removeAttribute('class'));
      if (input) {
         input = input.toLowerCase();
         rows.forEach((tr) => {
            let tdElements = Array.from(tr.childNodes);
            if (tdElements.some((e) => {
               let str = e.textContent.toLowerCase();
               return str.includes(input);
            })) {
               tr.setAttribute('class', 'select');
            }
         });
      }
      searchField.value = '';
   }
}