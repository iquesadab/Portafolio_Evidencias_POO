-- Creacion de la base de datos
CREATE DATABASE bd_restaurante;

-- Activacion de una cierta base de datos
USE bd_restaurante;

-- Creacion de las tablas

CREATE TABLE t_clientes(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellidos VARCHAR(100)
);

CREATE TABLE t_mesas(
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero TINYINT,
    capacidad TINYINT,
    disponible BOOLEAN
);

CREATE TABLE t_meseros(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellidos VARCHAR(100),
    experiencia TINYINT
);

CREATE TABLE t_platos(
   id INT PRIMARY KEY AUTO_INCREMENT,
   nombre VARCHAR(100),
   categoria VARCHAR(50),
   precio FLOAT
);

CREATE TABLE t_pedidos(
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(20),
    cantidad_platos TINYINT,
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES t_clientes(id)
);

CREATE TABLE t_facturas(
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero VARCHAR(20),
    metodo_pago VARCHAR(50),
    total FLOAT,
    pagada BOOLEAN,
    id_pedido INT NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES t_pedidos(id)
);

CREATE TABLE t_restaurantes(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100)
);