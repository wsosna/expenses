CREATE TABLE IF NOT EXISTS categories (
    id SERIAL NOT NULL,
    name VARCHAR(20),
    color VARCHAR(10),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS expenses (
    id SERIAL NOT NULL,
    name VARCHAR(20),
    description TEXT,
    price NUMERIC,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS expenses_categories (
    id_category INTEGER,
    id_expense INTEGER,
    PRIMARY KEY(id_category, id_expense),
    CONSTRAINT FK_category FOREIGN KEY(id_category) REFERENCES categories(id),
    CONSTRAINT FK_expense FOREIGN KEY(id_expense) REFERENCES expenses(id)
);

INSERT INTO categories (id, name, color) VALUES (1, 'rent', '#243DB6'), (2, 'bills', '#24B652'), (3, 'school', '#4E24B6');