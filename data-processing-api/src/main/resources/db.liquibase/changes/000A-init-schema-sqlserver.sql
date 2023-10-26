--liquibase formatted sql
--changeset jdhatton:000A-init-schema-sqlserver
if (schema_id('jd') is null)
    begin
        exec ('create schema [jd] authorization [master]')
    end