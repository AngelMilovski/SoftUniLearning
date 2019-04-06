const Book = require('../models/Book');

module.exports = {
  getIndex: function (req, res) {
    Book
      .find({})
      .then(books => res.render('index', {books}))
      .catch(err => console.log(err));
  },
  getCreate: function (req, res) {
    res.render('create');
  },
  postCreate: function (req, res) {
    let data = req.body;
    Book
      .create(data)
      .then(() => res.redirect('/'))
      .catch(err => console.log(err));
  },
  getEdit: function (req, res) {
    let id = req.params.id;
    Book
      .findById(id)
      .then((book) => res.render('edit', {book}));
  },
  postEdit: function (req, res) {
    let id = req.params.id;
    let data = req.body;
    Book
      .findByIdAndUpdate(id, data)
      .then(() => res.redirect('/'))
      .catch(err => console.log(err));
  },
  getDelete: function (req, res) {
    let id = req.params.id;
    Book
      .findById(id)
      .then(book => res.render('delete', {book}))
      .catch(err => console.log(err));
  },
  postDelete: function (req, res) {
    let id = req.params.id;
    Book
      .findByIdAndRemove(id)
      .then(() => res.redirect('/'))
      .catch(err => console.log(err));
  }
};