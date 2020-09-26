DROP TABLE IF EXISTS inventory;
 
CREATE TABLE INVENTORY (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price DOUBLE NOT NULL,
  quantity INT(11) DEFAULT NULL
);
 
INSERT INTO INVENTORY (name, price, quantity) VALUES
  ('Pen', 10.00, 2 ),
  ('Mobile', 10000.80, 1),
  ('Headset', 500.89,1);