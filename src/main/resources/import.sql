

-- INSERT INTO clients (name, email, photo, create_at) VALUES ('Emilianux 1', 'e1@e.com', null, '2019-01-01');
-- INSERT INTO clients (name, email, photo, create_at) VALUES ('Emilianux 2', 'e2@e.com', null, '2019-01-01');
-- INSERT INTO clients (name, email, photo, create_at) VALUES ('Emilianux 3', 'e3@e.com', null, '2019-01-01');

INSERT INTO clients (name) VALUES ('Emi');
INSERT INTO clients (name) VALUES ('Mr. John');
INSERT INTO clients (name) VALUES ('Linus');

/* Some users and their roles */

INSERT INTO `users` (username, password, enabled) VALUES ('emi', '$2a$10$1UNkahod4e7.Q5dqhBhIEuRjuuugxLM749wbGYeNTxG8nrJ870j5m', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin', '$2a$10$ieRQM/HT3Mu5t72Risl50O3Lbqj20RBwTmHc4uYzHrikGyBKSesYW', 1);

INSERT INTO `roles` (name) VALUES ('ROLE_USER');
INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');
#
INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);

