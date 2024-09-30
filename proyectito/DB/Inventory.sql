CREATE TABLE categorias (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(1000) NOT NULL,
    descripcion VARCHAR(1000)
);

CREATE TABLE proveedores (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    telefono VARCHAR(15),
    email VARCHAR(255),
    direccion TEXT
);

CREATE TABLE productos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    cantidad_en_stock INT NOT NULL,
    categoria_id INT,
    proveedor_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id) ON DELETE SET NULL,
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(id) ON DELETE SET NULL
);

CREATE TABLE movimientos_inventario (
    id SERIAL PRIMARY KEY,
    producto_id INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    cantidad INT NOT NULL,
    tipo_movimiento VARCHAR(10) CHECK (tipo_movimiento IN ('entrada', 'salida')),
    FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE
);

INSERT INTO categorias (nombre, descripcion) VALUES
('Electrónica', 'https://www.lucushost.com/blog/wp-content/uploads/2019/06/a%C3%B1adir-categor%C3%ADas-en-WordPress.png'),
('Ropa', 'Prendas de vestir y accesorios'),
('Alimentos', 'Productos alimenticios, comestibles y bebidas');

INSERT INTO proveedores (nombre, telefono, email, direccion) VALUES
('Proveedor 1', '555-1234', 'contacto@proveedor1.com', '123 Calle Principal, Ciudad'),
('Proveedor 2', '555-5678', 'info@proveedor2.com', '456 Avenida Secundaria, Ciudad'),
('Proveedor 3', '555-9876', 'ventas@proveedor3.com', '789 Calle Tercera, Ciudad');

INSERT INTO productos (nombre, descripcion, precio, cantidad_en_stock, categoria_id, proveedor_id) VALUES
('Teléfono inteligente', 'Teléfono con pantalla táctil y cámara de 12MP', 299.99, 50, 1, 1),
('Camiseta', 'https://desierto.co/wp-content/uploads/2022/09/Camiseta-Blanca-1.jpg', 19.99, 200, 2, 2),
('Paquete de pasta', 'https://cdn1.totalcommerce.cloud/mercacentro/product-zoom/es/pasta-mercacentro-spaghetti-250-g-1.webp', 1.50, 150, 3, 3);

INSERT INTO movimientos_inventario (producto_id, cantidad, tipo_movimiento) VALUES
(1, 30, 'entrada'),
(1, 10, 'salida'),
(2, 100, 'entrada'),
(3, 50, 'entrada'),
(3, 20, 'salida');

select * from categorias c ;
select * from proveedores p ;
select * from productos p ;
select * from movimientos_inventario mi ;

UPDATE productos 
SET descripcion = 'https://cdn1.totalcommerce.cloud/mercacentro/product-zoom/es/pasta-mercacentro-spaghetti-250-g-1.webp'
WHERE nombre = 'Paquete de pasta';

ALTER TABLE categorias
ALTER COLUMN descripcion TYPE VARCHAR(1000);
