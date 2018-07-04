DROP DATABASE IF EXISTS ecomercer;
CREATE DATABASE IF NOT EXISTS ecomercer;

USE ecomercer;

CREATE TABLE IF NOT EXISTS usuarios(

email VARCHAR(50),
senha VARCHAR(255) NOT NULL,
tipo_de_usuario INT NOT NULL,
cpf VARCHAR(10),
nome VARCHAR(50) NOT NULL,
telefone varchar(12),
sobrenome VARCHAR(50) NOT NULL,

PRIMARY KEY (cpf)

);

CREATE TABLE IF NOT EXISTS residencia(

id INT(4) AUTO_INCREMENT,
residencia INT(4),
quartos INT,
banheiros INT,
suites INT,
picinas INT,
cosinha INT,
sala INT,
garagens INT,
rua VARCHAR(50) NOT NULL,
numero INT(4) NOT NULL,
bairro VARCHAR(20) NOT NULL,
cidade varchar(50) NOT NULL,
cpf_cadastro VARCHAR(10),
fotos_residencia varchar(255),
disponivel boolean,
valor real(6,2),

PRIMARY KEY (id),
FOREIGN KEY (cpf_cadastro) REFERENCES usuarios(cpf)

);

CREATE TABLE IF NOT EXISTS reserva(

cpf_cliente VARCHAR(10),
id_residencia INT(4),
data_inicio DATE NOT NULL,
data_fim DATE NOT NULL,

PRIMARY KEY (cpf_cliente, id_residencia),
FOREIGN KEY (cpf_cliente) REFERENCES usuarios(cpf),
FOREIGN KEY (id_residencia) REFERENCES residencia(id)

);

select * from usuarios;

DELETE FROM residencia WHERE id >0;

select * from residencia;