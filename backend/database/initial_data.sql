BEGIN TRANSACTION;

DROP TABLE IF EXISTS recipe;

CREATE TABLE recipe (

	id serial,
	name varchar(100) UNIQUE,
	type varchar(50),
	ingredients varchar(9999),
	time int NOT NULL,
	instructions varchar(9999),

	CONSTRAINT pk_recipe_id PRIMARY KEY (id)
);


COMMIT;
