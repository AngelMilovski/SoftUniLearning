const Project = require('../models/Project');

module.exports = {
    index: (req, res) => {
        Project
            .find({})
            .then((projects) => {
                res.render('../views/project/index', {projects});
            })
            .catch(err => console.log(err));
    },
    createGet: (req, res) => {
        res.render('../views/project/create');
    },
    createPost: (req, res) => {
        let data = req.body;
        data.budget = +data.budget;
        Project
            .create(data)
            .then(() => {
                res.redirect('/');
            })
            .catch(err => console.log(err));
    },
    editGet: (req, res) => {
        let id = req.params.id;
        Project
            .findById(id)
            .then((project) => {
                res.render('../views/project/edit', project);
            })
            .catch(err => console.log(err));
    },
    editPost: (req, res) => {
        let id = req.params.id;
        let data = req.body;
        Project
            .findByIdAndUpdate(id, data)
            .then(() =>  res.redirect('/'))
            .catch(err => console.log(err));
    },
    deleteGet: (req, res) => {
        let id = req.params.id;
        Project
            .findById(id)
            .then((project) => {
                res.render('../views/project/delete', project);
            })
            .catch(err => console.log(err));
    },
    deletePost: (req, res) => {
        let id = req.params.id;
        Project
            .findByIdAndRemove(id)
            .then(() => res.redirect('/'))
            .catch(err => console.log(err));
    }
};