function solve() {
   let filter = function () {
      let secondaryCmd = document.getElementById('filterSecondaryCmd');
      let position = +document.getElementById('filterPosition').value;
      let command = secondaryCmd.options[secondaryCmd.selectedIndex].value;
      let matched;
      if (command && position) {
         switch (command) {
            case 'uppercase':
               matched = input.value.match(/[A-Z]/g);
               break;

            case 'lowercase':
               matched = input.value.match(/[a-z]/g);
               break;

            case 'nums':
               matched = input.value.match(/\d/g);
               break;
         }

         if (position > 0 && position <= matched.length) {
            output.textContent += matched[position - 1];
            input.value = '';
            secondaryCmd.selectedIndex = 0;
            document.getElementById('filterPosition').value = '';
         }
      }
   };

   let sort = function () {
      let sortSecondaryCmd = document.getElementById('sortSecondaryCmd');
      let sortPosition = +document.getElementById('sortPosition').value;
      let command = sortSecondaryCmd.options[sortSecondaryCmd.selectedIndex].value;
      if (command && sortPosition) {
         let arr = [];
         switch (command) {
            case 'A':
               arr = (input.value)
                  .split('')
                  .sort((a, b) => a.localeCompare(b));
               break;

            case 'Z':
               arr = (input.value)
                  .split('')
                  .sort((a, b) => b.localeCompare(a));
               break;
         }

         if (sortPosition > 0 && sortPosition <= arr.length) {
            output.textContent += arr[sortPosition - 1];
            input.value = '';
            sortSecondaryCmd.selectedIndex = 0;
            document.getElementById('sortPosition').value = '';
         }
      }
   };

   let rotate = function () {
      let rotateSecondaryCmd = +document.getElementById('rotateSecondaryCmd').value;
      let rotatePosition = +document.getElementById('rotatePosition').value;
      if (rotateSecondaryCmd && rotatePosition) {
         let inputArr = (input.value).split('');
         let rotate = rotateSecondaryCmd % inputArr.length;
         for (let i = 0; i < rotate; i++) {
            inputArr.unshift(inputArr.pop());
         }

         if (rotatePosition > 0 && rotatePosition <= inputArr.length) {
            output.textContent += inputArr[rotatePosition - 1];
            input.value = '';
            document.getElementById('rotateSecondaryCmd').value = '';
            document.getElementById('rotatePosition').value = '';
         }
      }
   };

   let get = function () {
      let index = +document.getElementById('getPosition').value;
      let arr = (input.value).split('');
      if (index > 0 && index <= arr.length) {
         output.textContent += arr[index - 1];
         input.value = '';
         document.getElementById('getPosition').value = '';
      }
   };

   let callback = function callback(evt) {
      if (input.value) {
         switch (evt.target.textContent) {
            case 'Filter':
               filter();
               break;

            case 'Sort':
               sort();
               break;

            case 'Rotate':
               rotate();
               break;

            case 'Get':
               get();
               break;
         }
      }
   };

   let input = document.querySelector('#input');
   let output = document.querySelector('#output p');
   let btns = document.querySelectorAll('button');
   [...btns].forEach(btn => btn.addEventListener('click', callback));
}