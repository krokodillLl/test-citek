-- Пишем запрос по выборке тех чисел, которых не хватает.

SELECT ft.number
from full_table as ft
         left join test as t
                   on ft.number = t.number
where t.number is null;
