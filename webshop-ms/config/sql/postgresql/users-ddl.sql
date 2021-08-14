DROP TABLE users;
CREATE TABLE users (
	userid SERIAL PRIMARY KEY,
	usertype VARCHAR NOT NULL,
	firstname VARCHAR NOT NULL,
	lastname VARCHAR NOT NULL,
	email VARCHAR NOT NULL,
	address VARCHAR NOT NULL,
	phone BIGINT NOT NULL,
	created_at timestamp default now()
);