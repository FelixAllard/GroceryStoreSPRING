USE `grocerystore-db`;

DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS products;

CREATE TABLE IF NOT EXISTS clients (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_id VARCHAR(36),
    name VARCHAR(50),
    email VARCHAR(40),
    phone VARCHAR(20),
    street VARCHAR(30),
    city VARCHAR(15),
    state VARCHAR(20),
    postal_code VARCHAR(7),
    country VARCHAR(13),
    total_spent DECIMAL(10,2),
    number_of_points INTEGER,
    membership_status VARCHAR(20),
    value DECIMAL(10,2),
    currency VARCHAR(3)
);
CREATE TABLE IF NOT EXISTS products (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id VARCHAR(36),
    name VARCHAR(50),
    description VARCHAR(250),
    pallet_id INTEGER(10),
    manufacturer VARCHAR(30),
    day INTEGER(10),
    month INTEGER(10),
    year INTEGER(10),
    product_availability VARCHAR(15),
    value DECIMAL(10,2),
    currency VARCHAR(3),
    category_name VARCHAR(30),
    category_description VARCHAR(250),
    url VARCHAR(100),
    alt_text VARCHAR(70)
    );
CREATE TABLE IF NOT EXISTS employees (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id VARCHAR(36),
    name VARCHAR(50),
    description VARCHAR(250),
    pallet_id INTEGER(10),
    manufacturer VARCHAR(30),
    day INTEGER(10),
    month INTEGER(10),
    year INTEGER(10),
    product_availability VARCHAR(15),
    value DECIMAL(10,2),
    currency VARCHAR(3),
    category_name VARCHAR(30),
    category_description VARCHAR(250),
    url VARCHAR(100),
    alt_text VARCHAR(70)
    );

