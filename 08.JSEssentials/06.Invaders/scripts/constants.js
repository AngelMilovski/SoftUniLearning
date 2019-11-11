(function (scope) {
    const SIZES = {
        PLAYER: {
            WIDTH: 140,
            HEIGHT: 160,
            SPEED: 15,
        },

        BULLET: {
            WIDTH: 50,
            HEIGHT: 30,
            SPEED: -5,
        },

        ENEMY: {
            WIDTH: 30,
            HEIGHT: 30,
            SPEED: 5,
        },
    };

    const KEY_CODES = {
        LEFT: 37,
        RIGHT: 39,
        FIRE: 32,
    };

    scope.SIZES = SIZES;
    scope.KEY_CODES = KEY_CODES;
})(window);
