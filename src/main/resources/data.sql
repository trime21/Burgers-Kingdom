delete
from BURGER_ORDER_BURGER;
delete
from BURGER_INGREDIENTS;
delete
from BURGER;
delete
from BURGER_ORDER;
delete
from "INGREDIENT";

INSERT INTO "INGREDIENT" (ID, NAME, TYPE)
VALUES ('MB', 'wołowina', 0),
       ('MC', 'kurczak', 0),
       ('MF', 'ryba', 0),
       ('MP', 'wieprzowina', 0),
       ('RF', 'pszenna', 1),
       ('RC', 'kukurydziana', 1),
       ('RS', 'sezamowa', 1),
       ('RB', 'maślana', 1),
       ('VT', 'pomidor', 2),
       ('VS', 'sałata', 2),
       ('VP', 'ogórek konserwowy', 2),
       ('VO', 'cebula', 2),
       ('VJ', 'jalapeno', 2),
       ('CB', 'pleśniowy', 3),
       ('CK', 'kozi', 3),
       ('CC', 'cheddar', 3),
       ('CG', 'gouda', 3),
       ('CA', 'american', 3),
       ('SB', 'barbecue', 4),
       ('SK', 'keczup', 4),
       ('ST', 'majonez', 4),
       ('SC', 'klasyczny', 4),
       ('SM', 'mango', 4),
       ('SH', 'pikantny', 4),
       ('OE', 'jajko', 5),
       ('OB', 'bekon', 5),
       ('OA', 'ananas', 5),
       ('OM', 'mango', 5),
       ('OC', 'żurawina', 5),
       ('OO', 'krążki cebulowe', 5);
