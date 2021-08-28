DROP TABLE login;

CREATE TABLE login (
	user_id	BIGINT NOT NULL,
	username VARCHAR NOT NULL,
	password VARCHAR NOT NULL,
	lastlogin TIMESTAMP DEFAULT now(),
	FOREIGN KEY(user_id) REFERENCES users(user_id)
);

INSERT INTO login VALUES(1, 'ranjith','ranpass', now());
INSERT INTO login VALUES(2, 'sekar','sekpass', now());
INSERT INTO login VALUES(3, 'kabilan','kabipass', now());