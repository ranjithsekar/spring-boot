DROP TABLE orders_status;

CREATE TABLE orders_status(
	status_id serial PRIMARY KEY,
	status varchar NOT NULL
);

INSERT INTO orders_status VALUES (1,'ORDERED');
INSERT INTO orders_status VALUES (2,'CANCELLED');
INSERT INTO orders_status VALUES (4,'DELIVERY_PENDING');
INSERT INTO orders_status VALUES (5,'DELIVERY_INPROGRESS');
INSERT INTO orders_status VALUES (6,'DELIVERED');
INSERT INTO orders_status VALUES (7,'RETURNED');