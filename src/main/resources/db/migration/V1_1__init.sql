create sequence hibernate_sequence start 1 increment 1;

-- create table delivery (
--     id int4 not null,
--     deliverytype varchar(255)
--                       );
--
-- create table parnter (
--     id int4 not null,
--     parnter varchar(255)
--                      );

create table documents (
    id int4 not null,
    primary key (id),
    reg_number varchar(255) not null,
    reg_date date not null,
    num_of_doc varchar(255),
    datedoc date,
    deliverytype varchar(255),
    partner varchar(255),
    theme varchar(100) not null ,
    description varchar(1000),
    time_execution date,
    access boolean,
    control boolean,
    file bytea,
    filename varchar(1000),
    file_type varchar(100)
                    );

-- alter table if exists delivery
--     add constraint store_delivery_fk
--         foreign key (id) references documents;
--
-- alter table if exists parnter
--     add constraint store_parnter_fk
--         foreign key (id) references documents;