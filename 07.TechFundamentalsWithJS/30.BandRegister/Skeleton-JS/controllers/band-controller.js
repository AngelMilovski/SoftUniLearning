const Band = require('../models/Band');

module.exports = {
  getIndex: function (req, res) {
    Band.find({})
      .then((bands) => {
        res.render('index', {
          bands
        });
      })
      .catch(err => console.log(err));
  },
  getCreate: function (req, res) {
    res.render('create');
  },
  postCreate: function (req, res) {
    let tokens = req.body;
    let name = tokens.name;
    let members = tokens.members;
    let honorarium = +tokens.honorarium;
    let genre = tokens.genre;
    console.log(tokens);
    Band.create({
        name,
        members,
        honorarium,
        genre
      })
      .then(() => {
        res.redirect('/');
      })
      .catch(err => console.log(err));
  },
  getEdit: function (req, res) {
    let id = req.params.id;
    Band
      .findById(id)
      .then((band) => {
        res.render('edit', {band});
      })
      .catch(err => console.log(err));
  },
  postEdit: function (req, res) {
    let id = req.params.id;
    let band = req.body;
    console.log(id);
    console.log(band);
    Band.findByIdAndUpdate(id, band)
      .then(() => {
        res.redirect('/');
      })
      .catch(err => console.log(err));
    // TODO:
  },
  getDelete: function (req, res) {
    let id = req.params.id;
    Band
      .findById(id)
      .then((band) => {
        res.render('delete', { band });
      })
      .catch(err => console.log(err));
  },
  postDelete: function (req, res) {
    let id = req.params.id;
    Band
      .findByIdAndRemove(id)
      .then(() => {
        res.redirect('/');
      })
      .catch(err => console.log(err));
  }
};