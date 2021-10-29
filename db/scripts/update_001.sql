CREATE TABLE post (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      description TEXT,
                      created TIMESTAMP
);

CREATE TABLE candidate (
                      id SERIAL PRIMARY KEY,
                      name TEXT
);

ALTER TABLE post ALTER COLUMN id RESTART WITH 1;
DELETE FROM post;