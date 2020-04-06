CREATE TABLE orders (
    id UUID NOT NULL PRIMARY KEY,
    customerId UUID NOT NULL REFERENCES person(id),
    duration SMALLINT NOT NULL
);