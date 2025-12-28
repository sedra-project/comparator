INSERT INTO HOTELS (id, name, city) VALUES (1, 'Sunrise Palace', 'Paris');
INSERT INTO HOTELS (id, name, city) VALUES (2, 'Ocean View', 'Nice');

INSERT INTO PRICE_OFFERS (id, provider, price_per_night, currency, hotel_id)
VALUES (10, 'BOOKING', 150.0, 'EUR', 1);

INSERT INTO PRICE_OFFERS (id, provider, price_per_night, currency, hotel_id)
VALUES (11, 'AGODA', 130.0, 'EUR', 1);

INSERT INTO PRICE_OFFERS (id, provider, price_per_night, currency, hotel_id)
VALUES (12, 'EXPEDIA', 200.0, 'EUR', 2);