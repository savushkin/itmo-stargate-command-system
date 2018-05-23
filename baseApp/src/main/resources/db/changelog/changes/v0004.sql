INSERT INTO shevron (id, name) VALUES
  (1, '1');
INSERT INTO shevron (id, name) VALUES
  (2, '2');
INSERT INTO shevron (id, name) VALUES
  (3, '3');
INSERT INTO shevron (id, name) VALUES
  (4, '4');
INSERT INTO shevron (id, name) VALUES
  (5, '5');
INSERT INTO shevron (id, name) VALUES
  (6, '6');
INSERT INTO shevron (id, name) VALUES
  (7, '7');

INSERT INTO address_star_gate (id, human_name, physical_name, glyph1, glyph2, glyph3, glyph4, glyph5, glyph6) VALUES
(1, 'ABYDOS', 'Original destination', 1, 2, 3, 4, 5, 6);

INSERT INTO address_star_gate (id, human_name, physical_name, glyph1, glyph2, glyph3, glyph4, glyph5, glyph6) VALUES
(2, 'Земля', 'pi3x', 7, 5, 6, 1, 4, 2);

INSERT INTO zone (id, name, climatic_conditions, mititary_threats, minerals, address_id) VALUES
  (1, 'Earth', 'резко-континентальный климат', 'военных действий не наблюдается', 'много полезных ископаемых', 1);

INSERT INTO zone (id, name, climatic_conditions, mititary_threats, minerals, address_id) VALUES
  (2, 'абидос', 'Пустыня, осадков нет в течение 100 лет', 'Захвачена гоаулдом Ра', 'Нет полезных ископаемых', 2);