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
(3, '3456789034567890', 3, '2027-10-29', 3, 3);

-- Insert data into Transaccion
INSERT INTO Transaccion (id, fecha_compra, monto_total, descripcion, id_tarjeta, id_cliente)
VALUES 
(1, '2024-01-15', 100.00, 'Compra en tienda de ropa', 1, 1),
(2, '2024-02-20', 50.50, 'Compra en supermercado', 2, 2),
(3, '2024-03-10', 200.75, 'Compra de electrodomésticos', 3, 3);
