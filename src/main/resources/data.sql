SET SCHEMA STORE;
INSERT INTO BRAND (ID, NAME) VALUES
(1, 'ZARA'),
(2, 'H&M');
INSERT INTO PRODUCT (ID, NAME) VALUES
(35455, 'JEANS'),
(35456, 'T-SHIRT');
INSERT INTO PRICE (ID, BRAND_ID, START_DATE, END_DATE , PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE , CURR) VALUES
(1, 1 ,'2020-06-14 00:00:00+02', '2020-12-31 23:59:59+01', 1, 35455, 0, 35.50, 'EUR'),
(2, 1 ,'2020-06-14 15:00:00+02', '2020-06-14 18:30:00+02', 2, 35455, 1, 25.45, 'EUR'),
(3, 1 ,'2020-06-15 00:00:00+02', '2020-06-15 11:00:00+02', 3, 35455, 1, 30.50, 'EUR'),
(4, 1 ,'2020-06-15 16:00:00+02', '2020-12-31 23:59:59+01', 4, 35455, 1, 38.95, 'EUR');