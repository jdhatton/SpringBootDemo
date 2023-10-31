--liquibase formatted sql
--changeset jdhatton:002-init-note-data

INSERT INTO JDDEMO.jd.note
( company, created_by, created_by_full_name, create_date, value)
VALUES('Testing LLC', 'jdhatton', 'JD Hatton', '2023-10-31 17:34:06.000',  '1 - Just showcasing some code stuff');

INSERT INTO JDDEMO.jd.note
( company, created_by, created_by_full_name, create_date, value)
VALUES('Testing LLC', 'jdhatton', 'JD Hatton', '2023-10-31 17:34:06.000',  '2 - Just showcasing some code stuff');

