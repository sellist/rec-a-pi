BEGIN TRANSACTION;
INSERT INTO recipe (name) VALUES ('beef');
INSERT INTO recipe (name) VALUES ('chicken');
INSERT INTO recipe (name) VALUES ('bread');

COMMIT TRANSACTION;
