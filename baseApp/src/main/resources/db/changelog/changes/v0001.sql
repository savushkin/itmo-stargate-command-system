CREATE TABLE command_type(
  id BIGSERIAL NOT NULL,
  name VARCHAR (200) NOT NULL,
  description TEXT,
  PRIMARY  KEY (id)
);

CREATE TABLE command (
  id BIGSERIAL NOT NULL,
  name VARCHAR (200) NOT NULL,
  type_id BIGINT NOT NULL REFERENCES "command_type" (id),
  description TEXT,
  primary key(id)
);

CREATE TABLE "user" (
  id BIGSERIAL NOT NULL,
  username VARCHAR(45) UNIQUE NOT NULL,
  name VARCHAR (200) ,
  second_name VARCHAR (200),
  surname VARCHAR (200),
  rank VARCHAR (200),
  command_id BIGINT references "command" (id),
  password VARCHAR(255) NOT NULL,
  enabled BOOLEAN NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user_role (
  id BIGSERIAL NOT NULL,
  user_id BIGINT NOT NULL REFERENCES "user" (id),
  role varchar (200),
  PRIMARY KEY (id)
);

create table shevron(
  id BIGSERIAL NOT NULL,
  name VARCHAR (200) NOT NULL,
  PRIMARY  KEY (id)
);

CREATE TABLE address_star_gate(
  id BIGSERIAL NOT NULL,
  human_name VARCHAR (200) NOT NULL,
  physical_name VARCHAR (200) not null,
  glyph1 BIGINT references "shevron"(id),
  glyph2 BIGINT references "shevron"(id),
  glyph3 BIGINT references "shevron"(id),
  glyph4 BIGINT references "shevron"(id),
  glyph5 BIGINT references "shevron"(id),
  glyph6 BIGINT references "shevron"(id),
  glyph7 BIGINT references "shevron"(id),
  PRIMARY KEY (id)
);

CREATE TABLE zone (
  id BIGSERIAL NOT NULL,
  name VARCHAR (200) NOT NULL,
  climatic_conditions TEXT,
  mititary_threats TEXT,
  minerals TEXT,
  address_id BIGINT NOT NULL REFERENCES "address_star_gate" (id),
  PRIMARY KEY (id)
);

CREATE  TABLE mission (
  id BIGSERIAL NOT NULL,
  name varchar (200) NOT NULL ,
  zone_to_id BIGINT NOT NULL REFERENCES "zone" (id),
  date_create DATE NOT NULL,
  date_departure DATE NOT NULL,
  command_departure BIGINT NOT NULL REFERENCES "command" (id),
  description TEXT NOT NULL,
  PRIMARY  KEY(id)
);

CREATE TABLE report (
  id BIGSERIAL NOT NULL,
  user_id BIGINT NOT NULL REFERENCES "user" (id),
  mission_id BIGINT NOT NULL REFERENCES "mission" (id),
  description TEXT not NULL,
  report_date DATE NOT NULL,
  PRIMARY  KEY (id)
);