const mongoose = require('mongoose');

let tripSchema = mongoose.Schema({
    origin: {
        type: mongoose.Schema.Types.String,
        required: true
    },
    destination: {
        type: mongoose.Schema.Types.String,
        required: true
    },
    business: {
        type: Number,
        min: 1
    },
    economy: {
        type: Number,
        min: 1
    }
    //TODO: Implement me ...
});

let Trip = mongoose.model('Trip', tripSchema);

module.exports = Trip;