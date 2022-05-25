INSERT INTO cars (brand, year_of_produce, net_worth) VALUES ('Maddyson', 1984,2000000);
INSERT INTO cars (brand, year_of_produce, net_worth) VALUES ('Lada', 2006,900000);
INSERT INTO cars (brand, year_of_produce, net_worth) VALUES ('GAZ', 2010,1000000);
INSERT INTO cars (brand, year_of_produce, net_worth) VALUES ('Lada', 1999,700000);
INSERT INTO cars (brand, year_of_produce, net_worth) VALUES ('Lada', 2007,3000000);
INSERT INTO cars (brand, year_of_produce, net_worth) VALUES ('BMW', 2018,7000000);
INSERT INTO cars (brand, year_of_produce, net_worth) VALUES ('Ferrari', 2020,12000000);
INSERT INTO cars (brand, year_of_produce, net_worth) VALUES ('Yo-mobil', 2010,9990000);

INSERT INTO shops (id, shop_name, address, phone, email) VALUES (DEFAULT, 'Kira Auto', 'Moskovsky prospect building 1','8-812-523-21-23','kirochka@kiraauto.com');
INSERT INTO shops (id, shop_name, address, phone, email) VALUES (DEFAULT, 'BNW', 'Moskovsky prospect building 12','8-812-345-23-12','bnw@bnw.com');
INSERT INTO shops (id, shop_name, address, phone, email) VALUES (DEFAULT, 'Е-мобилс', 'Enthusiasts Avenue 12','8-812-526-31-21','e-mobils@cash.com');

INSERT INTO owners (first_name, last_name, car_id) VALUES ('Michail', 'Shishkin', 1);
INSERT INTO owners (first_name, last_name, car_id) VALUES ('Mihael', 'Shumaher', 2);
INSERT INTO owners (first_name, last_name, car_id) VALUES ('Capybar', 'Grigorievich', 4);
INSERT INTO owners (first_name, last_name, car_id) VALUES ('Ali', 'Don-Donovich', 6);
INSERT INTO owners (first_name, last_name, car_id) VALUES ('Emanuil','Kunt', 8);
INSERT INTO owners (first_name, last_name, car_id) VALUES ('Ivan','Ivaniv', 7);

INSERT INTO cars_shops (car_id, shop_id) VALUES (1,1);
INSERT INTO cars_shops (car_id, shop_id) VALUES (1,2);
INSERT INTO cars_shops (car_id, shop_id) VALUES (1,3);
INSERT INTO cars_shops (car_id, shop_id) VALUES (2,1);
INSERT INTO cars_shops (car_id, shop_id) VALUES (2,2);
INSERT INTO cars_shops (car_id, shop_id) VALUES (3,1);
INSERT INTO cars_shops (car_id, shop_id) VALUES (4,1);
INSERT INTO cars_shops (car_id, shop_id) VALUES (4,2);
INSERT INTO cars_shops (car_id, shop_id) VALUES (4,3);
INSERT INTO cars_shops (car_id, shop_id) VALUES (5,1);
INSERT INTO cars_shops (car_id, shop_id) VALUES (5,3);
INSERT INTO cars_shops (car_id, shop_id) VALUES (6,1);
INSERT INTO cars_shops (car_id, shop_id) VALUES (6,2);
INSERT INTO cars_shops (car_id, shop_id) VALUES (6,3);
INSERT INTO cars_shops (car_id, shop_id) VALUES (7,1);
INSERT INTO cars_shops (car_id, shop_id) VALUES (8,1);
INSERT INTO cars_shops (car_id, shop_id) VALUES (8,3);
