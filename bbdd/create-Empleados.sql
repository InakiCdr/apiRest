CREATE TABLE empleados (
    id NUMBER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL
);

INSERT INTO empleados (nombre, apellido, departamento_id) VALUES
('Juan', 'Pérez', 1),
('María', 'González', 1),
('Carlos', 'López', 2),
('Laura', 'Fernández', 2),
('David', 'García', 1),
('Ana', 'Martínez', 2),
('José', 'Rodríguez', 1),
('Carmen', 'Sánchez', 2),
('Luis', 'Díaz', 1),
('Elena', 'Morales', 2);