function solve() {
    let btns = document.querySelectorAll('button');
    let [checkBtn, clearBtn] = btns;
    checkBtn.addEventListener('click', check);
    clearBtn.addEventListener('click', clear);
    let table = document.querySelector('table');
    let p = document.querySelector('#check p');
    let inputs = [...document.querySelectorAll('inputs')];
    let matrix = [];
  
    function check() {
      let checkedInputs = inputs.every(i => {
        return i.value && (i.value > 0 && i.value < 4);
      });
  
      if (checkedInputs) {
      [...document.querySelectorAll('tbody tr')].forEach((tr) => {
        let array = Array.from(new Set(Array.from(tr.querySelectorAll('input'))
          .map(input => input.value)));
        matrix.push(array);
      });
  
      let fCol = new Set([matrix[0][0], matrix[1][0], matrix[2][0]]);
      let sCol = new Set([matrix[0][1], matrix[1][1], matrix[2][1]]);
      let tCol = new Set([matrix[0][2], matrix[1][2], matrix[2][2]]);
  
      if (matrix[0].length === 3 && matrix[1].length === 3 && matrix[2].length === 3 && fCol.size === 3 && sCol.size === 3 && tCol.size === 3) {
        table.style.border = '2px solid green';
        p.textContent = 'You solve it! Congratulations!';
        p.style.color = 'green';
      } else {
        table.style.border = '2px solid red';
        p.textContent = 'NOP! You are not done yet...';
        p.style.color = 'red';
      }
    }
  }
  
    function clear() {
      Array.from(document.querySelectorAll('tbody tr td input')).forEach(d => d.value = '');
      table.style.border = 'none';
      p.textContent = '';
      matrix = [];
    }
  }