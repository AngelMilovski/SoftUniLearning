const Product = require('../models/Product');

module.exports = {
  getIndex: function (req, res) {
    Product
      .find({})
      .then((products) => {
        return res.render('index', {
          products
        });
      })
      .catch(err => console.log(err));
  },
  getCreate: function (req, res) {
    return res.render('create');
  },
  postCreate: function (req, res) {
    let product = req.body;
    console.log(product);
    Product
      .create(product)
      .then(() => {
        return res.redirect('/');
      })
      .catch(err => console.log(err));
  },
  getEdit: function (req, res) {
    let id = req.params.id;
    Product
      .findById(id)
      .then((product) => {
        return res.render('edit', {
          product
        });
      });
  },
  postEdit: function (req, res) {
    let newProduct = req.body;
    let id = req.params.id;
    Product
      .findByIdAndUpdate(id, newProduct)
      .then(() => {
        return res.redirect('/');
      })
      .catch(err => console.log(err));
  },
  getDelete: function (req, res) {
    let id = req.params.id;
    return res.render('delete', {id});
  },
  postDelete: function (req, res) {
    let id = req.params.id;
    Product
      .findByIdAndRemove(id)
      .then(() => {
        return res.redirect('/');
      })
      .catch(err => console.log(err));
  }
};