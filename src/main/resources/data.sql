
INSERT INTO institution (name, description) VALUES ('Fundacja "Dbam o Zdrowie"', 'Cel i misja: Pomoc dla osób  mających poważne problemy zdrowotne i dodatkowo znajdujących się w trudnej sytuacji życiowej.');
INSERT INTO institution (name, description) VALUES ('Fundacja "Obudź się"', 'Cel i misja: Pomoc w wybudzaniu dzieci ze śpiączki.');
INSERT INTO institution (name, description) VALUES ('Fundacja "Dla dzieci"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin.');
INSERT INTO institution (name, description) VALUES ('Fundacja "Bez domu"', 'Cel i misja: Pomoc dla osób nie posiadających stałego miejsca zamieszkania.');

INSERT INTO donation (city, phone_number, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id)
     VALUES ('Warszawa', '987234345', 'no comments', '2022-06-25', '12:00', 3, 'Piękna', '22-030', (SELECT id FROM institution WHERE name = 'Fundacja "Dbam o Zdrowie"'));
INSERT INTO donation (city, phone_number, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id)
     VALUES ('Poznań', '123234345', 'no comments', '2022-06-30', '17:00', 5, 'Długa', '64-030', (SELECT id FROM institution WHERE name = 'Fundacja "Obudź się"'));
INSERT INTO donation (city, phone_number, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id)
     VALUES ('Kraków', '345456567', 'no comments', '2022-06-29', '18:00', 2, 'Wielka', '03-030', (SELECT id FROM institution WHERE name = 'Fundacja "Dla dzieci"'));
INSERT INTO donation (city, phone_number, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id)
     VALUES ('Gdynia', '567678789', 'no comments', '2022-06-23', '15:00', 1, 'Nowa', '42-030', (SELECT id FROM institution WHERE name = 'Fundacja "Bez domu"'));

INSERT INTO category (name) VALUE ('ubrania, które nadają się do ponownego użycia');
INSERT INTO category (name) VALUE ('ubrania, do wyrzucenia');
INSERT INTO category (name) VALUE ('zabawki');
INSERT INTO category (name) VALUE ('książki');
INSERT INTO category (name) VALUE ('inne');