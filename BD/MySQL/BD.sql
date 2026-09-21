
DROP USER IF EXISTS 'appuser'@'%';
CREATE USER 'appuser'@'%' IDENTIFIED BY 'app123';
GRANT ALL PRIVILEGES ON login.* TO 'appuser'@'%';
FLUSH PRIVILEGES;

-- Elimina la BD si existe
DROP DATABASE IF EXISTS login;

-- Crea la BD de nuevo
CREATE DATABASE login;
USE login;

-- Tabla de usuarios con roles incluidos
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE, -- nombre de usuario para login
    nombre VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL, -- en producción usar hash
    celular VARCHAR(20),
    rol VARCHAR(20) NOT NULL
);

-- Insertar usuarios de prueba
-- Insertar usuarios de prueba
INSERT INTO usuarios (usuario, nombre, password, celular, rol) VALUES
('admin', 'Juan Perez', 'admin123', '+56911111111', 'Administrador'),
('tecnico1', 'Maria Lopez', 'tec456', '+56922222222', 'Tecnico'),
('cliente1', 'Carlos Diaz', 'cli789', '+56933333333', 'Cliente'),
('admin2', 'Pedro Gonzalez', 'admin234', '+56944444444', 'Administrador'),
('admin3', 'Ana Torres', 'admin345', '+56955555555', 'Administrador'),
('admin4', 'Luis Ramirez', 'admin456', '+56966666666', 'Administrador'),
('admin5', 'Sofia Herrera', 'admin567', '+56977777777', 'Administrador'),
('tecnico2', 'Jorge Silva', 'tec567', '+56988888888', 'Tecnico'),
('tecnico3', 'Carolina Soto', 'tec678', '+56999999999', 'Tecnico'),
('tecnico4', 'Ricardo Vega', 'tec789', '+56910101010', 'Tecnico'),
('tecnico5', 'Valentina Rojas', 'tec890', '+56911112222', 'Tecnico'),
('cliente2', 'Felipe Navarro', 'cli890', '+56912223333', 'Cliente'),
('cliente3', 'Camila Fuentes', 'cli901', '+56913334444', 'Cliente'),
('cliente4', 'Diego Morales', 'cli012', '+56914445555', 'Cliente'),
('cliente5', 'Isabel Castro', 'cli123', '+56915556666', 'Cliente'),
('cliente6', 'Matias Paredes', 'cli234', '+56916667777', 'Cliente'),
('cliente7', 'Fernanda Reyes', 'cli345', '+56917778888', 'Cliente'),
('cliente8', 'Cristian Bravo', 'cli456', '+56918889999', 'Cliente'),
('cliente9', 'Daniela Campos', 'cli567', '+56919990000', 'Cliente'),
('cliente10', 'Andres Flores', 'cli678', '+56920001111', 'Cliente'),
('cliente11', 'Paula Carrasco', 'cli789', '+56921112222', 'Cliente');

