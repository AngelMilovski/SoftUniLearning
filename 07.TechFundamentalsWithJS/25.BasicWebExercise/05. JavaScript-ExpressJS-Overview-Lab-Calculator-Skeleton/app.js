const express = require('express');
const config = require('./config/config');
const app = express();
const port = 3000;

let env = 'development';
require('./config/express')(app, config[env]);
require('./config/routes')(app);

module.exports = app;