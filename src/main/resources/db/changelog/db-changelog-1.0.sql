--liquibase formatted sql

--changeset acheron:1

CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(100) NOT NULL,
                       email VARCHAR(255) NOT NULL

);

--changeset acheron:2

CREATE TABLE orders (
                        order_id SERIAL PRIMARY KEY,
                        user_id INT REFERENCES users(user_id),
                        delivery_address VARCHAR(255) NOT NULL,
                        payment_method VARCHAR(50) NOT NULL

);
--changeset acheron:3
-- Таблиця для комп'ютерів
CREATE TABLE computers (
                           computer_id SERIAL PRIMARY KEY,
                           type VARCHAR(50) NOT NULL,
                           configuration VARCHAR(255) NOT NULL,
                           price DECIMAL(10, 2) NOT NULL
);
--changeset acheron:4

CREATE TABLE computer_components (
                                     component_id SERIAL PRIMARY KEY,
                                     component_name VARCHAR(100) NOT NULL,
                                     computer_id INT REFERENCES computers(computer_id),
                                     CONSTRAINT fk_computer FOREIGN KEY (computer_id) REFERENCES computers(computer_id) ON DELETE CASCADE
);
--changeset acheron:5
CREATE TABLE order_details (
                               order_detail_id SERIAL PRIMARY KEY,
                               order_id INT REFERENCES orders(order_id),
                               computer_id INT REFERENCES computers(computer_id),
                               CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
                               CONSTRAINT fk_computer_order FOREIGN KEY (computer_id) REFERENCES computers(computer_id) ON DELETE CASCADE
);
--changeset acheron:6
CREATE TABLE computer_configuration_components (
                                                   configuration_component_id SERIAL PRIMARY KEY,
                                                   computer_id INT REFERENCES computers(computer_id),
                                                   component_name VARCHAR(100) NOT NULL,
                                                   CONSTRAINT fk_configuration_computer FOREIGN KEY (computer_id) REFERENCES computers(computer_id) ON DELETE CASCADE
);