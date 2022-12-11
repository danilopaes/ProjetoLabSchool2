CREATE TABLE `alunos`
(
    `codigo`                         bigint(20) UNIQUE NOT NULL AUTO_INCREMENT,
    `cpf`                            bigint(20) UNIQUE NOT NULL,
    `data_nascimento`                date              NOT NULL,
    `nome`                           varchar(255)      NOT NULL,
    `telefone`                       varchar(255)      NOT NULL,
    `situacao_da_matricula`          varchar(255)      NOT NULL,
    `nota_processo_seletivo`         float(20)         NOT NULL,
    `total_atendimentos_pedagogicos` bigint(20)        NOT NULL DEFAULT 0,
    PRIMARY KEY (`codigo`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
