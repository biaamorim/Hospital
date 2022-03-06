package dao;

import config.ProvedorPostgres;
import domain.Medico;
import domain.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PacienteDAO {
    ProvedorPostgres provedor = new ProvedorPostgres();

    public Paciente preenchePaciente() {
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------- DADOS DO PACIENTE -------------------");
        System.out.println("Insira o cpf: ");
        String cpf = scan.next();
        System.out.println("Insira o nome: ");
        String nome = scan.next();
        System.out.println("Insira o número de telefone: ");
        String telefone = scan.next();
        System.out.println("Insira o endereço: ");
        String endereco = scan.next();
        System.out.println("Insira o sexo: ");
        String sexo = scan.next();
        System.out.println("Insira o data de nascimento: ");
        String datanascimento = scan.next();
        System.out.println("Insira a cor:   ");
        String cor = scan.next();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date datadecadastro = new Date();
        System.out.println("Filiação: ");
        String filiacao = scan.next();
        System.out.println("email: ");
        String email = scan.next();

        return new Paciente(nome, cpf, telefone, endereco, sexo, 0, datanascimento, cor, dateFormat.format(datadecadastro),filiacao,email);
    }

    public void cadastrarPaciente(Paciente paciente) {
        String pessoaQuery = "INSERT INTO pessoa (cpf, nome, numero_telefone, endereco,sexo) VALUES (?,?,?,?,?) RETURNING id;";
        String pacienteQuery = "INSERT INTO paciente  ( data_nascimento, cor, filiacao , email,dataCadastro,pessoa_paciente_id  ) VALUES (?, ?, ?, ?,?,?);";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(pessoaQuery);
            pstm.setString(1, paciente.getCpf());
            pstm.setString(2, paciente.getNome());
            pstm.setString(3, paciente.getNumeroTelefone());
            pstm.setString(4, paciente.getEndereco());
            pstm.setString(5, paciente.getSexo());
            ResultSet resultSet = pstm.executeQuery();
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }

            pstm = conn.prepareStatement(pacienteQuery);
            pstm.setString(1, paciente.getDataNascimento());
            pstm.setString(2, paciente.getCor());
            pstm.setString(3, paciente.getFiliacao());
            pstm.setString(4, paciente.getEmail());
            pstm.setString(5, paciente.getDataCadastro());
            pstm.setInt(6, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void listaPaciente() {
            String pacienteQuery =  "SELECT p.cpf   AS cpf," +
                                    "p.nome AS nome," +
                                    "p.numero_telefone AS telefone," +
                                    "p.endereco AS endereco," +
                                    "p.sexo AS sexo," +
                                    "PC.id_paciente AS id," +
                                    "PC.data_nascimento   AS dataNascimento," +
                                    "PC.cor   AS cor," +
                                    "Pc.dataCadastro     AS dataCadastro," +
                                    "pc.filiacao as filiacao," +
                                    "PC.email AS email " +
                                    "FROM paciente PC " +
                                    "INNER JOIN pessoa p on PC.pessoa_paciente_id = p.id; ";

        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        ResultSet rset;
        List<Paciente> pacientes = new ArrayList<>();


        try {
            pstm = conn.prepareStatement(pacienteQuery);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Paciente paciente = new Paciente(
                            rset.getString("nome"),
                            rset.getString("cpf"),
                            rset.getString("telefone"),
                            rset.getString("endereco"),
                            rset.getString("sexo"),
                            rset.getInt("id"),
                            rset.getString("dataNascimento"),
                            rset.getString("cor"),
                            rset.getString("dataCadastro"),
                            rset.getString("filiacao"),
                            rset.getString("email"));
                pacientes.add(paciente);
            }

            for (Paciente paciente : pacientes) {
                System.out.println("Id: " + paciente.getId());
                System.out.println("Nome: " + paciente.getNome());
                System.out.println("CPF: " + paciente.getCpf());
                System.out.println("Telefone: " + paciente.getNumeroTelefone());
                System.out.println("Endereço: " + paciente.getEndereco());
                System.out.println("sexo: " + paciente.getSexo());
                System.out.println("Data de nascimento: " + paciente.getDataNascimento());
                System.out.println("cor: " + paciente.getCor());
                System.out.println("Data de cadastro: " + paciente.getDataCadastro());
                System.out.println("Filiação: " + paciente.getFiliacao());
                System.out.println("Email: " + paciente.getEmail());
                System.out.println("------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizaPaciente(Paciente paciente, int id) {
        String pacienteQuery = "UPDATE medico SET data_nascimento = ?, cor = ?, filiacao = ? ,email  = ? ,dataCadastro = ? WHERE  pessoa_paciente_id = ? RETURNING pessoa_paciente_id;";
        String pessoaQuery = "UPDATE pessoa SET cpf = ?, nome = ?, numero_telefone = ?, endereco = ?, sexo = ? WHERE id = ?;";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(pacienteQuery);
            pstm.setString(1, paciente.getDataNascimento());
            pstm.setString(2, paciente.getCor());
            pstm.setString(3, paciente.getFiliacao());
            pstm.setString(4, paciente.getEmail());
            pstm.setString(5, paciente.getDataCadastro());
            pstm.setInt(6, id);
            ResultSet resultSet = pstm.executeQuery();
            int idPessoa = 0;
            if (resultSet.next()) {
                idPessoa = resultSet.getInt("pessoa_paciente_id");
            }
            pstm = conn.prepareStatement(pessoaQuery);
            pstm.setString(1, paciente.getCpf());
            pstm.setString(2, paciente.getNome());
            pstm.setString(3, paciente.getNumeroTelefone());
            pstm.setString(4, paciente.getEndereco());
            pstm.setString(5, paciente.getSexo());
            pstm.setInt(6, idPessoa);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    public void removePaciente(int id) {
        String pacienteQuery = "DELETE FROM paciente WHERE id_medico = ? RETURNING pessoa_paciente_id;";
        String pessoaQuery = "DELETE FROM pessoa WHERE id = ?;";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(pacienteQuery);
            pstm.setInt(1, id);
            ResultSet resultSet = pstm.executeQuery();
            int idPessoa = 0;
            if (resultSet.next()) {
                idPessoa = resultSet.getInt("pessoa_paciente_id");
            }
            pstm = conn.prepareStatement(pessoaQuery);
            pstm.setInt(1, idPessoa);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
