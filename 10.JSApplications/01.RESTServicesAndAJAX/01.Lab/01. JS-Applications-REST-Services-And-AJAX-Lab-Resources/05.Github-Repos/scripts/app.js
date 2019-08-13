function loadRepos() {
	const nameInput = document.querySelector('#username');
	const name = nameInput.value;
	const myList = document.querySelector('#repos');

	const createElements = {
		li() {
			return document.createElement('li');
		},

		a() {
			return document.createElement('a');
		}
	};

	const parseRepo = ({ full_name, html_url }) => {
		const name = full_name;
		const link = html_url;
		return { name, link };
	};

	const toDomElements = ({ name, link }) => {
		const li = createElements.li();
		const a = createElements.a();
		a.innerHTML = name;
		a.href = link;
		li.appendChild(a);
		return li;
	};

	const appendToUlElement = (li) => {
		myList.appendChild(li);
	};

	const addToList = (res) => {
		res
			.map(parseRepo)
			.map(toDomElements)
			.forEach(appendToUlElement);
	};

	const parse = (res) => {
		return res.json();
	};

	const displayErr = (err) => {
		const li = createElements.li();
		li.innerHTML = err;
		myList.appendChild(li);
	};

	if (name) {
		nameInput.value = '';
		const url = `http://api.github.com/users/${name}/repos`;

		myList.innerHTML = '';
		fetch(url)
			.then(parse)
			.then(addToList)
			.catch(displayErr);
	}
}
