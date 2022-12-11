CREATE TABLE `professores`
(
    `codigo`             bigint(20) UNIQUE NOT NULL AUTO_INCREMENT,
    `cpf`                bigint(20) UNIQUE NOT NULL,
    `data_nascimento`    date              NOT NULL,
    `nome`               varchar(255)      NOT NULL,
    `telefone`           varchar(255)      NOT NULL,
    `estado`             varchar(255)      NOT NULL,
    `experiencia`        varchar(255)      NOT NULL,
    `formacao_academica` varchar(255)      NOT NULL,
    PRIMARY KEY (`codigo`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
