insert into command_type (id, name, description)
    values (1, 'Археологи', 'Изучают полезные ископаемые');

insert into command_type (id, name, description)
    values (2, 'Разведывательный отряд', 'Разведка новых зон');

insert into command_type (id, name, description)
    values (3, 'Дипломат', 'Установка дипломатических связей с жителями Зон');

insert into command_type (id, name, description)
    values (4, 'Команда поддержки', 'Команда быстрого реагирования для поддержки других команд в Зонах в случае угрозу их уничтожения');

insert  into command (id, name, type_id, description)
    values(1, 'SG-1', 2, 'Главная разведка');

update  "user"
  set command_id = 1
where id = 1 or id = 5;