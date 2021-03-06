create table person (
    id         serial not null,
    first_name varchar(50)
);

create unique index person_id_uindex
    on person(id);

alter table person
    add constraint user_id_pk
        primary key (id);

