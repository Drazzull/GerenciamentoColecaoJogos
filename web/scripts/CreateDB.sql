CREATE DATABASE dbGerenciamentoColecaoJogos;
USE dbGerenciamentoColecaoJogos;

CREATE TABLE Categoria (
    idCategoria INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,
    PRIMARY KEY (idCategoria)
);

CREATE TABLE Marca (
    idMarca INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (idMarca)
);

CREATE TABLE Obtencao (
    idObtencao INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,
    PRIMARY KEY (idObtencao)
);

CREATE TABLE Jogo (
    idJogo INT NOT NULL AUTO_INCREMENT,
    idCategoria INT NOT NULL,
    idMarca INT NOT NULL,
    idObtencao INT NOT NULL,
    Nome VARCHAR(100) NOT NULL,
    precoPago DECIMAL(10, 2),
    estado CHAR(1),
    dataObtencao DATE,
    PRIMARY KEY (idJogo),
    FOREIGN KEY (idCategoria)
     REFERENCES Categoria (idCategoria),
    FOREIGN KEY (idMarca)
     REFERENCES Marca (idMarca),
    FOREIGN KEY (idObtencao)
     REFERENCES Obtencao (idObtencao)
);

CREATE TABLE Emprestimo (
    idEmprestimo INT NOT NULL AUTO_INCREMENT,
    idJogo INT NOT NULL,
    NomePessoa VARCHAR(100) NOT NULL,
    dataEmprestimo DATE NOT NULL,
    PRIMARY KEY (idEmprestimo),
    FOREIGN KEY (idJogo)
     REFERENCES Jogo (idJogo)
);

SELECT * FROM Jogo;