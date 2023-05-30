DROP TABLE sboot_jpa_table_joins.product;
CREATE TABLE sboot_jpa_table_joins.product
(
   id SERIAL PRIMARY KEY,
   name VARCHAR NOT NULL,
   category VARCHAR NOT NULL,
   price INTEGER NOT NULL,
   created_at TIMESTAMP DEFAULT now (),
   updated_at TIMESTAMP DEFAULT now ()
);

INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Samsung S8', 'Mobile', 75000);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Realme 6', 'Mobile', 12000);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Usha Fan', 'Fan', 1100);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Orient Fan', 'Fan', 1200);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Dell Vostro', 'Laptop', 79000);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Lenovo 441', 'Laptop', 88000);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('IFB Washer', 'Washing Machine', 25000);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Siemens', 'Washing Machine', 3300);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Redmi 8', 'Mobile', 7000);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Redmi 8', 'Mobile', 9000);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Samsung M30', 'Mobile', 13000);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Panasonic Eluga', 'Mobile', 9000);
INSERT INTO sboot_jpa_table_joins.product(name, category, price) VALUES('Nokia 7', 'Mobile', 12000);