package dao;

import config.ProvedorPostgres;
import domain.Enfermeiro;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EnfermeiroDAO {

    ProvedorPostgres provedor = new ProvedorPostgres();

    public Enfermeiro preencheEnfermeiro() {
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------- DADOS DO ENFERMEIRO -------------------");
        System.out.println("Insira o nome");
        String nome = scan.next();
        System.out.println("Insira o cpf: ");
        String cpf = scan.next();
        System.out.println("Insira o número de telefone: ");
        String telefone = scan.next();
        System.out.println("Insira o endereço: ");
        String endereco = scan.next();
        System.out.println("Insira o sexo:");
        String sexo = scan.next();
        System.out.println("Insira o tipo de equipe: ");
        String equipe = scan.next();
        System.out.println("Insira se é superviso: ");
        boolean supervisor = scan.nextBoolean();
        return new Enfermeiro(nome, cpf, telefone, endereco, sexo, 0, equipe, supervisor);
    }

    public void listaEnfermeiros() {
        String enfermeiroQuery= """
                SELECT p.cpf             AS cpf,
                       p.nome            AS nome,
                       p.numero_telefone AS telefone,
                       p.endereco        AS endereco,
                       p.sexo            AS sexo,
                       e.id_enfermeiro   AS id,
                       e.tipo_equipe     AS tipo_equipe,
                       e.e_supervisor    AS e_supervisor
                FROM enfermeiro e
                         INNER JOIN pessoa p on p.id = e.pessoa_enfermeiro_id;""";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        ResultSet resultSet;
        List<Enfermeiro> enfermeiros = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(enfermeiroQuery);
            resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Enfermeiro enfermeiro = new Enfermeiro(resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("telefone"),
                        resultSet.getString("endereco"), resultSet.getString("sexo"), resultSet.getInt("id"), 
                        resultSet.getString("tipo_equipe"), resultSet.getBoolean("e_supervisor"));
                enfermeiros.add(enfermeiro);
            }
            for (Enfermeiro enfermeiro: enfermeiros) {
                System.out.println("Id: " + enfermeiro.getId());
                System.out.println("Nome: " + enfermeiro.getNome());
                System.out.println("CPF: " + enfermeiro.getCpf());
                System.out.println("Telefone: " + enfermeiro.getNumeroTelefone());
                System.out.println("Endereço: " + enfermeiro.getEndereco());
                System.out.println("Tipo de equipe: " + enfermeiro.getTipoEquipe());
                System.out.println("É supervisor: " + enfermeiro.getESupervisor());
                System.out.println("------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                provedor.fechaConexao(conn);
            }
        }
    }

    public void cadastraEnfermeiro(@NotNull Enfermeiro enfermeiro) {
        String pessoaQuery = "INSERT INTO pessoa (cpf, nome, numero_telefone, endereco, sexo) VALUES (?, ?, ?, ?, ?) RETURNING id;";
        String enfermeiroQuery = "INSERT INTO enfermeiro (tipo_equipe, e_supervisor, pessoa_enfermeiro_id) VALUES (?,?,?);";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(pessoaQuery);
            pstm.setString(1, enfermeiro.getCpf());
            pstm.setString(2, enfermeiro.getNome());
            pstm.setString(3, enfermeiro.getNumeroTelefone());
            pstm.setString(4, enfermeiro.getEndereco());
            pstm.setString(5, enfermeiro.getSexo());
            ResultSet resultSet = pstm.executeQuery();
            int idPessoa = 0;
            if (resultSet.next()) {
                idPessoa = resultSet.getInt("id");
            }
            pstm = conn.prepareStatement(enfermeiroQuery);
            pstm.setString(1, enfermeiro.getTipoEquipe());
            pstm.setBoolean(2, enfermeiro.getESupervisor());
            pstm.setInt(3, idPessoa);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                provedor.fechaConexao(conn);
            }
        }
    }

    public void atualizaEnfermeiro(@NotNull Enfermeiro enfermeiro, int id) {
        String enfermeiroQuery = "UPDATE enfermeiro SET tipo_equipe = ?, e_supervisor = ? WHERE id_enfermeiro = ? RETURNING pessoa_enfermeiro_id;";
        String pessoaQuery = "UPDATE pessoa SET cpf = ?, nome = ?, numero_telefone = ?, endereco = ?, sexo = ? WHERE id = ?;";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(enfermeiroQuery);
            pstm.setString(1, enfermeiro.getTipoEquipe());
            pstm.setBoolean(2, enfermeiro.getESupervisor());
            pstm.setInt(3, id);
            ResultSet resultSet = pstm.executeQuery();
            int idPessoa = 0;
            if (resultSet.next()) {
                idPessoa = resultSet.getInt("pessoa_enfermeiro_id");
            }
            pstm = conn.prepareStatement(pessoaQuery);
            pstm.setString(1, enfermeiro.getCpf());
            pstm.setString(2, enfermeiro.getNome());
            pstm.setString(3, enfermeiro.getNumeroTelefone());
            pstm.setString(4, enfermeiro.getEndereco());
            pstm.setString(5, enfermeiro.getSexo());
            pstm.setInt(6, idPessoa);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                provedor.fechaConexao(conn);
            }
        }
    }

    public void removeEnfermeiro(int id) {
        String medicoQuery = "DELETE FROM enfermeiro WHERE id_enfermeiro = ? RETURNING pessoa_enfermeiro_id;";
        String pessoaQuery = "DELETE FROM pessoa WHERE id = ?;";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(medicoQuery);
            pstm.setInt(1, id);
            ResultSet resultSet = pstm.executeQuery();
            int idPessoa = 0;
            if (resultSet.next()) {
                idPessoa = resultSet.getInt("pessoa_medico_id");
            }
            pstm = conn.prepareStatement(pessoaQuery);
            pstm.setInt(1, idPessoa);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                provedor.fechaConexao(conn);
            }
        }
    }
}
