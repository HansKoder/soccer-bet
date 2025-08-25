--liquibase formatted sql

--changeset dev.01:soccer_bet_20250823_1725
ALTER TABLE matches ADD created_date TIMESTAMP;
ALTER TABLE matches ADD modified_date TIMESTAMP;

ALTER TABLE matches ADD created_by VARCHAR(30);
ALTER TABLE matches ADD modified_by VARCHAR(30);