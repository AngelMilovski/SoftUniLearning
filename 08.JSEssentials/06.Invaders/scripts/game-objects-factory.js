(function (scope) {
    const { SIZES } = scope;
    class GameObjectsFactory {
        constructor(width, height) {
            this.bounds = { width, height };
        }

        createPlayer() {
            const { width, height } = this.bounds;
            const { WIDTH, HEIGHT } = SIZES.PLAYER;
            const left = (width - WIDTH) / 2;
            const top = height - HEIGHT;
            const player = { left, top };
            return player;
        }

        createBullet(left, top) {
            const bullet = { left, top };
            return bullet;
        }

        createEnemy() {
            const { width } = this.bounds;
            const top = 0;
            const left = parseInt(Math.random() * width);
            return { left, top };
        }
    }

    scope.GameObjectsFactory = GameObjectsFactory;
})(window);