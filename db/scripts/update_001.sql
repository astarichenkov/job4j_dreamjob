CREATE TABLE post (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      description TEXT,
                      created TIMESTAMP
);

CREATE TABLE candidate (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      city_id int REFERENCES city(id),
                      created TIMESTAMP
);

CREATE TABLE users (
                        id SERIAL PRIMARY KEY,
                        name TEXT,
                        email VARCHAR(255),
                        password VARCHAR(255)
);

CREATE TABLE city (
                       id SERIAL PRIMARY KEY,
                       name TEXT
);

ALTER TABLE post ALTER COLUMN id RESTART WITH 1;
DELETE FROM post;