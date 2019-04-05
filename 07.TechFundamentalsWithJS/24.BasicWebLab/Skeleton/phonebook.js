const phonebook = [];

function getAllContacts() {
	return phonebook;
}

function addContact(contact) {
	phonebook.push(contact);
}

module.exports = {
	getAllContacts,
	addContact
};