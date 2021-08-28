DROP TABLE users;

CREATE TABLE users(
  user_id serial PRIMARY KEY,
  usertype varchar NOT NULL,
  firstname varchar NOT NULL,
  lastname varchar NOT NULL,
  created_at timestamp default now(),
  modified_at timestamp default now()
);

INSERT INTO users VALUES(1,'ADMIN','Ranjith','Sekar', now(), now());
INSERT INTO users VALUES(2,,'SELLER','Sekar','Chinna', now(), now());
INSERT INTO users VALUES(3,,'CUSTOMER','Kabilan','Ranjith', now(), now());