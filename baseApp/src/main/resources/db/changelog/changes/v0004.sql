CREATE TABLE command_type (
  id BIGSERIAL NOT NULL,
  type_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE command (
  id BIGSERIAL NOT NULL,
  command_type_id BIGINT NOT NULL REFERENCES command_type (id),
  PRIMARY KEY (id)
);

ALTER TABLE "user" ADD COLUMN command_id BIGINT REFERENCES command (id);