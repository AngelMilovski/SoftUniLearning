const mongoose = require('mongoose');

const bandSchema = new mongoose.Schema({
    name: {
      type: mongoose.Schema.Types.String,
      required: true
    },
    members: {
      type: mongoose.Schema.Types.String,
      required: true
    },
    honorarium: {
      // type: [ "double" ],
      //          minimum: 1,
      type: mongoose.Schema.Types.Number,
      required: true
    },
    genre: {
      type: mongoose.Schema.Types.String,
      required: true
    }
  // TODO:
});

const Band = mongoose.model('Band', bandSchema);
module.exports = Band;