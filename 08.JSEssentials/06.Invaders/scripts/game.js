; (function (scope) {
  const {
    Renderer,
    GameObjectsFactory,
    SIZES,
    KEY_CODES
  } = scope;

  const setupCanvas = function (gameContainer, width, height) {
    const canvas = document.createElement('canvas');
    canvas.width = width;
    canvas.height = height;
    gameContainer.appendChild(canvas);
    return canvas;
  }

  const trueOrFalse = (chance) => {
    const value = parseInt(Math.random() * 100);
    return value <= chance;
  };

  const getCollisionBox = function ({ left, top }, { WIDTH, HEIGHT }) {
    return {
      left,
      top,
      right: left + WIDTH,
      bottom: top + HEIGHT
    }
  }

  class EventChecker {
    isGoLeftEvent(evt) {
      const { LEFT } = KEY_CODES;
      return evt.keyCode === LEFT;
    }

    isGoRightEvent(evt) {
      const { RIGHT } = KEY_CODES;
      return evt.keyCode === RIGHT;
    }

    isFireEvent(evt) {
      const { FIRE } = KEY_CODES;
      return evt.keyCode === FIRE;
    }
  }

  class Game {
    constructor(selector, width, height) {
      this.gameContainer = document.querySelector(selector);
      this.canvas = setupCanvas(this.gameContainer, width, height);
      this.bounds = {
        width,
        height
      };

      this.renderer = new Renderer(this.canvas, this.bounds);
      this.gameObjectsFactory = new GameObjectsFactory(width, height);
      this.eventChecker = new EventChecker();
      this.player = this.gameObjectsFactory.createPlayer();
      this.bullets = [];
      this.enemies = [];
      this._attachGameEvents();
    }

    start() {
      this._gameLoop();
    }

    _attachGameEvents() {
      window.addEventListener('keydown', (evt) => {
        this._handleMovementEvent(evt);
        this._handleFireEvent(evt);
      });

      window.addEventListener('keyup', () => {
        this.player.direction = null;
      });
    }

    _handleFireEvent(evt) {
      if (!this.eventChecker.isFireEvent(evt)) {
        return;
      }

      const { left, top } = this.player;
      const leftBullet = this.gameObjectsFactory.createBullet(left, top);
      const leftOfRightBullet = left + SIZES.PLAYER.WIDTH - SIZES.BULLET.WIDTH;
      const rightBullet = this.gameObjectsFactory.createBullet(leftOfRightBullet, top);
      this.bullets.push(rightBullet, leftBullet);
    }

    _handleMovementEvent(evt) {
      const { SPEED, WIDTH } = SIZES.PLAYER;
      let alpha = 0;
      if (this.eventChecker.isGoLeftEvent(evt)) {
        alpha = -1;
        this.player.direction = 'left';
      } else if (this.eventChecker.isGoRightEvent(evt)) {
        alpha = +1;
        this.player.direction = 'right';
      }

      this.player.left += alpha * SPEED;
      this.player.left = Math.max(this.player.left, 0);
      this.player.left = Math.min(this.player.left, this.bounds.width - WIDTH)
    }

    _render() {
      this.renderer.renderPlayer(this.player);
      this.renderer.renderBullets(this.bullets);
      this.renderer.renderEnemies(this.enemies);
    }

    _updatePositions() {
      const { SPEED: bulletSpeed } = SIZES.BULLET;
      const { SPEED: enemySpeed } = SIZES.ENEMY;
      const { height } = this.bounds;
      this.bullets.forEach((bullet) => {
        bullet.top += bulletSpeed;
        bullet.isDead = bullet.top <= 0;
      });

      this.enemies.forEach((enemy) => {
        enemy.top += enemySpeed;
        enemy.isDead = enemy.top >= height;
      });
    }

    _createNewGameObjects() {
      if (trueOrFalse(3)) {
        const enemy = this.gameObjectsFactory.createEnemy();
        this.enemies.push(enemy);
      }
    }

    _checkCollision(x, y) {
      const hasHorizontalCollision =
        (x.left <= y.left && y.left <= x.right) ||
        (x.left <= y.right && y.right <= x.right) ||
        (y.left <= x.left && x.left <= y.right) ||
        (y.left <= x.right && x.right <= y.right);

      const hasVerticalCollision =
        (x.top <= y.top && y.top <= x.bottom) ||
        (x.top <= y.bottom && y.bottom <= x.bottom) ||
        (y.top <= x.top && x.top <= y.bottom) ||
        (y.top <= x.bottom && x.bottom <= y.bottom);

        return hasHorizontalCollision && hasVerticalCollision;
    }

    _checkForBulletsWithEnemiesCollisions() {
      const { bullets, enemies } = this;
      bullets.forEach((bullet) => {
        const bulletCollisionBox = getCollisionBox(bullet, SIZES.BULLET);
        enemies.forEach((enemy) => {
          if (bullet.isDead || enemy.isDead) {
            return;
          }
          const enemyCollisionBox = getCollisionBox(enemy, SIZES.ENEMY);
          const hasCollision = this._checkCollision(bulletCollisionBox, enemyCollisionBox);
          bullet.isDead = hasCollision;
          enemy.isDead = hasCollision;
          console.log(hasCollision);
        });
      });
    }

    _checkForCollisions() {
      this._checkForBulletsWithEnemiesCollisions()
    }

    _removeDeadGameObjects() {
      this.bullets = this.bullets.filter(bullet => !bullet.isDead);
      this.enemies = this.enemies.filter(enemy => !enemy.isDead);
    }

    _gameLoop() {
      this.renderer.clear();
      this._render();
      this._updatePositions();
      this._createNewGameObjects();
      this._checkForCollisions();
      this._removeDeadGameObjects();
      window.requestAnimationFrame(() => {
        this._gameLoop();
      });
    }
  }

  scope.Game = Game;
})(window);
