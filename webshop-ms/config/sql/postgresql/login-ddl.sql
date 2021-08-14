DROP TABLE login;
CREATE TABLE login (
	userid 		BIGINT NOT NULL,
	username 	VARCHAR NOT NULL,
	password 	VARCHAR NOT NULL,
	lastlogin 	TIMESTAMP DEFAULT now()
);