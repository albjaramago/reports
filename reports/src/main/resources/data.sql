DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customers;
 
 CREATE TABLE customers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL  
);

 CREATE TABLE accounts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  balance INT NOT NULL,
  iban VARCHAR(250) NOT NULL,
  customer INT,
  FOREIGN KEY(customer) REFERENCES customers
);

 
INSERT INTO customers (first_name, last_name) VALUES
  ('Niamh ', 'Murphy'),
  ('Ciara', 'Kelly'),
  ('Roisin ', 'Byrne'),
  ('Clodagh', 'Ryan'),
  ('Shannon', 'Sullivan'),
  ('Sinead ', 'Walsh'),
  ('Grainne', 'McCarthy'),
  ('Emer', 'OConnor'),
  ('Siobhan', 'ONeill'),
  ('Fiona', 'OBrian');
  
  
 INSERT INTO accounts (balance, iban, customer) VALUES
  ('4900', 'IE29 AIBK 9311 5212 3456 78', '1'),
  ('1300', 'IE29 AIBK 9311 5212 3456 79', '2'),
  ('3000', 'IE29 AIBK 9311 5212 3456 80', '3'),
  ('4677', 'IE29 AIBK 9311 5212 3456 81', '4'),
  ('9800', 'IE29 AIBK 9311 5212 3456 82', '5'),
  ('9500', 'IE29 AIBK 9311 5212 3456 83', '6'),
  ('1100', 'IE29 AIBK 9311 5212 3456 84', '7'),
  ('6000', 'IE29 AIBK 9311 5212 3456 85', '8'),
  ('4507', 'IE29 AIBK 9311 5212 3456 86', '9'),
  ('9610', 'IE29 AIBK 9311 5212 3456 87', '10');