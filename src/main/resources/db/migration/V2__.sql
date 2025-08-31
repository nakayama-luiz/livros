CREATE SEQUENCE IF NOT EXISTS opus_edition_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE opus_edition
(
    id         BIGINT NOT NULL,
    edition_id BIGINT,
    opus_id    BIGINT,
    CONSTRAINT pk_opus_edition PRIMARY KEY (id)
);

ALTER TABLE opus_edition
    ADD CONSTRAINT FK_OPUS_EDITION_ON_EDITION FOREIGN KEY (edition_id) REFERENCES edition (id);

ALTER TABLE opus_edition
    ADD CONSTRAINT FK_OPUS_EDITION_ON_OPUS FOREIGN KEY (opus_id) REFERENCES opus (id);

CREATE INDEX opus_edition_id_idx ON opus_edition (id, opus_id);
