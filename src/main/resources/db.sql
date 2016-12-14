CREATE TABLE User (
	id INTEGER IDENTITY PRIMARY KEY,
	email VARCHAR(50) UNIQUE NOT NULL,
	password_hash VARCHAR(255) NOT NULL,
	role VARCHAR(10) NOT NULL
);

INSERT INTO User(email, password_hash, role) VALUES('tomarto11@gmail.com', '$2a$10$MRYcUdxwyH7RB1xGmoGIge.oJcf.8YoEmUDN3L/Emf5eg0Vy6Q7ym', 'ADMIN');
