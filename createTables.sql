CREATE TABLE tipoTarjeta (
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);


CREATE TABLE FacilitadorTarjeta (
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);


CREATE TABLE Cliente (
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    telefono VARCHAR(50)
    
);


CREATE TABLE Tarjeta (
    id INT PRIMARY KEY,
    numero_tarjeta VARCHAR(20) NOT NULL,
    id_tipo_tarjeta INT,
    fecha_expiracion DATE NOT NULL,
    id_facilitador_tarjeta INT,
    id_cliente INT,
    FOREIGN KEY (id_tipo_tarjeta) REFERENCES tipoTarjeta(id),
    FOREIGN KEY (id_facilitador_tarjeta) REFERENCES FacilitadorTarjeta(id),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id)
);


CREATE TABLE Transaccion (
    id INT PRIMARY KEY,
    fecha_compra DATE NOT NULL,
    monto_total DECIMAL(10, 2) NOT NULL,
    descripcion VARCHAR(255),
    id_tarjeta INT,
    id_cliente INT,
    FOREIGN KEY (id_tarjeta) REFERENCES Tarjeta(id),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id)
);
