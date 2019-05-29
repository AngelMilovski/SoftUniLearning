function solve() {
  let btns = Array.from(document.querySelectorAll('button'));
  let textareaElements = Array.from(document.querySelectorAll('textarea'));
  btns[0].addEventListener('click', generate);
  btns[1].addEventListener('click', buy);

  function generate() {
    let inputParse = JSON.parse(textareaElements[0].value);
    inputParse.forEach((input) => {
      let imgSrc = input.img,
        productName = input.name,
        price = +input.price,
        decFactor = +input.decFactor;
        
      let tableBody = document.querySelector('table tbody');
      let trElement = document.createElement('tr');
      let tdForImg = document.createElement('td');
      let tdForType = document.createElement('td');
      let tdForPrice = document.createElement('td');
      let tdForDecFactor = document.createElement('td');
      let tdForCheckBox = document.createElement('td');

      let img = document.createElement('img');
      img.setAttribute('src', imgSrc);
      tdForImg.appendChild(img);

      let name = document.createElement('p');
      name.textContent = productName;
      tdForType.appendChild(name);

      let pPrice = document.createElement('p');
      pPrice.textContent = price;
      tdForPrice.appendChild(pPrice);

      let pDecFactor = document.createElement('p');
      pDecFactor.textContent = decFactor;
      tdForDecFactor.appendChild(pDecFactor);

      let checkboxEl = document.createElement('input');
      checkboxEl.setAttribute('type', 'checkbox');
      tdForCheckBox.appendChild(checkboxEl);

      trElement.appendChild(tdForImg);
      trElement.appendChild(tdForType);
      trElement.appendChild(tdForPrice);
      trElement.appendChild(tdForDecFactor);
      trElement.appendChild(tdForCheckBox);
      tableBody.appendChild(trElement);
    });

    textareaElements[0].value = '';
  }

  function buy() {
    let trElements = Array.from(document.querySelectorAll('tbody tr'));
    let products = trElements.reduce((acc, cur) => {
      let checkboxSelected = cur.querySelector('input[type="checkbox"]').checked;
      if (checkboxSelected) {
        let info = cur.getElementsByTagName('p');
        acc.push({
          name: info[0].textContent,
          price: +info[1].textContent,
          decFactor: +info[2].textContent
        });
      }
      return acc;
    }, []);

    let productsName = products.map(p => p.name).join(', ');
    let totalPrice = products.map(p => p.price).reduce((acc, cur) => acc + cur, 0);
    let averageDecFactor = products.map(p => p.decFactor).reduce((acc, cur) => acc + cur, 0) / products.length;
    textareaElements[1].value += `Bought furniture: ${productsName}\n`;
    textareaElements[1].value += `Total price: ${totalPrice.toFixed(2)}\n`;
    textareaElements[1].value += `Average decoration factor: ${averageDecFactor}`;
  }
}

// function solve() {
//   let textAreas = Array.from(document.querySelectorAll('textarea')),
//     btns = Array.from(document.querySelectorAll('button')),
//     generateBtn = btns[0],
//     buyBtn = btns[1];


//   generateBtn.addEventListener('click', generateFurniture);
//   buyBtn.addEventListener('click', buyItems);


//   function generateFurniture() {

//     let input = textAreas[0].value,
//       inputArray = JSON.parse(input);

//     let table = document.querySelector('tbody');

//     inputArray.forEach(element => {

//       let tableRow = document.createElement('tr'),
//         image = document.createElement('td'),
//         imgTag = document.createElement('img');

//       imgTag.setAttribute('src', element['img']);
//       image.appendChild(imgTag);
//       tableRow.appendChild(image);

//       let name = document.createElement('td');
//       name.textContent = element['name'];
      
//       tableRow.appendChild(name);

//       let price = document.createElement('td');
//       let pPrice =document.createElement('p');
//       pPrice.textContent = element['price'];
//       price.appendChild(pPrice);
//       tableRow.appendChild(price);

//       let decFactor = document.createElement('td');
//       decFactor.textContent = element['decFactor'];
//       tableRow.appendChild(decFactor);

//       let check = document.createElement('td'),
//         chekMark = document.createElement('input');
//       chekMark.setAttribute('type', 'checkbox');
//       check.appendChild(chekMark);
//       tableRow.appendChild(check);

//       table.appendChild(tableRow);
//     });

//     textAreas[0].value = '';
//   }

//   function buyItems() {
//     let checkboxes = Array.from(document.querySelectorAll('input')),
//       markedCheckboxes = checkboxes.filter(x => x.checked);

//     let boughtItems = [],
//       totalPrice = 0,
//       avgDec = 0;

//     markedCheckboxes.forEach(checkbox => {
//       let parrentofAll = checkbox.parentNode.parentNode;
//       let allChildren = parrentofAll.children

//       boughtItems.push(allChildren[1].textContent);
//       totalPrice += Number(allChildren[2].textContent);
//       avgDec += Number(allChildren[3].textContent);
//     })

//     let output = textAreas[1];


//     output.value += `Bought furniture: ${boughtItems.join(', ')}\n`
//     output.value += `Total price: ${totalPrice.toFixed(2)}\n`
//     output.value += `Average decoration factor: ${(avgDec / boughtItems.length)}`
//   }
// }