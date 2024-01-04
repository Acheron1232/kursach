--liquibase formatted sql

--changeset acheron:1
alter table users add column password text;
--changeset acheron:2
alter table users add column role text;