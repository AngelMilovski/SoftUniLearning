const phonebook = require('../phonebook');
const Contact = require('../models/Contact');

module.exports = {
  index: (req, res) => {
    const contacts = phonebook.getAllContacts();
    const model = {
      contacts
    };
    res.render('index', model);
  },
  addPhonebookPost:(req, res) => {
    const name = req.body.name;
    const number = req.body.number;
    const contact = new Contact(name, number);
    phonebook.addContact(contact);
    res.redirect('/');
  }
};