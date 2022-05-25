drop table if exists cars_shops;
drop table if exists owners;
drop table if exists cars;
drop table if exists shops;

create table if not exists   cars
(
    id              serial,
    brand           varchar not null,
    year_of_produce integer not null,
    net_worth       integer not null
);
alter table cars
    owner to postgres;

create unique index cars_id_uindex
    on cars (id);

create table if not exists shops
(
    id        serial
        constraint shops_pk
            primary key,
    shop_name varchar                                                not null,
    address   varchar default 0                                      not null,
    phone     varchar default 0                                      not null,
    email     varchar default 0                                      not null
);

alter table shops
    owner to postgres;

create unique index if not exists shops_shop_id_uindex
    on shops (id);

create unique index if not exists shops_shop_uindex
    on shops (shop_name);

create table if not exists  owners
(
    id         serial,
    first_name varchar not null,
    last_name  varchar not null,
    car_id     integer
        constraint owners_cars_id_fk
            references cars (id)
);

alter table owners
    owner to postgres;


create table if not exists  cars_shops
(
    car_id  integer not null
        constraint car_shops_cars_id_fk
            references cars (id),
    shop_id integer not null
        constraint car_shops_shops_shop_id_fk
            references shops
);

alter table cars_shops
    owner to postgres;

create unique index car_shops_car_id_shop_id_uindex
    on cars_shops (car_id, shop_id);
