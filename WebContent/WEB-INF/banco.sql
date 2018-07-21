DROP DATABASE IF EXISTS sbma;
CREATE DATABASE IF NOT EXISTS sbma;
USE sbma;

CREATE TABLE IF NOT EXISTS grande_area(

codigo INT auto_increment,
descricao VARCHAR(30) NOT NULL,

PRIMARY KEY (codigo)
);

select * from usuarios;

CREATE TABLE IF NOT EXISTS area_conhecimento(

codigo INT not null,
ref int not null,
descricao VARCHAR(30) NOT NULL,
ga int not null,

PRIMARY KEY (codigo),
FOREIGN key (ga) REFERENCES grande_area(codigo)
);

CREATE TABLE IF NOT EXISTS area_especifica(

codigo INT not null,
descricao VARCHAR(30) NOT NULL,
ref int not null,
ac int not null,

PRIMARY KEY (codigo),
FOREIGN key (ac) REFERENCES area_conhecimento(codigo)
);

CREATE TABLE IF NOT EXISTS sub_area(

codigo INT auto_increment,
ref int not null,
descricao VARCHAR(100) NOT NULL,
ae int not null,

PRIMARY KEY (codigo),
FOREIGN key (ae) REFERENCES area_especifica(codigo)
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
sub_area INT ,
resumo text,
caminho varchar(255),

PRIMARY KEY (codigo)

);

CREATE TABLE IF NOT EXISTS usuarios(

senha VARCHAR(255) NOT NULL,
tipo boolean not null,
ativo boolean NOT NULL,
email VARCHAR(50) NOT NULL,

PRIMARY KEY (email)

);

select * from documentos;
INSERT INTO grande_area values (1,'Ciências Exatas e da Terra');
INSERT INTO area_conhecimento (ga,codigo,ref,descricao)values (1,1,8,'Matemática');
INSERT INTO area_especifica (ac,codigo,ref,descricao)values (1,1,4,'Álgebra');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (1,default,2,'Conjuntos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (1,default,0,'Lógica Matemática');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (1,default,9,'Teoria dos Números');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (1,default,7,'Grupos de Algebra Não-Comutaviva');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (1,default,5,'Algebra Comutativa');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (1,default,3,'Geometria Algebrica');
INSERT INTO area_especifica (ac,codigo,ref,descricao)values (1,2,0,'Análise');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (2,default,9,'Análise Complexa');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (2,default,7,'Análise Funcional');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (2,default,5,'Análise Funcional Não-Linear');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (2,default,3,'Equações Diferênciais Ordinárias');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (2,default,1,'Equações Diferênciais Parciais');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (2,default,0,'Equações Diferênciais Funcionais');
INSERT INTO area_especifica (ac,codigo,ref,descricao)values (1,3,7,'Geometria e Topologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (3,default,5,'Geometria Diferêncial');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (3,default,3,'Topologia Algébrica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (3,default,1,'Topologia das Variedades');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (3,default,0,'Sistemas Dinâmicos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (3,default,8,'Teoria das Singularidades e Teoria das Catástrofes');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (3,default,6,'Teoria das Folheações');
INSERT INTO area_especifica (ac,codigo,ref,descricao)values (1,4,3,'Matemática Aplicada');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (4,default,1,'Física Matemática');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (4,default,0,'Análise Numérica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (4,default,8,'Matemática Discreta e Combinatoria');


use sbma;
select ga.codigo as 'gacodigo',ga.descricao as 'gadescricao',ac.codigo  as 'accodigo',
ac.descricao  as 'acdescricao',ae.codigo  as 'aecodigo',ae.descricao as 'aedescricao',sa.codigo as 'sacodigo',sa.descricao as 'sadescricao' from grande_area as ga
inner join area_conhecimento as ac on ga.codigo = ac.ga
inner join area_especifica as ae on ac.codigo = ae.ac
inner join sub_area as sa on sa.ae = ae.codigo where sa.codigo =8;

