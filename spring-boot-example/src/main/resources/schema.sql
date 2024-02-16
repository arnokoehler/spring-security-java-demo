CREATE TABLE jokes
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    joke   VARCHAR(255),
    category  VARCHAR(255),
    reference VARCHAR(255),
    lang      VARCHAR(2)
);