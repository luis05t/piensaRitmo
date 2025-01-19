-- Tabla: Roles
CREATE TABLE roles (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(50) NOT NULL UNIQUE
);

-- Tabla: Usuarios
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       cedula VARCHAR(10) NOT NULL UNIQUE,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

-- Tabla: Usuarios_Roles
CREATE TABLE users_roles (
                             user_id BIGINT NOT NULL,
                             role_id BIGINT NOT NULL,
                             PRIMARY KEY (user_id, role_id),
                             FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                             FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- Tabla: Dispositivos
CREATE TABLE devices (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         device_id VARCHAR(50) NOT NULL UNIQUE,
                         user_id BIGINT NOT NULL,
                         registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Tabla: Eventos
CREATE TABLE events (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        device_id BIGINT NOT NULL,
                        event_type VARCHAR(50) NOT NULL,
                        heart_rate INT NOT NULL,
                        temperature DECIMAL(4, 2) NOT NULL,
                        recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (device_id) REFERENCES devices(id) ON DELETE CASCADE
);
