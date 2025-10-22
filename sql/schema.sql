-- Schema for HM Agro Inventory
CREATE TABLE categories (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL UNIQUE,
  description TEXT
);

CREATE TABLE materials (
  id SERIAL PRIMARY KEY,
  name VARCHAR(300) NOT NULL,
  sku VARCHAR(150),
  unit VARCHAR(50),
  quantity NUMERIC(18,4) DEFAULT 0,
  min_quantity NUMERIC(18,4),
  location VARCHAR(200),
  notes TEXT,
  category_id INT REFERENCES categories(id) ON DELETE SET NULL
);
