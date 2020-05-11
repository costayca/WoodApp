DROP TABLE IF EXISTS door;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS person;

CREATE TABLE person (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR (100) NOT NULL
);

CREATE TABLE orders (
    id UUID NOT NULL PRIMARY KEY,
    customerId UUID NOT NULL REFERENCES person(id),
    duration SMALLINT NOT NULL,
    products UUID [] NOT NULL
);

CREATE TABLE IF NOT EXISTS door (
    id UUID NOT NULL PRIMARY KEY,
    color VARCHAR (100) NOT NULL,
    material VARCHAR (100) NOT NULL,
    type VARCHAR (100) NOT NULL,
    width SMALLINT NOT NULL,
    height SMALLINT NOT NULL,
    price SMALLINT NOT NULL
);

INSERT INTO person (id, name) VALUES ('3c7f3740-3fc4-42f5-bc6a-26208fb38cfb', 'Maria Jones');
INSERT INTO door(id, color, material, type, width, height, price) VALUES ('33b22617-ed3b-4027-87ea-68ad80749ac3', 'white', 'Oak', 'French', 150, 210, 1000);
INSERT INTO door(id, color, material, type, width, height, price) VALUES ('8c8c4836-c7d8-4f19-a68b-23a2cbf51180', 'black', 'Evergreen', 'Panel', 150, 210, 1000);
INSERT INTO orders (id, customerid, duration, products) VALUES(uuid_generate_v4(), '3c7f3740-3fc4-42f5-bc6a-26208fb38cfb', 20,'{"33b22617-ed3b-4027-87ea-68ad80749ac3","8c8c4836-c7d8-4f19-a68b-23a2cbf51180"}');
