DROP TABLE product_image;

CREATE TABLE product_image(
	img_id serial PRIMARY KEY,
	pid int NOT NULL,
	image varchar NOT NULL,
	FOREIGN KEY(pid) REFERENCES product(pid)
);