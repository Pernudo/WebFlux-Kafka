CREATE TABLE IF NOT EXISTS products (
    id_product INT NOT NULL PRIMARY KEY,
    name VARCHAR(50),
    category VARCHAR(50),
    price DOUBLE,
    stock INT
);

INSERT INTO products VALUES (100,_utf8'Azúcar',_utf8'Alimentación',1.10,20);
INSERT INTO products VALUES (101,'Leche',_utf8'Alimentación',1.20,15);
INSERT INTO products VALUES (102,_utf8'Jabón','Limpieza',0.89,30);
INSERT INTO products VALUES (103,'Mesa','Hogar',125,4);
INSERT INTO products VALUES (104,_utf8'Televisión','Hogar',650,10);
INSERT INTO products VALUES (105,'Huevos',_utf8'Alimentación',2.20,30);
INSERT INTO products VALUES (106,'Fregona','Limpieza',3.40,6);
INSERT INTO products VALUES (107,'Detergente','Limpieza',8.7,12);

CREATE TABLE IF NOT EXISTS shippings (
    id_shipping INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product VARCHAR(50),
    date_shipping DATETIME,
    address VARCHAR(200),
    status VARCHAR(50)
);