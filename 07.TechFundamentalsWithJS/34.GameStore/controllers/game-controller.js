const Game = require('../models/Game');

module.exports = {
  getIndex: function (req, res) {
    Game
      .find({})
      .then(games => res.render('index', {games}))
      .catch(err => console.log(err));
  },
  getCreate: function (req, res) {
    res.render('create');
  },
  postCreate: function (req, res) {
    let data = req.body;
    Game
      .create(data)
      .then(() => res.redirect('/'))
      .catch(() => res.render('create'));
  },
  getEdit: function (req, res) {
    let id = req.params.id;
    Game
      .findById(id)
      .then(game => res.render('edit', {game}))
      .catch(err => console.log(err));
  },
  postEdit: function (req, res) {
    let id = req.params.id;
    let data = req.body;
    Game
      .findByIdAndUpdate(id, data)
      .then(() => res.redirect('/'))
      .catch(err => console.log(err));
  },
  getDelete: function (req, res) {
    let id = req.params.id;
    Game
      .findById(id)
      .then(game => res.render('delete', {game}));
  },
  postDelete: function (req, res) {
    let id = req.params.id;
    Game
      .findByIdAndRemove(id)
      .then(() => res.redirect('/'))
      .catch(err => console.log(err));
  }
};