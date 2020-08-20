-- Создаем временную таблицу, состоящую из случайных чисел.
create table temp_table
(id serial primary key, number integer);

insert into temp_table (number) values
((SELECT floor(random() * 10 + 1))), ((SELECT floor(random()*(1-20+1))+20)),
((SELECT floor(random()*(1-20+1))+20)), ((SELECT floor(random()*(1-20+1))+20)),
((SELECT floor(random()*(1-20+1))+20)), ((SELECT floor(random()*(1-20+1))+20)),
((SELECT floor(random()*(1-20+1))+20)), ((SELECT floor(random()*(1-20+1))+20)),
((SELECT floor(random()*(1-20+1))+20)), ((SELECT floor(random()*(1-20+1))+20)),
((SELECT floor(random()*(1-20+1))+20)), ((SELECT floor(random()*(1-20+1))+20)),
((SELECT floor(random()*(1-20+1))+20)), ((SELECT floor(random()*(1-20+1))+20));

-- Затем создаем тестовую таблицу на основе случайных отсортированных строк из временной таблицы.
create table test
(id serial primary key, number integer);

insert into test (number) values
((SELECT distinct number from temp_table order by number limit 1 offset 0)), ((SELECT distinct  number from temp_table order by number limit 1 offset 1)),
((SELECT distinct  number from temp_table order by number limit 1 offset 2)), ((SELECT distinct  number from temp_table order by number limit 1 offset 3)),
((SELECT distinct  number from temp_table order by number limit 1 offset 4)), ((SELECT distinct  number from temp_table order by number limit 1 offset 5)),
((SELECT distinct  number from temp_table order by number limit 1 offset 6)), ((SELECT distinct  number from temp_table order by number limit 1 offset 7)),
((SELECT distinct  number from temp_table order by number limit 1 offset 8)), ((SELECT distinct  number from temp_table order by number limit 1 offset 9)),
((SELECT distinct  number from temp_table order by number limit 1 offset 10)), ((SELECT distinct  number from temp_table order by number limit 1 offset 11)),
((SELECT distinct  number from temp_table order by number limit 1 offset 12)), ((SELECT distinct  number from temp_table order by number limit 1 offset 13));

-- Создаем таблицу, заполненную числами по порядку.
create table full_table
(id integer primary key, number serial);

insert into full_table (id) values (1), (2), (3), (4), (5), (6), (7), (8), (9), (10),
                                   (11), (12), (13), (14), (15), (16), (17), (18), (19), (20);
