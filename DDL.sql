-- Cria o schema (banco de dados) se ainda não existir
CREATE DATABASE IF NOT EXISTS `SistemaHospedagem`
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci;

-- Seleciona o schema para uso
USE `SistemaHospedagem`;

-- Tabela: tb_hospede
DROP TABLE IF EXISTS `tb_hospede`;
CREATE TABLE `tb_hospede` (
  `ID_HOSPEDE` int NOT NULL AUTO_INCREMENT COMMENT 'Código do hóspede',
  `VC_CPF` varchar(11) NOT NULL COMMENT 'CPF do hóspede',
  `VC_NOME` varchar(100) NOT NULL COMMENT 'Nome do hóspede',
  PRIMARY KEY (`ID_HOSPEDE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Tabela: tb_quarto
DROP TABLE IF EXISTS `tb_quarto`;
CREATE TABLE `tb_quarto` (
  `ID_QUARTO` int NOT NULL AUTO_INCREMENT COMMENT 'ID/Número do quarto',
  `VC_CATEGORIA` varchar(8) NOT NULL COMMENT 'Categoria do quarto (Standard, Premium, Chalé)',
  `INT_VALOR` int NOT NULL COMMENT 'Valor da diária do quarto (valor/100)',
  PRIMARY KEY (`ID_QUARTO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Tabela: tb_estadia
DROP TABLE IF EXISTS `tb_estadia`;
CREATE TABLE `tb_estadia` (
  `ID_ESTADIA` int NOT NULL AUTO_INCREMENT COMMENT 'ID da Estadia',
  `DT_CHECKIN` datetime NOT NULL COMMENT 'Data da realização do checkin',
  `DT_CHECKOUT_ESPERADO` datetime NOT NULL COMMENT 'Data do checkout esperado',
  `DT_CHECKOUT_FINAL` datetime DEFAULT NULL COMMENT 'Data da realização do checkout',
  `ID_HOSPEDE` int NOT NULL COMMENT 'ID do Hóspede da Estadia',
  `ID_QUARTO` int NOT NULL COMMENT 'ID do Quarto da Estadia',
  PRIMARY KEY (`ID_ESTADIA`),
  KEY `tb_estadia_hospede_FK` (`ID_HOSPEDE`),
  KEY `tb_estadia_quarto_FK` (`ID_QUARTO`),
  CONSTRAINT `tb_estadia_hospede_FK` FOREIGN KEY (`ID_HOSPEDE`) REFERENCES `tb_hospede` (`ID_HOSPEDE`),
  CONSTRAINT `tb_estadia_quarto_FK` FOREIGN KEY (`ID_QUARTO`) REFERENCES `tb_quarto` (`ID_QUARTO`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Tabela: tb_funcionario
DROP TABLE IF EXISTS `tb_funcionario`;
CREATE TABLE `tb_funcionario` (
  `ID_FUNCIONARIO` int NOT NULL AUTO_INCREMENT COMMENT 'ID do Funcionário',
  `VC_CPF` varchar(11) NOT NULL COMMENT 'CPF do Funcionário',
  `VC_CARGO` varchar(50) NOT NULL COMMENT 'Cargo do funcionário (Recepcionista, Camareira, Cozinheiro, Chefe, Garçom, Guia, Gerente)',
  `VC_NOME` varchar(100) NOT NULL COMMENT 'Nome do Funcionário',
  PRIMARY KEY (`ID_FUNCIONARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Tabela: tb_servico
DROP TABLE IF EXISTS `tb_servico`;
CREATE TABLE `tb_servico` (
  `ID_SERVICO` int NOT NULL AUTO_INCREMENT COMMENT 'ID do serviço',
  `ID_HOSPEDE` int NOT NULL COMMENT 'ID do hospede que solicitou o serviço',
  `VC_TIPO` varchar(50) NOT NULL COMMENT 'Tipo do serviço solicitado (Café, Passeio, Spa, Restaurante, WIFI, Bicicleta, Bebida)',
  `INT_VALOR` int NOT NULL COMMENT 'Valor do serviço solicitado (valor/100)',
  `DT_SERVICO` datetime NOT NULL COMMENT 'Data da prestação do serviço',
  PRIMARY KEY (`ID_SERVICO`),
  KEY `TB_SERVICO_FK` (`ID_HOSPEDE`),
  CONSTRAINT `TB_SERVICO_FK` FOREIGN KEY (`ID_HOSPEDE`) REFERENCES `tb_hospede` (`ID_HOSPEDE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
