DROP TABLE sboot_jpa_table_joins.users;
CREATE TABLE sboot_jpa_table_joins.users
(
   id SERIAL PRIMARY KEY,
   username VARCHAR NOT NULL,
   password VARCHAR NOT NULL,
   firstname VARCHAR NOT NULL,
   lastname VARCHAR NOT NULL,
   address VARCHAR,
   created_at TIMESTAMP DEFAULT now ()
);

INSERT INTO sboot_jpa_table_joins.users(username,password,firstname,lastname,address) VALUES('bob','adams','Bob','Adams','Chennai');
INSERT INTO sboot_jpa_table_joins.users(username,password,firstname,lastname,address) VALUES('john','doe','John','Doe','Mumbai');