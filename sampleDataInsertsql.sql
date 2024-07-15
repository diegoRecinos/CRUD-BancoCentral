    -- Insert data into tipoTarjeta
INSERT INTO tipoTarjeta (id, nombre)
VALUES 
(1, 'Credito'),
(2, 'Debito');

-- Insert data into FacilitadorTarjeta
INSERT INTO FacilitadorTarjeta (id, nombre)
VALUES 
(1, 'Visa'),
(2, 'MasterCard'),
(3, 'American Express');


-- Insert data into Transaccion
INSERT INTO Transaccion (id, fecha_compra, monto_total, descripcion, id_tarjeta, id_cliente)
VALUES 
(1, '2024-01-15', 100.00, 'Compra en tienda de ropa', 1, 1),
(2, '2024-02-20', 50.50, 'Compra en supermercado', 2, 2),
(3, '2024-03-10', 200.75, 'Compra de electrodom�sticos', 3, 3);



-- Insert data into Cliente
INSERT INTO Cliente (id, nombre, direccion, telefono)
VALUES 
(1, 'Juan Sandoval', 'Av. amazonas 742', '555-1234'),
(2, 'Maria Rivera', 'Calle rosa 123', '555-5678'),
(3, 'Paola Villamariona', 'Calle sol 456', '555-8765');



-- Insert data into Tarjeta
INSERT INTO Tarjeta (id, numero_tarjeta, id_tipo_tarjeta, fecha_expiracion, id_facilitador_tarjeta, id_cliente)
VALUES 
(1, '1234567812345678', 1, '2025-12-31', 1, 1),
(2, '2345678923456789', 2, '2026-11-30', 2, 2),
(3, '3456789034567890', 2, '2027-10-29', 3, 3);

INSERT INTO Cliente (id, nombre, direccion, telefono)
VALUES
(4, 'Carlos Perez', 'Calle luna 789', '555-2345'),
(5, 'Laura Mendoza', 'Av. mariscal 456', '555-6789'),
(6, 'Pedro Gomez', 'Calle estrella 101', '555-7890'),
(7, 'Ana Ortiz', 'Av. principal 202', '555-3456'),
(8, 'Lucia Fernández', 'Calle flor 303', '555-4567'),
(9, 'Ricardo Castillo', 'Av. colón 404', '555-5670');


INSERT INTO Tarjeta (id, numero_tarjeta, id_tipo_tarjeta, fecha_expiracion, id_facilitador_tarjeta, id_cliente)
VALUES
(4, '4567890145678901', 1, '2025-09-30', 1, 4),
(5, '5678901256789012', 2, '2026-08-31', 2, 5),
(6, '6789012367890123', 2, '2027-07-30', 3, 6),
(7, '7890123478901234', 2, '2025-06-30', 1, 7),
(8, '8901234589012345', 1, '2026-05-31', 2, 8),
(9, '9012345690123456', 2, '2027-04-30', 3, 9);

INSERT INTO Transaccion (id, fecha_compra, monto_total, descripcion, id_tarjeta, id_cliente)
VALUES
(4, '2024-04-18', 150.00, 'Compra en librería', 4, 4),
(5, '2024-05-22', 300.00, 'Compra de muebles', 5, 5),
(6, '2024-06-30', 75.25, 'Compra en farmacia', 6, 6),
(7, '2024-07-05', 60.00, 'Compra en cafetería', 1, 1),
(8, '2024-08-10', 90.50, 'Compra en tienda de electrónica', 2, 2),
(9, '2024-09-12', 220.40, 'Compra de herramientas', 3, 3);


