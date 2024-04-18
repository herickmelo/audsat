INSERT INTO driver (id, document, birth_date) VALUES (1, '999.999.999-99', '2000-01-02')
INSERT INTO driver (id, document, birth_date) VALUES (2, '000.000.000-00', '2001-01-02')

INSERT INTO customer (id, name, driver_id) VALUES (1, 'Herick Melo', 1)
INSERT INTO customer (id, name, driver_id) VALUES (2, 'Joao da Silva', 2)

INSERT INTO car (id, model, manufacturer, _year, fipe_value) VALUES (1, 'Uno', 'Fiat', 1996, 8855)
INSERT INTO car (id, model, manufacturer, _year, fipe_value) VALUES (2, 'Celta', 'Chevrolet', 2005, 15329)

INSERT INTO claim (id, car_id, driver_id, event_date) VALUES (1, 1, 1, '2024-01-01')
INSERT INTO claim (id, car_id, driver_id, event_date) VALUES (2, 1, 1, '2024-01-02')

--INSERT INTO insurance (id, customer_id, created_date, updated_date, car_id, is_active) VALUES (1, 1, '2024-02-02 00:00:00', '2024-02-02 00:00:00', 1, true)
--INSERT INTO insurance (id, customer_id, created_date, updated_date, car_id, is_active) VALUES (2, 2, '2024-02-02 00:00:00', '2024-02-02 00:00:00', 2, true)