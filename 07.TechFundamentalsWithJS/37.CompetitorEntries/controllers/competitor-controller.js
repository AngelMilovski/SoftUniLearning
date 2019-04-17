const Competitor = require('../models/Competitor');

module.exports = {
    getIndex: function (req, res) {
        Competitor
            .find({})
            .then(competitors => res.render('index', {competitors}))
            .catch(err => console.log(err));
    },
    getCreate: function (req, res) {
        res.render('create');
    },
    postCreate: function (req, res) {
        let data = req.body;
        Competitor
            .create(data)
            .then(() => res.redirect('/'))
            .catch(err => console.log(err));
    },
    getEdit: function (req, res) {
        let id = req.params.id;
        Competitor
            .findById(id)
            .then(competitor => {
                res.render('edit', {competitor});
            })
            .catch(err => console.log(err));
    },
    postEdit: function (req, res) {
        let id = req.params.id;
        let data = req.body;
        Competitor
            .findByIdAndUpdate(id, data)
            .then(() => {
                res.redirect('/');
            })
            .catch(err => console.log(err));
    },
    getDelete: function (req, res) {
        let id = req.params.id;
        Competitor
            .findById(id)
            .then(competitor => {
                res.render('delete', {competitor});
            })
            .catch(err => console.log(err));
    },
    postDelete: function (req, res) {
        let id = req.params.id;
        Competitor
            .findByIdAndRemove(id)
            .then(() => res.redirect('/'))
            .catch(err => console.log(err));
    }
};