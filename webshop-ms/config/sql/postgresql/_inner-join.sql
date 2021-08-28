--CASE 1: join users and address table
SELECT u.firstname, u.lastname, a.city
FROM users u
INNER JOIN address a ON u.user_id=a.user_id;

SELECT u.firstname, u.lastname, a.city
FROM users u
INNER JOIN address a ON u.user_id=a.user_id
WHERE a.city='chennai';

--CASE 2: join users, product and orders table
SELECT u.firstname, u.lastname, p.title
FROM users u, product p, orders o
WHERE u.user_id=o.user_id and p.pid=o.product_id;

SELECT u.firstname, u.lastname, p.title
FROM users u
INNER JOIN orders o ON u.user_id=o.user_id
INNER JOIN product p ON o.product_id=p.pid;


