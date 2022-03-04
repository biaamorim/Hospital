CREATE DATABASE hospital_db;


/*TABELAS*/
CREATE TABLE enfermeiro (
    id_Enfer INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_Equipe VARCHAR(50) NOT NULL,
    e_Supervisor TINYINT NOT NULL
    inicio_Expediente TIME NOT NULL,
    fim_Expediente TIME NOT NULL
);

CREATE TABLE ficha (
    id_ficha INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(1000) NOT NULL,
    data_Registro TIMESTAMP(10) NOT NULL,
    tipo_Atendimento VARCHAR(100) NOT NOT
);

CREATE TABLE medico ()
    id_medico INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    crm VARCHAR(25) NOT NULL
    especialidade VARCHAR(50) NOT NULL,
    dia_Plantao DATE(15),
    inicio_Expediente TIME NOT NULL,
    fim_Expediente TIME NOT NULL
);

CREATE TABLE paciente (
    id_paciente INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    data_Nascimento DATE NOT NULL,
    cor VARCHAR(15) NOT NULL,
    filiacao VARCHAR(50) NOT NULL,
    email VARCHAR(100)
);

CREATE TABLE pessoa (
    cpf VARCHAR(15) PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    numero_Telefone VARCHAR(10),
    endereco VARCHAR(100),
    sexo VARCHAR(20)  
);

CREATE TABLE registro (
    id_registro INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    paciente_Id INT NOT NULL,
    medico_Id INT NOT NULL,
    enfermeiro_Id INT NOT NULL,
    ficha_Id INT NOT NULL
);

/*DATAS FORMATADAS*/
SELECT DATE_FORMAT(data_Nascimento() ‘%d/%m/%Y’);
SELECT DATE_FORMAT(dia_Plantao() ‘%d/%m/%Y’);
SELECT DATE_FORMAT(data_Registro() ‘%d/%m/%Y’);