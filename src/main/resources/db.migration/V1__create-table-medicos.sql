CREATE TABLE Medicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    documento VARCHAR(8) NOT NULL UNIQUE,
    especialidad VARCHAR(100) NOT NULL,
    calle VARCHAR(255) NOT NULL,
    districto VARCHAR(255) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    numero VARCHAR(100),
    complemento VARCHAR(100),
);
