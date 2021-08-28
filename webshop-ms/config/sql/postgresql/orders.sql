DROP TABLE orders;

CREATE TABLE orders(
	order_id serial PRIMARY KEY,
	product_id int NOT NULL,
	user_id int NOT NULL,
	order_date TIMESTAMP NOT NULL,
	FOREIGN KEY(product_id) REFERENCES product(pid),
	FOREIGN KEY(user_id) REFERENCES users(user_id)
);

INSERT INTO orders VALUES(1,1,1,now());
INSERT INTO orders VALUES(2,2,2,now());