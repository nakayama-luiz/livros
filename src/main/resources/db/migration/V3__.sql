CREATE SEQUENCE IF NOT EXISTS opus_author_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE opus_author
(
    id        BIGINT NOT NULL,
    opus_id   BIGINT,
    author_id BIGINT,
    CONSTRAINT pk_opus_author PRIMARY KEY (id)
);

ALTER TABLE opus_author
    ADD CONSTRAINT FK_OPUS_AUTHOR_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES author (id);

ALTER TABLE opus_author
    ADD CONSTRAINT FK_OPUS_AUTHOR_ON_OPUS FOREIGN KEY (opus_id) REFERENCES opus (id);