INSERT INTO pers_public.user(user_id, active, email, firstname, lastname, login, name, password) VALUES(1, true, 'skellag@gmail.com', 'Oleksii', 'Bobko', 'root', 'root', '$2a$10$lFH0Ocy9AUbeO1RzRZr9OO5X9k7/T.nB4unEWVLFU8X98YpxhiEFm');
INSERT INTO pers_public.user_role(user_role_id, role, user_id) VALUES(1, 'ADMIN', 1);