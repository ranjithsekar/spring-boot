DROP TABLE login;
CREATE TABLE login (
	userid 		serial BININT PRIMARY KEY,
	username 	VARCHAR NOT NULL,
	password 	VARCHAR NOT NULL,
	lastlogin 	TIMESTAMP DEFAULT now()
);