INSERT INTO command_type (type_name) VALUES
  ('SCOUTS');
INSERT INTO command_type (type_name) VALUES
  ('ARCHAEOLOGISTS');
INSERT INTO command_type (type_name) VALUES
  ('GEOLOGISTS');
INSERT INTO command_type (type_name) VALUES
  ('DIPLOMATS');

INSERT INTO command (command_type_id) VALUES
  (1);

UPDATE "user" SET command_id = 1 WHERE id=3;
UPDATE "user" SET command_id = 1 WHERE id=4;
UPDATE "user" SET command_id = 1 WHERE id=5;
UPDATE "user" SET command_id = 1 WHERE id=6;