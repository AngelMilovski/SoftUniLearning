const Trip = require('../models/Trip');

module.exports = {
    index: (req, res) => {
        Trip
            .find({})
            .then((trips) => {
                res.render('../views/trip/index', {trips});
            })
            .catch(err => console.log(err));
    },
    createGet: (req, res) => {
        res.render('../views/trip/create');
    },
    createPost: (req, res) => {
        let data = req.body;
        let origin = data.origin;
        let destination = data.destination;
        let business = +data.business;
        let economy = +data.economy;
        let model = {
            origin,
            destination: destination,
            business,
            economy
        };

        Trip
            .create(model)
            .then(() => {
                res.redirect('/');
            })
            .catch(err => console.log(err));
    },
    editGet: (req, res) => {
        let id = req.params.id;
        Trip
            .findById(id)
            .then((trip) => {
                res.render('../views/trip/edit', trip);
            })
            .catch(err => console.log(err));
    },
    editPost: (req, res) => {
        let id = req.params.id;
        let data = req.body;
        Trip
            .findByIdAndUpdate(id, data)
            .then(() => {
                res.redirect('/');
            })
            .catch(err => console.log(err));
    },
    deleteGet: (req, res) => {
        let id = req.params.id;
        Trip
            .findById(id)
            .then((trip) => {
                res.render('../views/trip/delete', trip);
            })
            .catch(err => console.log(err));
    },
    deletePost: (req, res) => {
        let id = req.params.id;
        Trip
            .findByIdAndRemove(id)
            .then(() => {
                res.redirect('/');
            })
            .catch(err => console.log(err));
    }
};