/**
	orderid - can be duplicate since an order can contain multiple products.
**/

DROP TABLE sboot_jpa_table_joins.order;
CREATE TABLE sboot_jpa_table_joins.order
(
   orderid SERIAL INTEGER NOT NULL,
   userid INTEGER NOT NULL,
   productid INTEGER NOT NULL,
   status VARCHAR NOT NULL,
   FOREIGN KEY(userid) REFERENCES sboot_jpa_table_joins.users(userid),
   FOREIGN KEY(productid) REFERENCES sboot_jpa_table_joins.product(id)   
);

INSERT INTO sboot_jpa_table_joins.order(userid,productid,status) VALUES(1,4,'OPEN');
INSERT INTO sboot_jpa_table_joins.order(userid,productid,status) VALUES(2,2,'DELIVERED');
INSERT INTO sboot_jpa_table_joins.order(userid,productid,status) VALUES(2,4,'PENDING');
INSERT INTO sboot_jpa_table_joins.order(userid,productid,status) VALUES(1,7,'OPEN');
INSERT INTO sboot_jpa_table_joins.order(orderid,userid,productid,status) VALUES(1,1,8,'OPEN');