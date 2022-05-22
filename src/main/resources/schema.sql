-- drop table IF EXISTS cars_shops;
-- drop table IF EXISTS  owners;
-- drop table IF EXISTS  cars;
-- drop table IF EXISTS  shops;
--
-- create table IF NOT EXISTS cars
-- (
--     id              serial,
--     brand           varchar not null,
--     year_of_produce integer not null,
--     net_worth       integer not null
-- );
--
-- create unique index cars_id_uindex
--     on cars (id);
--
-- create table if not exists shops
-- (
--     id        serial
--         constraint shops_pk
--             primary key,
--     shop_name varchar                                                not null,
--     address   varchar default 0                                      not null,
--     phone     varchar default 0                                      not null,
--     email     varchar default 0                                      not null
-- );
--
-- create unique index if not exists shops_shop_id_uindex
--     on shops (id);
--
-- create unique index if not exists shops_shop_uindex
--     on shops (shop_name);
--
-- create table IF NOT EXISTS  owners
-- (
--     id         serial,
--     first_name varchar not null,
--     last_name  varchar not null,
--     car_id     integer
--         constraint owners_cars_id_fk
--             references cars (id)
-- );
--
-- create table IF NOT EXISTS  cars_shops
-- (
--     car_id  integer not null
--         constraint car_shops_cars_id_fk
--             references cars (id),
--     shop_id integer not null
--         constraint car_shops_shops_shop_id_fk
--             references shops
-- );
--
-- create unique index car_shops_car_id_shop_id_uindex
--     on cars_shops (car_id, shop_id);

drop table IF EXISTS cars_shops;
drop table IF EXISTS  owners;
drop table IF EXISTS  cars;
drop table IF EXISTS  shops;

create table IF NOT EXISTS cars
(
    id              INT auto_increment NOT NULL primary key,
    brand           varchar not null,
    year_of_produce integer not null,
    net_worth       integer not null
);

create table if not exists shops
(
    id        INT auto_increment NOT NULL primary key,
    shop_name varchar                                                not null,
    address   varchar default 0                                      not null,
    phone     varchar default 0                                      not null,
    email     varchar default 0                                      not null
);

create table IF NOT EXISTS  owners
(
    id         INT auto_increment NOT NULL primary key ,
    first_name varchar not null,
    last_name  varchar not null,
    car_id     integer
);

create table IF NOT EXISTS  cars_shops
(
    car_id  integer not null,
    shop_id integer not null
);