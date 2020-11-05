# BackendDesafioCaixaSeguradora
Desafio Caixa Seguradora Backend

URL para acessso ao Swegger após Start da Aplicação: http://localhost:8080/swagger-ui.htm

Script criação do Banco de dados e tabela:

CREATE DATABASE `osnwt` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `osnwt.cidade (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`nome` varchar(100) NOT NULL,
`estado` varchar(4) NOT NULL, 
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4;

Tabela: CREATE TABLE customer ( id bigint(20) NOT NULL AUTO_INCREMENT, endereco varchar(100) NOT NULL, cidade varchar(100) NOT NULL, uf varchar(100) NOT NULL, genero varchar(8) NOT NULL, nome varchar(100) NOT NULL, sobre_nome varchar(100) NOT NULL, num_cpf varchar(30) NOT NULL, dth_nascimento datetime NOT NULL, PRIMARY KEY (id) ) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4







