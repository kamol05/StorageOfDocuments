create sequence hibernate_sequence start 1 increment 1;

create table delivery (
    id int4 not null,
    deliverytype varchar(255)
                      );

create table parnter (
    id int4 not null,
    parnter varchar(255)
                     );

create table store (
    id int4 not null,
    primary key (id),
    reg_number int4 not null,
    reg_date timestamp not null,
    num_of_doc int4,
    datedoc timestamp,
    theme varchar(100) not null ,
    description varchar(1000),
    time_execution timestamp,
    access boolean,
    control boolean,
    file bytea
                    );

alter table if exists delivery
    add constraint store_delivery_fk
        foreign key (id) references store;

alter table if exists parnter
    add constraint store_parnter_fk
        foreign key (id) references store;