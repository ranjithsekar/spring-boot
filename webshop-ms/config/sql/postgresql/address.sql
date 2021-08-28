DROP TABLE address;

CREATE TABLE address(
	addr_id serial PRIMARY KEY,
	user_id int NOT NULL,
	door_no int NOT NULL,
	street varchar NOT NULL,
	city varchar NOT NULL,
	state varchar NOT NULL,
	country varchar NOT NULL,
	postal_code int NOT NULL,
	phone bigint NOT NULL,
	created_at timestamp default now(),
	modified_at timestamp default now(),
	FOREIGN KEY(user_id) REFERENCES users(user_id)
);

INSERT INTO address VALUES(1,1,22,'nehru street','chennai','tamilnadu','india','600123',9876542132, now(), now());
INSERT INTO address VALUES(2,2,23,'gandhi street','chennai','tamilnadu','india','600133',90006542132, now(), now());
INSERT INTO address VALUES(3,3,24,'patel street','chennai','tamilnadu','india','600233',90006542000, now(), now());