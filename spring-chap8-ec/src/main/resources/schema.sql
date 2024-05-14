DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_details;

CREATE TABLE categories(
id SERIAL PRIMARY KEY,
name TEXT
);

CREATE TABLE  items(
id SERIAL PRIMARY KEY,
category_id INTEGER,
name TEXT,
price INTEGER
);

CREATE TABLE customers(
id SERIAL PRIMARY KEY,
name TEXT,
addres TEXT,
tel TEXT,
email TEXT
);

CREATE TABLE orders(
id SERIAL PRIMARY KEY,
customer_id INTEGER,
oredered_on DATE,
total_price INTEGER
);

CREATE TABLE  order_details(
id SERIAL PRIMARY KEY,
order_id INTEGER,
item_id INTEGER,
quantity INTEGER
);

