// function solve() {
// 	let title = document.getElementById('createTitle').value;
// 	let text = document.getElementById('createContent').value;
// 	let articleList = document.getElementById('articles');
// 	if (title !== '' && text !== '') {
// 		let article = document.createElement('article');
// 		let h3 = document.createElement('h3');
// 		let paragraph = document.createElement('p');
// 		h3.textContent = title;
// 		paragraph.textContent = text;
// 		article.appendChild(h3);
// 		article.appendChild(paragraph);
// 		articleList.appendChild(article);
// 	}

// 	document.getElementById('createTitle').value = '';
// 	document.getElementById('createContent').value = '';
// }

function createArticle() {

	let title = document.getElementById('createTitle').value,
		text = document.getElementById('createContent').value;

	if (title !== '' && text !== '') {
		let articleHeading = document.querySelector("#articles"),
			article = document.createElement('article'),
			h3 = document.createElement('h3'),
			par = document.createElement('p');

		h3.innerHTML = title;
		par.innerHTML = text;


		article.appendChild(h3);
		article.appendChild(par);
		articleHeading.appendChild(article);

	}
	document.getElementById('createTitle').value = '';
	document.getElementById('createContent').value = '';
}