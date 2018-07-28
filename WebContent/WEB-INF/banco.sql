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

INSERT INTO area_conhecimento (ga,codigo,ref,descricao)values (1,2,2,'Probabilidade e Estatística');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (2,5,9,'Probabilidade');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (5,default,7,'Teoria Geral e Fundamentos da Probabilidade');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (5,default,7,'Teoria Geral e Processos Estocásticos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (5,default,7,'Teoremas de Limite');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (5,default,7,'Processos Markovianos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (5,default,7,'Análise Estocástica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (5,default,7,'Processos Estocásticos Especiais');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (2,6,9,'Estatística');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (6,default,7,'Fundamentos da Estatistica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (6,default,7,'Inferência Paramétrica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (6,default,7,'Inferência Nao-Paramétrica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (6,default,7,'Inferência em Processos Estocásticos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (6,default,7,'Análise Multivariada');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (6,default,7,'Regressão e Correlação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (6,default,7,'Planejamento de Experimentos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (6,default,7,'Análise de Dados');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (2,7,9,'Probabilidade e Estatística Aplicadas');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (7,default,7,'Probabilidade e Estatística Aplicadas');

INSERT INTO area_conhecimento (ga,codigo,ref,descricao)values (1,3,5,'Ciência da Computação');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (3,8,9,'Teoria da Computação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (8,default,7,'Computabilidade e Modelos de Computação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (8,default,7,'Linguagem Formais e Automatos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (8,default,7,'Análise de Algoritmos e Complexidade de Computação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (8,default,7,'Lógicas e Semântica de Programas');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (3,9,9,'Matemática da Computação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (9,default,7,'Matemática Simbólica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (9,default,7,'Modelos Analíticos e de Simulação');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (3,10,9,'Metodologia e Técnicas da Computação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (10,default,7,'Linguagens de Programação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (10,default,7,'Engenharia de Software');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (10,default,7,'Sistemas de Informação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (10,default,7,'Processamento Gráfico (Graphics)');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (10,default,7,'Banco de Dados');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (3,11,9,'Sistemas de Computação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (11,default,7,'Hardware');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (11,default,7,'Arquitetura de Sistemas de Computação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (11,default,7,'Software Básico');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (11,default,7,'Teleinformática');

INSERT INTO area_conhecimento (ga,codigo,ref,descricao)values (1,4,5,'Astronomia');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (4,12,9,'Astronomia de Posição e Mecânica Celeste');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (12,default,7,'Astronomia Fundamental');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (12,default,7,'Astronomia Dinâmica');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (4,13,9,'Astrofísica Estelar');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (13,default,7,'Astrofísica Estelar');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (4,14,9,' Astrofísica do Meio Interestelar');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (14,default,7,'Meio Interestelar');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (14,default,7,'Nebulosa');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (4,15,9,'Astrofísica Extragaláctica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (15,default,7,'Galáxias');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (15,default,7,'Aglomerados de Galáxias');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (15,default,7,'Quasares');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (15,default,7,'Cosmologia');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (4,16,9,'Astrofísica do Sistema Solar');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (16,default,7,'Física Solar');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (16,default,7,'Movimento da Terra');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (16,default,7,'Sistema Planetário');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (4,17,9,'Instrumentação Astronômica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (17,default,7,'Astronômia Ótica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (17,default,7,'Radioastronomia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (17,default,7,'Astronomia Espacial');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (17,default,7,'Processamento de Dados Astronômicos');


INSERT INTO area_conhecimento (ga,codigo,ref,descricao)values (1,5,5,'Física');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (5,18,9,'Física Geral');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (18,default,7,'Métodos Matemáticos da Física');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (18,default,7,'Física Clássica e Física Quântica; Mecânica e Campos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (18,default,7,'Relatividade e Gravitação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (18,default,7,'Física Estatística e Termodinâmica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (18,default,7,'Metrologia, Técnicas Gerais de Laboratório, Sistema de Instrumentação');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (18,default,7,'Instrumentação Específica de Uso Geral em Física');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (5,19,9,'Áreas Clássicas de Fenomenologia e suas Aplicações');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (19,default,7,'Eletricidade e Magnetismo; Campos e Partículas Carregadas');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (19,default,7,'Ótica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (19,default,7,'Acústica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (19,default,7,'Transferência de Calor; Processos Térmicos e Termodinâmicos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (19,default,7,'Mecânica, Elasticidade e Reologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (19,default,7,'Dinâmica dos Fluidos');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (5,20,9,'Física Nuclear');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (20,default,7,'Estrutura Nuclear');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (20,default,7,'Desintegração Nuclear e Radioatividade');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (20,default,7,'Reações Nucleares e Espalhamento Geral  ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (20,default,7,'Reações Nucleares e Espalhamento (Reações Específicas) ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (20,default,7,'Propriedades de Núcleos Específicos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (20,default,7,'Métodos Experimentais e Instrumentação para Partículas Elementares e Física Nuclear  	');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (5,21,9,'Física Atômica e Molécular');		
INSERT INTO sub_area (ae,codigo,ref,descricao)values (21,default,7,'Estrutura Eletrônica de Átomos e Moléculas; Teoria');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (21,default,7,'Espectros Atômicos e Integração de Fótons ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (21,default,7,'Espectros Moléculares e Interações de Fótons com Moléculas');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (21,default,7,'Processos de Colisão e Interações de Átomos e Moléculas');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (21,default,7,'Inf.Sobre Átomos e Moléculas Obtidos Experimentalmente;Instrumentação e Técnicas');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (21,default,7,'Estudos de Átomos e Moléculas Especiais ');


INSERT INTO area_especifica (ac,codigo,ref,descricao)values (5,22,9,'Física dos Fluidos, Física de Plasmas e Descargas Elétricas');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (22,default,7,'Cinética e Teoria de Transporte de Fluidos; Propriedades Físicas de Gases');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (22,default,7,'Física de Plasmas e Descargas Elétricas');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (5,23,9,'Física da Matéria Condensada ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Estrutura de Líquidos e Sólidos; Cristalografia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Propriedades Mecânicas e Acústicas da Matéria Condensada');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Dinâmica da Rede e Estatística de Cristais');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Equação de Estado, Equilíbrio de Fases e Transições de Fase');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Propriedades Térmicas da Matéria Condensada');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Propriedades de Transportes de Matéria Condensada (Não Eletrônicas)');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Campos Quânticos e Sólidos, Hélio, Líquido, Sólido');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Superfícies e Interfaces; Películas e Filamentos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Estados Eletrônicos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Transp.Eletrônicos e Prop. Elétricas de Superfícies; Interfaces e Películas');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Estruturas Eletrônicas e Propriedades Elétricas de Superfícies Interfaces e Películas  ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Supercondutividade');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Materiais Magnéticos e Propriedades Magnéticas');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Ressonância Mag.e Relax.Na Mat.Condens;Efeitos Mosbauer;Corr.Ang.Pertubada');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Materiais Dielétricos e Propriedades Dielétricas');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Prop.Óticas e Espectrosc.da Mat.Condens;Outras Inter.da Mat.Com Rad.e Part.');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (23,default,7,'Emissão Eletrônica e Iônica por Líquidos e Sólidos; Fenômenos de Impacto');



INSERT INTO area_conhecimento (ga,codigo,ref,descricao)values (1,6,5,'Química');


INSERT INTO area_especifica (ac,codigo,ref,descricao)values (6,24,9,'Química Orgânica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (24,default,7,'Estrutura, Conformação e Estereoquímica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (24,default,7,'Sintese Orgânica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (24,default,7,'Fisico-Química Orgânica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (24,default,7,'Fotoquímica Orgânica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (24,default,7,'Química dos Produtos Naturais');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (24,default,7,'Evolução, Sistemática e Ecologia Química');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (24,default,7,'Polimeros e Colóides ');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (6,25,9,'Química Inorgânica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (25,default,7,'Campos de Coordenação ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (25,default,7,'Não-Metais e Seus Compostos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (25,default,7,'Compostos Organo-Metálicos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (25,default,7,'Determinação de Estrutura de Compostos Inorgânicos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (25,default,7,'Foto-Química Inorgânica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (25,default,7,'Fisico Química Inorgânica ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (25,default,7,'Química Bio-Inorgânica');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (6,26,9,'Fisico-Química ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (26,default,7,'Cinética Química e Catálise');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (26,default,7,'Eletroquímica ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (26,default,7,'Espectroscopia ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (26,default,7,'Química de Interfaces ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (26,default,7,'Química do Estado Condensado');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (26,default,7,'Química Nuclear e Radioquímica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (26,default,7,'Química Teórica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (26,default,7,'Termodinâmica Química');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (6,27,9,'Química Analítica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (27,default,7,'Separação ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (27,default,7,'Métodos Óticos de Análise');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (27,default,7,'Eletroanalítica ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (27,default,7,'Gravimetria ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (27,default,7,'Titimetria ');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (27,default,7,'Instrumentação Analítica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (27,default,7,'Análise de Traços e Química Ambiental');



INSERT INTO area_conhecimento (ga,codigo,ref,descricao)values (1,7,5,'GeoCiências');




INSERT INTO area_especifica (ac,codigo,ref,descricao)values (7,28,9,'Geologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Mineralogia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Petrologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Geoquímica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Geologia Regional');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Geotectônica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Geocronologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Cartografia Geológica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Metalogenia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Hidrogeologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Prospecção Mineral');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Sedimentologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Paleontologia Estratigráfica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Estratigrafia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (28,default,7,'Geologia Ambiental');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (7,29,9,'Geofísica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (29,default,7,'Geomagnetismo');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (29,default,7,'Sismologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (29,default,7,'Geotermia e Fluxo Térmico');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (29,default,7,'Propriedades Físicas das Rochas');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (29,default,7,'Geofísica Nuclear');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (29,default,7,'Sensoriamento Remoto');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (29,default,7,'Aeronomia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (29,default,7,'Desenvolvimento de Instrumentação Geofísica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (29,default,7,'Geofísica Aplicada');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (29,default,7,'Gravimetria');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (7,30,9,'Meteorologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (30,default,7,'Meteorologia Dinâmica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (30,default,7,'Meteorologia Sinótica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (30,default,7,'Meteorologia Física');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (30,default,7,'Química da Atmosfera');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (30,default,7,'Instrumentação Meteorológica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (30,default,7,'Climatologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (30,default,7,'Micrometeorologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (30,default,7,'Sensoriamento Remoto da Atmosfera');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (30,default,7,'Meteorologia Aplicada');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (7,31,9,'Geodesia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (31,default,7,'Geodesia Física');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (31,default,7,'Geodesia Geométrica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (31,default,7,'Geodesia Celeste');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (31,default,7,'Fotogrametria');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (31,default,7,'Cartografia Básica');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (7,32,9,'Geografia Física');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (32,default,7,'Geomorfologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (32,default,7,'Climatologia Geográfica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (32,default,7,'Pedologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (32,default,7,'Hidrogeografia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (32,default,7,'Geoecologia');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (32,default,7,'Fotogeografia (Físico-Ecológica)');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (32,default,7,'Geocartografia');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (5,33,9,'Física das Partículas Elementares e Campos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (33,default,7,'Teoria Geral de Partículas e Campos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (33,default,7,'Teorias Específicas e Modelos de Interação; Sistematica de Partículas; Raios Cósmicos');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (33,default,7,'Reações Específicas e Fenomiologia de Partículas');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (33,default,7,'Propriedades de Partículas Específicas e Ressonâncias');



INSERT INTO area_conhecimento (ga,codigo,ref,descricao)values (1,8,5,'Oceanografia');



INSERT INTO area_especifica (ac,codigo,ref,descricao)values (8,34,9,'Oceanografia Biológica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (34,default,7,'Interação entre os Organismos Marinhos e os Parâmetros Ambientais');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (8,35,9,'Oceanografia Física');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (35,default,7,'Variáveis Físicas da Água do Mar');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (35,default,7,'Movimento da Água do Mar');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (35,default,7,'Origem das Massas de Água');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (35,default,7,'Interação do Oceano com o Leito do Mar');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (35,default,7,'Interação do Oceano com a Atmosfera');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (8,36,9,'Oceanografia Química');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (36,default,7,'Propriedades Químicas da Água do Mar');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (36,default,7,'Interações Químico-Biológicas/Geológicas das Substâncias Químicas da Água do Mar');

INSERT INTO area_especifica (ac,codigo,ref,descricao)values (8,37,9,'Oceanografia Geológica');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (37,default,7,'Geomorfologia Submarina');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (37,default,7,'Sedimentologia Marinha');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (37,default,7,'Geofísica Marinha');










INSERT INTO area_conhecimento (ga,codigo,ref,descricao)values (1,4,5,'');
INSERT INTO area_especifica (ac,codigo,ref,descricao)values (2,6,9,'');
INSERT INTO sub_area (ae,codigo,ref,descricao)values (6,default,7,'');










