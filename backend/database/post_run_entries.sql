BEGIN TRANSACTION;
INSERT INTO recipe (name, type, ingredients, time, instructions) VALUES ('meat','meat','1_meat',1,'eat it');
INSERT INTO recipe (name, type, ingredients, time, instructions) VALUES ('drink','drink','1c_water,4c_sand',4,'drink it');
INSERT INTO recipe (name, type, ingredients, time, instructions) VALUES ('bread','carb','1c_flour,4c_water',20,'bake it');

COMMIT TRANSACTION;
