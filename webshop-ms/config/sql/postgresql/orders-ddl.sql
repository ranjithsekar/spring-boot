DROP TABLE orders;
CREATE TABLE orders (
	userid VARCHAR NOT NULL,
	orderid VARCHAR NOT NULL,
	productid VARCHAR NOT NULL,
	order_date TIMESTAMP NOT NULL,
	delivery_date TIMESTAMP NOT NULL,
	delivery_status VARCHAR NOT NULL
);