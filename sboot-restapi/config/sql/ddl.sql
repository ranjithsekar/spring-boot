DROP TABLE postgres.product;

CREATE TABLE postgres.users(
  userid PRIMARY KEY,
  username varchar NOT NULL,
  password varchar NOT NULL,
  firstname varchar NOT NULL,
  lastname varchar NOT NULL,
  address varchar  
);

CREATE TABLE postgres.product(
  id serial PRIMARY KEY,
  name varchar NOT NULL,
  category varchar NOT NULL,
  price varchar NOT null
);