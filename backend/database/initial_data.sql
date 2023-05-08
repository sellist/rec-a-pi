BEGIN TRANSACTION;

DROP TABLE IF EXISTS recipe;

CREATE TABLE recipe (

	recipe_id serial,
	name varchar(100),
	type varchar(50),
	ingredients varchar(999),
	time int,
	instructions varchar(999),

	CONSTRAINT pk_recipe_id PRIMARY KEY (recipe_id)
);


COMMIT;
