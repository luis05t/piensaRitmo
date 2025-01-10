CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       cedula VARCHAR(10) NOT NULL UNIQUE,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE health_data (
                             id BIGSERIAL PRIMARY KEY,
                             user_id BIGINT NOT NULL,
                             heart_rate INT NOT NULL,
                             temperature DECIMAL(4,2) NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
