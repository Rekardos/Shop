INSERT INTO product (name , price) VALUES ('Keyboard');
INSERT INTO product (name , price) VALUES ('Juicer');
INSERT INTO product (name , price) VALUES ('Phone');
INSERT INTO product (name , price) VALUES ('Television');
INSERT INTO product (name , price) VALUES ('Headphones');


INSERT INTO purchase (age, last_name, name, amount, count, purchase_date) VALUES (22, 'Bon', 'Mark', 2000, 4, '2019-12-07 00:31:55.000000');
INSERT INTO purchase (age, last_name, name, amount, count, purchase_date) VALUES (30, 'John', 'Ops', 5000, 10, '2019-03-15 00:31:55.000000');
INSERT INTO purchase (age, last_name, name, amount, count, purchase_date) VALUES (22, 'Down', 'Johns', 10000, 7, '2019-06-03 00:31:55.000000');
INSERT INTO purchase (age, last_name, name, amount, count, purchase_date) VALUES (23, 'Anton', 'Medvedev', 4000, 19, '2018-11-24 00:31:55.000000');


INSERT INTO products_purchases (purchase_id,product_id) VALUES (1,2);
INSERT INTO products_purchases (purchase_id,product_id) VALUES (1,3);
INSERT INTO products_purchases (purchase_id,product_id) VALUES (1,1);