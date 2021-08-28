DROP TABLE category;

CREATE TABLE category(
	category_id serial PRIMARY KEY,
	name varchar NOT NULL	
);

INSERT INTO category VALUES(1,'mobile');
INSERT INTO category VALUES(2,'electronic');
INSERT INTO category VALUES(3,'appliance');
INSERT INTO category VALUES(4,'grocery');
INSERT INTO category VALUES(5,'fashion');
