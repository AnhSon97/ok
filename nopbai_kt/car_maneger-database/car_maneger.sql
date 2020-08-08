DROP DATABASE IF EXISTS manager_car;
CREATE DATABASE manager_car;
USE manager_car;

DROP TABLE IF EXISTS car;
CREATE TABLE car(
	license_plate VARCHAR(50) UNIQUE,
    repair_date DATE,
    customer_name VARCHAR(50),
    catalogs VARCHAR(50),
    car_market VARCHAR(50),
    PRIMARY KEY(license_plate,repair_date)
);

DROP TABLE IF EXISTS accessory;
CREATE TABLE accessory(
	id INT AUTO_INCREMENT PRIMARY KEY,
    license_plate VARCHAR(50),
    repair_date DATE,
    customer_name VARCHAR(50),
    `name` VARCHAR(50),
    price INT,
    status_damaged VARCHAR(50),
    repair_status VARCHAR(50),
    FOREIGN KEY (license_plate) REFERENCES car(license_plate)
);

