DROP DATABASE IF EXISTS tv;
create database tv;
use tv;
CREATE TABLE tv
(
	brand VARCHAR(30),
    size INT(3),
    price INT(5),
    image blob
);

INSERT INTO tv (brand, size, price) VALUES
('Sony', 23, 3000),
('Samsung', 30, 5000),
('Sansui', 45, 7000),
('Apple', 90, 90000),
('Windows', 75, 75000);

INSERT INTO tv (image) VALUES
(load_file('F:\\BMO.png'));

select * from tv.tv;

SElect * from contacts.contacts;