DROP DATABASE IF EXISTS sbma;
CREATE DATABASE IF NOT EXISTS sbma;
USE sbma;

CREATE TABLE IF NOT EXISTS grande_area(

codigo INT auto_increment,
descricao VARCHAR(30) NOT NULL,

PRIMARY KEY (codigo)
);


CREATE TABLE IF NOT EXISTS area_conhecimento(

codigo INT auto_increment,
descricao VARCHAR(30) NOT NULL,
grande_area int not null,

PRIMARY KEY (codigo),
FOREIGN key (grande_area) REFERENCES grande_area(codigo)
);

CREATE TABLE IF NOT EXISTS area_especifica(

codigo INT auto_increment,
descricao VARCHAR(30) NOT NULL,
area_conhecimento int not null,

PRIMARY KEY (codigo),
FOREIGN key (area_conhecimento) REFERENCES area_conhecimento(codigo)
);

CREATE TABLE IF NOT EXISTS sub_area(

codigo INT auto_increment,
descricao VARCHAR(30) NOT NULL,
area_especifica int not null,

PRIMARY KEY (codigo),
FOREIGN key (area_especifica) REFERENCES area_especifica(codigo)
);


CREATE TABLE IF NOT EXISTS documentos(

codigo INT auto_increment,
autores varchar(500) not null,
data_cadastro DATE NOT NULL,
data_defesa DATE not null,
orientador varchar(255) not null,
co_orientador varchar(255) not null,
titulo VARCHAR(255) NOT NULL,
sub_titulo varchar(255),
tipo int not null,
palavras_chaves varchar(100) not null,
sub_area INT NOT NULL,
resumo text,
caminho varchar(255),

PRIMARY KEY (codigo),
FOREIGN KEY (sub_area) REFERENCES sub_area(codigo)

);

CREATE TABLE IF NOT EXISTS usuarios(

senha VARCHAR(255) NOT NULL,
tipo VARCHAR(10),
ativo boolean NOT NULL,
email VARCHAR(50) NOT NULL,

PRIMARY KEY (email)

);

insert into grande_area value(default,"teste");
insert into area_conhecimento value(default,"teste",1);
insert into area_especifica value(default,"teste",1);
insert into sub_area value(default,"teste",1);



INSERT INTO documentos values (default,"Marcelo Rodrigo; Bruno Alves",NOW(),NOW(),"Agar corsini","willian","Logica nas escola publicas"
,"",1,"sistema;Academico;Web",1,"O crescente avanço tecnológico na infraestrutura da comunicação web proporcionou a criação de sistemas on-line interativos, possibilitando uma melhor usabilidade encinar logica nas escolas publicas uso da internet e a integração de sistemas para auxiliar  em pesquisas, comunicação e interações. No que diz respeito à aprendizagem tanto presencial quanto a distância utilizando-se de mecanismos de pesquisas nas mais diversas áreas, fez com que grande parte das Universidades disponibilizassem materiais acadêmicos como: teses, artigos, dissertações, monografias e trabalhos produzidos internamente, através de sistemas online de forma  gratuita, assim como o banco de teses e dissertações da CAPES que hospeda milhares de documentos. Nesse contexto, o presente  visa a construção de um sistema web, para hospedagem e  busca de material acadêmico, produzido por docentes e discentes do Instituto Federal de Educação Ciência e Tecnologia do sul de Minas Gerais campus Machado. Para atingir esse objetivo será utilizado a linguagem de programação Java, e banco de dados MariaDB, juntamente com HTML5, Css e Javascript. Com o estudo pretende-se criar uma ferramenta que proporcione uma boa usabilidade e uma navegação rápida, de forma fácil e segura.","nome na pasta");


select * from documentos where data_defesa <='2018-06-19';		


/* busca por autores*/
select * from documentos where autores LIKE '%mathe%';

/* orientador    */
select * from documentos where orientador LIKE '%corsini%';

/*co orientador*/
select * from documentos where co_orientador LIKE '%mathe%';

/*titulo*/
select * from documentos where titulo LIKE '%mathe%';

/*sub titulo*/
select * from documentos where sub_titulo LIKE '%mathe%' OR resumo like 'kkk';

/*resumo*/
select * from documentos where resumo LIKE '%logica%' LIMIT 0,5;


UPDATE documentos SET autores = 'teste' , titulo = 'teste' , sub_titulo = 'teste' ,
orientador = 'teste' , co_orientador = 'teste' , tipo = 2 , palavras_chaves = 'teste' ,
data_defesa = '2015-01-01' , sub_area = 1 , resumo = 'teste' , caminho = 'teste' where codigo = 3 ;





SELECT * FROM documentos where autores LIKE '%mar%' limit 45,15;



DELETE from documentos where codigo = 3;

SELECT COUNT(*) FROM documentos  where autores LIKE '%mar%';







