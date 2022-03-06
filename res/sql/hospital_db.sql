CREATE DATABASE hospital_db;

\connect hospital_db;

CREATE TABLE pessoa
(
    --- atributos ---
    id              SERIAL PRIMARY KEY,
    cpf             VARCHAR(15),
    nome            VARCHAR(100),
    numero_telefone VARCHAR(10),
    endereco        VARCHAR(100),
    sexo            VARCHAR(20)
);

CREATE TABLE enfermeiro
(
    --- atributos ---
    id_enfermeiro     SERIAL PRIMARY KEY,
    tipo_equipe       VARCHAR(50) NOT NULL,
    e_supervisor      BOOLEAN     NOT NULL,

    --- chaves estrangeiras ---
    pessoa_enfermeiro_id INT NOT NULL,

    --- constraints ---
    CONSTRAINT pessoa_enfermeiro_fk
        FOREIGN KEY (pessoa_enfermeiro_id)
            REFERENCES pessoa (id)
);

CREATE TABLE medico
(
    --- atributos ---
    id_medico         SERIAL PRIMARY KEY,
    crm               VARCHAR(25) NOT NULL,
    especialidade     VARCHAR(50) NOT NULL,
    dia_plantao       VARCHAR(20) NOT NULL,

    --- chaves estrangeiras ---
    pessoa_medico_id INT NOT NULL,

    --- constraints ---
    CONSTRAINT pessoa_medico_fk
        FOREIGN KEY (pessoa_medico_id)
            REFERENCES pessoa (id)
);

CREATE TABLE paciente
(
    --- atributos ---
    id_paciente     SERIAL PRIMARY KEY,
    data_nascimento VARCHAR(20)        NOT NULL,
    cor             VARCHAR(15) NOT NULL,
    filiacao        VARCHAR(50) NOT NULL,
    email           VARCHAR(50) NOT NULL,
    dataCadastro    VARCHAR(50) NOT NULL,
    --- chaves estrangeiras ---
    pessoa_paciente_id INT NOT NULL,

    --- constraints ---
    CONSTRAINT pessoa_paciente_fk
        FOREIGN KEY (pessoa_paciente_id)
            REFERENCES pessoa (id)
);

CREATE TABLE ficha
(
    --- atributos ---
    id_ficha         SERIAL PRIMARY KEY,
    descricao        VARCHAR(100) NOT NULL,
    tipo_atendimento VARCHAR(50)  NOT NULL,
    data_registro    VARCHAR(10) NOT NULL
);

CREATE TABLE registro
(
    --- atributos ---
    id_registro   SERIAL PRIMARY KEY,

    --- chaves estrangeiras ---
    paciente_id   INT NOT NULL,
    medico_id     INT NOT NULL,
    enfermeiro_id INT NOT NULL,
    ficha_id      INT NOT NULL,

    --- constraints ---
    CONSTRAINT registro_paciente_fk
        FOREIGN KEY (paciente_id)
            REFERENCES paciente (id_paciente),

    CONSTRAINT registro_medico_fk
        FOREIGN KEY (medico_id)
            REFERENCES medico (id_medico),

    CONSTRAINT registro_enfermeiro_fk
        FOREIGN KEY (enfermeiro_id)
            REFERENCES enfermeiro (id_enfermeiro),

    CONSTRAINT registro_ficha_fk
        FOREIGN KEY (ficha_id)
            REFERENCES ficha (id_ficha)
);