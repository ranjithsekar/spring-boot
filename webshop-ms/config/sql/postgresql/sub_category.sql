DROP TABLE sub_category;

CREATE TABLE sub_category(
	scid serial PRIMARY KEY,
	cid int NOT NULL,
	name varchar NOT NULL	
);

INSERT INTO sub_category VALUES(1,1,'smartphone');
INSERT INTO sub_category VALUES(2,1,'featurephone');
INSERT INTO sub_category VALUES(3,2,'laptop');
INSERT INTO sub_category VALUES(4,2,'tablet');
INSERT INTO sub_category VALUES(5,3,'ac');
INSERT INTO sub_category VALUES(6,3,'fridge');
INSERT INTO sub_category VALUES(7,4,'staple');
INSERT INTO sub_category VALUES(8,4,'beverage');
INSERT INTO sub_category VALUES(9,5,'men');
INSERT INTO sub_category VALUES(10,5,'women');