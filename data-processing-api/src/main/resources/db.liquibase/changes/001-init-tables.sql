--liquibase formatted sql
--changeset jdhatton:001-init-tables


create table fap.note
(
    id                   bigint identity primary key,
    company              varchar(128) not null,
    created_by           varchar(128) not null,
    created_by_full_name varchar(255) not null,
    create_date          datetime2    not null,
    modified_date        datetime2,
    value                varchar(255) not null,
);
