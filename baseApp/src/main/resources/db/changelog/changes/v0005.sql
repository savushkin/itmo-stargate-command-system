insert into command_type (id, name, description)
    values (1, 'Археологи', 'Изучают полезные ископаемые');

insert into command_type (id, name, description)
    values (2, 'Разведывательный отряд', 'Разведка новых зон');

insert into command_type (id, name, description)
    values (3, 'Дипломат', 'Установка дипломатических связей с жителями Зон');

insert into command_type (id, name, description)
    values (4, 'Команда поддержки', 'Команда быстрого реагирования для поддержки других команд в Зонах в случае угрозу их уничтожения');

INSERT INTO command (name, type_id, description) VALUES ('command1', 1, 'command 1 desc');

UPDATE "user" SET command_id = 1 WHERE id=3;
UPDATE "user" SET command_id = 1 WHERE id=4;
UPDATE "user" SET command_id = 1 WHERE id=5;
UPDATE "user" SET command_id = 1 WHERE id=6;

