function getData() {
	let peopleIn = [];
	let peopleOut = [];
	let blacklist = [];
	let peopleInOutput = document.querySelector('#peopleIn p');
	let peopleOutOutput = document.querySelector('#peopleOut p');
	let blacklistOutput = document.querySelector('#blacklist p');
	peopleInOutput.textContent = '';
	peopleOutOutput.textContent = '';
	blacklistOutput.textContent = '';
	let input = document.querySelector('#input textarea');
	checkInput(input);

	function checkInput(params) {
		let input = params.value;
		if (input) {
			let tokens = JSON.parse(input);
			addPeopleInLists(tokens);
			params.value = '';
		}
	}

	function addPeopleInLists(params) {
		let sortingCriteria = params.pop();
		for (const info of params) {
			let [firstName, lastName] = [info.firstName, info.lastName];
			switch (info.action) {
				case 'peopleIn':
					let searchedPersonInBlacklist = blacklist
						.some(p => p.firstName === firstName && p.lastName === lastName);
					if (!searchedPersonInBlacklist) {
						peopleIn.push({
							firstName,
							lastName
						});
					}
					break;

				case 'peopleOut':
					let searchedPerson = checkForPersonInListIn(firstName, lastName);
					if (searchedPerson.length) {
						addToListOut(firstName, lastName);
					}
					break;

				case 'blacklist':
					let person = checkForPersonInListIn(firstName, lastName);
					if (person.length) {
						addToListOut(firstName, lastName);
					}
					blacklist.push({
						firstName,
						lastName
					});
					break;
			}
		}

		printOutput(sortingCriteria);
	}

	function printOutput(sortingCriteria) {
		if (sortingCriteria.action && sortingCriteria.criteria) {
			let action = sortingCriteria.action;
			let criteria = sortingCriteria.criteria;
			switch (action) {
				case 'peopleIn':
					sorting(peopleIn, criteria);
					break;

				case 'peopleOut':
					sorting(peopleOut, criteria);
					break;

				case 'blacklist':
					sorting(blacklist, criteria);
					break;
			}
		}

		if (peopleIn.length) {
			addPeopleInSection(peopleInOutput, peopleIn);
		}

		if (peopleOut.length) {
			addPeopleInSection(peopleOutOutput, peopleOut);
		}

		if (blacklist.length) {
			addPeopleInSection(blacklistOutput, blacklist);
		}
	}

	function addPeopleInSection(p, list) {
		let result = '';
		list.forEach(p => result += JSON.stringify(p) + ' ');
		p.textContent = result;
	}

	function sorting(list, criteria) {
		if (criteria === 'firstName') {
			list.sort((a, b) => {
				return (a.firstName).localeCompare(b.firstName);
			});
		} else if (criteria === 'lastName') {
			list.sort((a, b) => {
				return (a.lastName).localeCompare(b.lastName);
			});
		}
	}

	function checkForPersonInListIn(firstName, lastName) {
		return peopleIn
			.filter(p => p.firstName === firstName && p.lastName === lastName);
	}

	function addToListOut(firstName, lastName) {
		peopleOut.push({
			firstName,
			lastName
		});
		peopleIn = peopleIn
			.filter(p => p.firstName !== firstName || p.lastName !== lastName);
	}
}