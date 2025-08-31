CREATE SEQUENCE IF NOT EXISTS author_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS bookcase_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS edition_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS human_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS opus_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS publisher_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS reading_history_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE author
(
    id        BIGINT       NOT NULL,
    name      VARCHAR(255) NOT NULL,
    biography TEXT,
    picture   VARCHAR(255),
    CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE author_vulgos
(
    author_id BIGINT NOT NULL,
    vulgos    VARCHAR(255)
);

CREATE TABLE bookcase
(
    id          BIGINT NOT NULL,
    name        VARCHAR(255),
    user_id     BIGINT,
    favorite    BOOLEAN,
    rating      DOUBLE PRECISION,
    start_date  date,
    end_date    date,
    status      SMALLINT,
    editions_id BIGINT NOT NULL,
    read_pages  BIGINT,
    CONSTRAINT pk_bookcase PRIMARY KEY (id)
);

CREATE TABLE edition
(
    id               BIGINT       NOT NULL,
    title            VARCHAR(255) NOT NULL,
    isbn             VARCHAR(255) NOT NULL,
    pages            BIGINT       NOT NULL,
    publication_date date,
    synopsis         VARCHAR(255),
    cover            VARCHAR(255),
    publisher_id     BIGINT       NOT NULL,
    CONSTRAINT pk_edition PRIMARY KEY (id)
);

CREATE TABLE edition_language
(
    edition_id BIGINT       NOT NULL,
    language   VARCHAR(255) NOT NULL
);

CREATE TABLE human
(
    id           BIGINT       NOT NULL,
    display_name VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL,
    username     VARCHAR(255) NOT NULL,
    profile_pic  VARCHAR(255),
    CONSTRAINT pk_human PRIMARY KEY (id)
);

CREATE TABLE opus
(
    id    BIGINT     NOT NULL,
    title VARCHAR(255),
    time  BIGINT     NOT NULL,
    era   VARCHAR(2) NOT NULL,
    CONSTRAINT pk_opus PRIMARY KEY (id)
);

CREATE TABLE publisher
(
    id          BIGINT       NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    CONSTRAINT pk_publisher PRIMARY KEY (id)
);

CREATE TABLE reading_history
(
    id           BIGINT NOT NULL,
    date         date   NOT NULL,
    pages        BIGINT NOT NULL,
    bookcases_id BIGINT NOT NULL,
    CONSTRAINT pk_readinghistory PRIMARY KEY (id)
);

ALTER TABLE edition
    ADD CONSTRAINT uc_edition_isbn UNIQUE (isbn);

ALTER TABLE human
    ADD CONSTRAINT uc_human_username UNIQUE (username);

ALTER TABLE bookcase
    ADD CONSTRAINT FK_BOOKCASE_ON_EDITIONS FOREIGN KEY (editions_id) REFERENCES edition (id);

ALTER TABLE bookcase
    ADD CONSTRAINT FK_BOOKCASE_ON_USER FOREIGN KEY (user_id) REFERENCES human (id);

ALTER TABLE edition
    ADD CONSTRAINT FK_EDITION_ON_PUBLISHER FOREIGN KEY (publisher_id) REFERENCES publisher (id);

ALTER TABLE reading_history
    ADD CONSTRAINT FK_READINGHISTORY_ON_BOOKCASES FOREIGN KEY (bookcases_id) REFERENCES bookcase (id);

ALTER TABLE author_vulgos
    ADD CONSTRAINT fk_author_vulgos_on_author FOREIGN KEY (author_id) REFERENCES author (id);

ALTER TABLE edition_language
    ADD CONSTRAINT fk_edition_language_on_edition FOREIGN KEY (edition_id) REFERENCES edition (id);
