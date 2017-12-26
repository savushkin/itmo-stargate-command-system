CREATE TABLE zone (
  id BIGSERIAL NOT NULL,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(4096) NOT NULL,
  glyph_1 NUMERIC,
  glyph_2 NUMERIC,
  glyph_3 NUMERIC,
  glyph_4 NUMERIC,
  glyph_5 NUMERIC,
  glyph_6 NUMERIC,
  glyph_7 NUMERIC,
  glyph_8 NUMERIC,
  PRIMARY KEY (id)
);

INSERT INTO zone (name, description, glyph_1, glyph_2, glyph_3, glyph_4, glyph_5, glyph_6) VALUES
  ('ABYDOS', 'Original destination', 27,7,15,32,12,30);
INSERT INTO zone (name, description, glyph_1, glyph_2, glyph_3, glyph_4, glyph_5, glyph_6) VALUES
  ('PX1-767', 'Camelot', 20,2,35,8,26,15);
INSERT INTO zone (name, description, glyph_1, glyph_2, glyph_3, glyph_4, glyph_5, glyph_6) VALUES
  ('CHULAK', 'Jaffa homeworld', 9,2,23,15,37,20);
INSERT INTO zone (name, description, glyph_1, glyph_2, glyph_3, glyph_4, glyph_5, glyph_6) VALUES
  ('EARTH', 'The SGC Stargate', 28,26,5,36,11,29);
INSERT INTO zone (name, description, glyph_1, glyph_2, glyph_3, glyph_4, glyph_5, glyph_6, glyph_7) VALUES
  ('OTHALA', 'Asgard homeworld', 11,27,23,16,33,3,9);
INSERT INTO zone (name, description, glyph_1, glyph_2, glyph_3, glyph_4, glyph_5, glyph_6) VALUES
  ('P34-353J', 'Desert Tok ra base', 38,9,28,15,35,3);
INSERT INTO zone (name, description, glyph_1, glyph_2, glyph_3, glyph_4, glyph_5, glyph_6) VALUES
  ('P3X-984', 'Alpha / Beta Site', 29,5,36,6,26,8);
INSERT INTO zone (name, description, glyph_1, glyph_2, glyph_3, glyph_4, glyph_5, glyph_6) VALUES
  ('TOLLAN', 'Destroyed homeworld', 4,29,8,22,18,25);
INSERT INTO zone (name, description, glyph_1, glyph_2, glyph_3, glyph_4, glyph_5, glyph_6) VALUES
  ('TOLLANA', 'New homeworld', 4,29,8,22,18,25);
