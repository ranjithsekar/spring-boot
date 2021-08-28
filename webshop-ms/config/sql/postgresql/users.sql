DROP TABLE users;

CREATE TABLE users(
  user_id serial PRIMARY KEY,
  user_type_id int NOT NULL,
  firstname varchar NOT NULL,
  lastname varchar NOT NULL,
  created_at timestamp default now(),
  modified_at timestamp default now(),
  FOREIGN KEY(user_type_id) REFERENCES users_type(user_type_id)
);

INSERT INTO users VALUES(1,1,'Ranjith','Sekar', now(), now());
INSERT INTO users VALUES(2,2,'Sekar','Chinna', now(), now());
INSERT INTO users VALUES(3,3,'Kabilan','Ranjith', now(), now());
INSERT INTO users VALUES(4,1,'Bala','Kumar', now(), now());
INSERT INTO users VALUES(5,2,'John','Abraham', now(), now());
INSERT INTO users VALUES(6,3,'Sayeed','Khan', now(), now());