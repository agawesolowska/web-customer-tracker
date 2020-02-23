CREATE DATABASE web_customer_tracker;

CREATE TABLE customer (
customer_id BIGSERIAL PRIMARY KEY,
first_name VARCHAR(45) NOT NULL,
last_name VARCHAR(45) NOT NULL,
email VARCHAR(45) NOT NULL UNIQUE
);