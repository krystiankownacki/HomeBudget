create schema public;
CREATE EXTENSION IF NOT EXISTS citext WITH SCHEMA public;

CREATE TABLE registers
(
    id            NUMERIC(19,0) PRIMARY KEY NOT NULL,
    balance       INTEGER,
    register_name VARCHAR,
    created_at    TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP WITH TIME ZONE
);

CREATE INDEX idx_registers_id ON registers (id);

CREATE OR REPLACE FUNCTION update_changed_at_timestamp()
    RETURNS TRIGGER AS
$$
BEGIN
    NEW.updated_at = now();
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER update_at_change_timestamp
    BEFORE UPDATE
    ON registers
    FOR EACH ROW
EXECUTE PROCEDURE
    update_changed_at_timestamp();