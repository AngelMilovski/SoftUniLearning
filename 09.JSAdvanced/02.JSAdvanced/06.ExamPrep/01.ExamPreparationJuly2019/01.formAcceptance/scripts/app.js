function acceptance() {
	const selectors = {
		shoppingCompany: 'input[name="shippingCompany"]',
		productName: 'input[name="productName"]',
		productQuantity: 'input[name="productQuantity"]',
		productScrape: 'input[name="productScrape"]',
		addBtn: '#acceptance',
		warehouse: '#warehouse'
	};

	const div = 'div';
	const p = 'p';
	const button = 'button';

	const elements = { div, p, button };

	const shoppingCompany = document.querySelector(selectors.shoppingCompany);
	const productName = document.querySelector(selectors.productName);
	const productQuantity = document.querySelector(selectors.productQuantity);
	const productScrape = document.querySelector(selectors.productScrape);
	const addBtn = document.querySelector(selectors.addBtn);
	addBtn.addEventListener('click', addProduct);
	const warehouse = document.querySelector(selectors.warehouse);

	function addProduct(evt) {
		const company = shoppingCompany.value;
		const name = productName.value;
		const quantity = +productQuantity.value;
		const scrape = +productScrape.value;
		shoppingCompany.value = '';
		productName.value = '';
		productQuantity.value = '';
		productScrape.value = '';

		if (company && name && quantity && scrape) {
			const availableQuantity = quantity - scrape;
			if (availableQuantity <= 0) {
				return;
			}

			const divEl = document.createElement(elements.div);
			const productInfo = document.createElement(elements.p);
			const removeBtn = document.createElement(elements.button);
			removeBtn.innerHTML = 'Out of stock';
			removeBtn.addEventListener('click', () => divEl.remove());
			productInfo.innerHTML = `[${company}] ${name} - ${availableQuantity} pieces`;
			divEl.appendChild(productInfo);
			divEl.appendChild(removeBtn);
			warehouse.appendChild(divEl);
		}
	}
}