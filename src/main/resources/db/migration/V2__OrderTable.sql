CREATE TABLE orders (
    id UUID NOT NULL PRIMARY KEY,
    customerId UUID NOT NULL,
    duration SMALLINT NOT NULL
);