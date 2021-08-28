DROP TABLE product;

CREATE TABLE product(
  pid serial PRIMARY KEY,
  cid int NOT NULL,
  scid int NOT NULL,  
  title varchar NOT NULL,
  description varchar NOT NULL,
  price int NOT null,
  rating int,
  created_at timestamp DEFAULT now(),
  modified_at timestamp DEFAULT now()
);

INSERT INTO product VALUES (1,1,1,'realme c1','realme c1 desc',7000,3, now(), now());
INSERT INTO product VALUES (2,1,1,'realme c2','realme c2 desc',8000,4, now(), now());
INSERT INTO product VALUES (3,1,1,'realme c3','realme c3 desc',9000,4, now(), now());
