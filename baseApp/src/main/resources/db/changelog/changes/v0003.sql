INSERT INTO user_role (user_id, role) VALUES
  (1, 'ROLE_USER');
INSERT INTO user_role (user_id, role) VALUES
  (1, 'ROLE_OPERATOR');
INSERT INTO user_role (user_id, role) VALUES
  (2, 'ROLE_USER');
INSERT INTO user_role (user_id, role) VALUES
  (2, 'ROLE_COMMANDER');
INSERT INTO user_role (user_id, role) VALUES
  (3, 'ROLE_USER');
INSERT INTO user_role (user_id, role) VALUES
  (3, 'ROLE_SG');
INSERT INTO user_role (user_id, role) VALUES
  (3, 'ROLE_ARCHAEOLOGIST');
INSERT INTO user_role (user_id, role) VALUES
  (4, 'ROLE_USER');
INSERT INTO user_role (user_id, role) VALUES
  (4, 'ROLE_SG');
INSERT INTO user_role (user_id, role) VALUES
  (4, 'ROLE_GEOLOGIST');
INSERT INTO user_role (user_id, role) VALUES
  (5, 'ROLE_USER');
INSERT INTO user_role (user_id, role) VALUES
  (5, 'ROLE_SG');
INSERT INTO user_role (user_id, role) VALUES
  (5, 'ROLE_SCOUT');
INSERT INTO user_role (user_id, role) VALUES
  (6, 'ROLE_USER');
INSERT INTO user_role (user_id, role) VALUES
  (6, 'ROLE_SG');
INSERT INTO user_role (user_id, role) VALUES
  (6, 'ROLE_DIPLOMAT');

INSERT INTO user_role (user_id, role) VALUES
  (7, 'ROLE_DRONE');

INSERT INTO "user" (username, password, enabled) VALUES
  ('admin', '$2a$04$Z0s5s9dWwDLqeYuyplbAJem760d9e5gE.7xp.jQn6ANa7SCMb2Iaq', TRUE);
INSERT INTO user_role (user_id, role) VALUES
  (8, 'ROLE_USER');
INSERT INTO user_role (user_id, role) VALUES
  (8, 'ROLE_ADMINISTRATOR');

INSERT INTO "user" (username, password, enabled) VALUES
  ('adm', '$2a$04$Z0s5s9dWwDLqeYuyplbAJem760d9e5gE.7xp.jQn6ANa7SCMb2Iaq', TRUE);
INSERT INTO user_role (user_id, role) VALUES
  (8, 'ROLE_USER');