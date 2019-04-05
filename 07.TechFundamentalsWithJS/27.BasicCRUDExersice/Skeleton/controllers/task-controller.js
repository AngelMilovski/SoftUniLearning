const Task = require('../models/task');

module.exports = {
  getIndex: function (req, res) {
    Task
      .find({})
      .then((tasks) => {
        const openTasks = tasks.filter(t => t.status === 'Open');
        const inProgressTasks = tasks.filter(t => t.status === 'In Progress');
        const finishedTasks = tasks.filter(t => t.status === 'Finished');
        const model = {
          openTasks,
          inProgressTasks,
          finishedTasks
        };

        res.render('index', model);
      })
      .catch(err => console.warn(err));
  },
  getCreate: function (req, res) {
    res.render('create');
  },
  postCreate: function (req, res) {
    let title = req.body.title;
    let status = req.body.status;

    Task.create({
      title,
      status
    })
    .then(() => {
      res.redirect('/');
    })
    .catch(err => console.warn(err));
  },
  getEdit: function (req, res) {
    let id = req.params.id;
    Task
      .findById(id)
      .then((task) => {
        task.open = task.status === 'Open';
        task.inProgress = task.status === 'In Progress';
        task.finished = task.status === 'Finished';
        return res.render('edit', { task });
      })
      .catch(err => console.warn(err));
  },
  postEdit: function (req, res) {
    let id = req.params.id;
    let data = req.body;
    Task
      .findByIdAndUpdate(id, data)
      .then(() => {
      res.redirect('/');
      })
      .catch(err => console.warn(err));
  },
  getDelete: function (req, res) {
    let id = req.params.id;
    Task
      .findById(id)
      .then((task) => {
        task.open = task.status === 'Open';
        task.inProgress = task.status === 'In Progress';
        task.finished = task.status === 'Finished';
        res.render('delete', { task });
      })
      .catch(err => console.log(err));
  },
  postDelete: function (req, res) {
    let id = req.params.id;
    Task
      .findByIdAndRemove(id)
      .then(() => res.redirect('/'))
      .catch(err => console.warm(err));
  }
};