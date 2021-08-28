DROP TABLE delivery;

CREATE TABLE delivery(
	order_id int NOT NULL,
	order_status_id int NOT NULL,
	delivered_date TIMESTAMP NOT NULL,
	FOREIGN KEY(order_id) REFERENCES orders(order_id),
	FOREIGN KEY(order_status_id) REFERENCES orders_status(status_id)
);

INSERT INTO delivery VALUES (1, 1, now());
INSERT INTO delivery VALUES (2, 2, now());