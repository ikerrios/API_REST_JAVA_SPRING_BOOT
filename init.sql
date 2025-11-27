CREATE TABLE IF NOT EXISTS pet (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    born DATE,
    category VARCHAR(100),
    chip VARCHAR(100),
    adopt BOOLEAN DEFAULT false
);

INSERT INTO pet (name, born, category, chip, adopt) VALUES
('Firulais', '2023-03-15', 'Perro', 'CHIP12345', false),
('Luna', '2021-03-20', 'Gato', 'CHIP002', false),
('Max', '2020-05-15', 'Perro', 'CHIP001', false),
('Mishi', '2022-07-20', 'Gato', 'CHIP54321', true)
ON CONFLICT DO NOTHING;