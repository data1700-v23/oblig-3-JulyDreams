CREATE TABLE Biletter
(
    id INTEGER AUTO_INCREMENT NOT NULL,
    velgfilm VARCHAR(100) NOT NULL,
    antall INTEGER NOT NULL,
    fornavn VARCHAR(50) NOT NULL,
    etternavn VARCHAR(50) NOT NULL,
    telefonnr CHAR(8) NOT NULL,
    epost VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);