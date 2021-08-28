DROP TABLE users_type;

CREATE TABLE users_type(
  user_type_id serial PRIMARY KEY,
  usertype varchar NOT NULL
);

INSERT INTO users_type VALUES(1,'ADMIN');
INSERT INTO users_type VALUES(2,'SELLER');
INSERT INTO users_type VALUES(3,'CUSTOMER');