
CREATE TABLE sales (
    id bigint PRIMARY KEY,
    price integer,
    quantity integer,
    product integer
);

CREATE TABLE tutorials (
    id bigint PRIMARY KEY,
    description character varying(255),
    published boolean,
    title character varying(255)
);

CREATE TABLE products (
    id bigint PRIMARY KEY,
    name character varying(255),
    price integer,
    inventory integer
);

INSERT INTO tutorials(id, description, published, title) VALUES (1, 'description1', true, 'title1');
INSERT INTO tutorials(id, description, published, title) VALUES (2, 'description2', true, 'title2');
INSERT INTO tutorials(id, description, published, title) VALUES (3, 'description3', true, 'title3');

INSERT INTO sales(id, price, quantity, product) VALUES (1, 12, 10, 1);
INSERT INTO sales(id, price, quantity, product) VALUES (2, 12, 10, 2);
INSERT INTO sales(id, price, quantity, product) VALUES (3, 12, 10, 3);

INSERT INTO products(id, name, price, inventory) VALUES (1, 'name1', 13, 5);
INSERT INTO products(id, name, price, inventory) VALUES (2, 'name2', 14, 2);
INSERT INTO products(id, name, price, inventory) VALUES (3, 'name3', 15, 3);

