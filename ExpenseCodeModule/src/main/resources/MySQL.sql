USE mysql;
CREATE TABLE expense_details(
    -> expense_code INT AUTO_INCREMENT PRIMARY KEY,
    -> expense_type VARCHAR(15) NOT NULL,
    -> expense_description VARCHAR(100) NOT NULL
    -> );
    
 SHOW TABLES;
 DESCRIBE expense_details;
 
 +---------------------+--------------+------+-----+---------+----------------+
| Field               | Type         | Null | Key | Default | Extra          |
+---------------------+--------------+------+-----+---------+----------------+
| expense_code        | int(11)      | NO   | PRI | NULL    | auto_increment |
| expense_type        | varchar(15)  | NO   |     | NULL    |                |
| expense_description | varchar(100) | NO   |     | NULL    |                |
+---------------------+--------------+------+-----+---------+----------------+

INSERT INTO expense_details(expense_type,expense_description) VALUES('Travel','Onsite Trip');
INSERT INTO expense_details(expense_type,expense_description) VALUES('Lodging','Onsite Trip');
INSERT INTO expense_details(expense_type,expense_description) VALUES('Food','Onsite Trip');
INSERT INTO expense_details(expense_type,expense_description) VALUES('Phone','Onsite Trip');
INSERT INTO expense_details(expense_type,expense_description) VALUES('Medical','Medical Insurance');
INSERT INTO expense_details(expense_type,expense_description) VALUES('Stationeries','Meeting');
INSERT INTO expense_details(expense_type,expense_description) VALUES('Training','Certification');
INSERT INTO expense_details(expense_type,expense_description) VALUES('Legal','Legal Fees');
INSERT INTO expense_details(expense_type,expense_description) VALUES('Equipment','Equipment Rentals');
INSERT INTO expense_details(expense_type,expense_description) VALUES('Software','Software Purchases');
