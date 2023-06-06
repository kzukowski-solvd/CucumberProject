

USE cucumber;

CREATE TABLE User (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(50),
                      password VARCHAR(50)
);

CREATE TABLE User_Orders (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             user_id INT,
                             product_name VARCHAR(100),
                             price DECIMAL(10, 2),
                             FOREIGN KEY (user_id) REFERENCES User(id)
);


INSERT INTO User (name, password) VALUES ('standard_user', 'secret_sauce');
INSERT INTO User (name, password) VALUES ('locked_out_user', 'secret_sauce');

INSERT INTO User_Orders (user_id, product_name, price) VALUES (1, 'Sauce Labs Backpack', 29.99);
INSERT INTO User_Orders (user_id, product_name, price) VALUES (1, 'Sauce Labs Bike Light', 9.99);
INSERT INTO User_Orders (user_id, product_name, price) VALUES (2, 'Sauce Labs Bolt T-Shirt', 15.99);
INSERT INTO User_Orders (user_id, product_name, price) VALUES (2, 'Sauce Labs Fleece Jacket', 49.99);
INSERT INTO User_Orders (user_id, product_name, price) VALUES (2, 'Sauce Labs Onesie', 7.99);
INSERT INTO User_Orders (user_id, product_name, price) VALUES (2, 'Test.allTheThings() T-Shirt (Red)', 15.99);
