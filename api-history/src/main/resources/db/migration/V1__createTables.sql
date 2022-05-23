create table clients (
                       id bigserial primary key,
                       name varchar(200) not null,
                       email varchar(200) not null
);

create table orders (
                       id bigserial primary key,
                       order_number varchar(100) not null,
                       store_name varchar(200) not null
)