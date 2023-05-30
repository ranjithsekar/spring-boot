-- OPTIONAL
CREATE USER ranjith;
ALTER USER ranjith WITH encrypted password 'sekar';
DROP DATABASE springboot;
CREATE DATABASE springboot WITH owner = ranjith encoding = 'UTF8';
GRANT ALL PRIVILEGES ON DATABASE springboot to ranjith;

-- Create schema
CREATE SCHEMA sboot_jpa_table_joins AUTHORIZATION ranjith;