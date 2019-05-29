function solve() {
   let addBtns = Array.from(document.querySelectorAll('button.add-product'));
   let buyButton = document.querySelector('button.checkout');
   addBtns.forEach(b => b.addEventListener('click', addProduct));
   buyButton.addEventListener('click', buyProducts);
   let textareaElement = document.querySelector('textarea');
   let products = {};

   function addProduct(evt) {
      let currentBtn = evt.target;
      let grandParentElement = currentBtn.parentNode.parentNode;
      let name = grandParentElement.querySelector('.product-title').textContent;
      let money = +grandParentElement.querySelector('.product-line-price').textContent;
      if (!products[name]) {
         products[name] = 0;
      }
         products[name] += +money;
         textareaElement.value += `Added ${name} for ${money.toFixed(2)} to the cart.\n`;
   }

   function buyProducts() {
      let productsArr = Object.entries(products);
         let listOfProducts = productsArr.map(x => x[0]).join(', ');
         let totalPrice = productsArr.reduce((acc, cur) => acc + cur[1], 0);
         textareaElement.value += `You bought ${listOfProducts} for ${totalPrice.toFixed(2)}.`;

         addBtns.forEach(b => b.removeEventListener('click', addProduct));
         buyButton.removeEventListener('click', buyProducts);
   }
}