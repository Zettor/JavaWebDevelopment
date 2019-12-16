USE ps4_shop;

CREATE TABLE users
(
    id       INTEGER      NOT NULL AUTO_INCREMENT,
    login    VARCHAR(255)  NOT NULL UNIQUE,
    password CHAR(128) NOT NULL,
    salt     CHAR(128)  NOT NULL,
    email    VARCHAR(255) NOT NULL,
    phone    VARCHAR(15),
    country_id  VARCHAR(50),
    city_id     VARCHAR(50),
    createAt TIMESTAMP NOT NULL,
    status   TINYINT      NOT NULL CHECK (status IN (0, 1)),
    role     TINYINT      NOT NULL CHECK (role IN (0, 1)),
    PRIMARY KEY (id)
) ENGINE = INNODB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE genres
(
    id   INTEGER     NOT NULL AUTO_INCREMENT,
    name VARCHAR(15) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8;

CREATE TABLE countries
(
    id   INTEGER     NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8;

CREATE TABLE cities
(
    id   INTEGER     NOT NULL AUTO_INCREMENT,
    country_id   INTEGER     NOT NULL,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (country_id)
        REFERENCES countries (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) DEFAULT CHARACTER SET utf8;

CREATE TABLE currencies
(
    id   INTEGER    NOT NULL AUTO_INCREMENT,
    name VARCHAR(3) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8;


CREATE TABLE accessory_categories
(
    id       INTEGER     NOT NULL AUTO_INCREMENT,
    category VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) ENGINE = INNODB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE games
(
    id           INTEGER     NOT NULL AUTO_INCREMENT,
    name         VARCHAR(255) NOT NULL UNIQUE,
    img_path     VARCHAR(255) NOT NULL UNIQUE,
    genre_id     INTEGER NOT NULL,
    exclusivity  TINYINT CHECK (exclusivity IN (0, 1)),
    description  TEXT        NOT NULL,
    release_date TIMESTAMP   NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (genre_id)
        REFERENCES genres (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE = INNODB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE trade_game_offers
(
    id          INTEGER   NOT NULL AUTO_INCREMENT,
    game_id     INTEGER   NOT NULL,
    user_id     INTEGER   NOT NULL,
    cost        DOUBLE,
    currency_id INTEGER   NOT NULL,
    description TEXT,
    createdAt   TIMESTAMP NOT NULL,
    closedAt    DATE,
    status      TINYINT   NOT NULL CHECK (status IN (0, 1, 2)),
    PRIMARY KEY (id),
    FOREIGN KEY (game_id)
        REFERENCES games (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    FOREIGN KEY (currency_id)
        REFERENCES currencies (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE = INNODB
  DEFAULT CHARACTER SET utf8;



CREATE TABLE trade_console_offers
(
    id          INTEGER      NOT NULL AUTO_INCREMENT,
    user_id     INTEGER      NOT NULL,
    name        VARCHAR(256) NOT NULL,
    cost        DOUBLE       NOT NULL,
    currency    VARCHAR(3)   NOT NULL,
    description TEXT,
    createdAt   TIMESTAMP    NOT NULL,
    closedAt    TIMESTAMP,
    status      TINYINT      NOT NULL CHECK (status IN (0, 1, 2)),
    PRIMARY KEY (id),
    FOREIGN KEY (`user_id`)
        REFERENCES `users` (`id`)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE = INNODB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE trade_accessories_offers
(
    id          INTEGER      NOT NULL AUTO_INCREMENT,
    user_id     INTEGER      NOT NULL,
    name        VARCHAR(255) NOT NULL,
    category_id INTEGER,
    cost        INTEGER      NOT NULL,
    currency    VARCHAR(3)   NOT NULL,
    description TEXT,
    createdAt   TIMESTAMP    NOT NULL,
    closedAt    TIMESTAMP,
    status      TINYINT      NOT NULL CHECK (status IN (0, 1, 2)),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES `users` (`id`)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    FOREIGN KEY (category_id)
        REFERENCES accessory_categories (`id`)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE = INNODB
  DEFAULT CHARACTER SET utf8;

