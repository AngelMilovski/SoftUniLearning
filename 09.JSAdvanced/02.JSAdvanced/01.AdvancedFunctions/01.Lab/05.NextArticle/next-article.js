function getArticleGenerator(input) {
	const array = input.slice();
	let index = 0;

	return function showNext() {
		if (array[index]) {
			let articleEl = document.createElement('article');
			articleEl.textContent = array[index++];
			document.querySelector('#content').appendChild(articleEl);
		} else {
			document.querySelector('button').disabled = true;
		}
	};
}