package dao;

import config.ProvedorPostgres;
import domain.Medico;
import interfaces.DAOInterface;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicoDAO implements DAOInterface {
    ProvedorPostgres provedor = new ProvedorPostgres();

    public Medico preencheMedico() {
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------- DADOS DO MÉDICO -------------------");
        System.out.println("Insira o cpf: ");
        String cpf = scan.nextLine();
        System.out.println("Insira o nome: ");
        String nome = scan.nextLine();
        System.out.println("Insira o número de telefone: ");
        String telefone = scan.nextLine();
        System.out.println("Insira o endereço: ");
        String endereco = scan.nextLine();
        System.out.println("Insira o sexo: ");
        String sexo = scan.nextLine();
        System.out.println("Insira o CRM: ");
        String crm = scan.nextLine();
        System.out.println("Insira a especialidade: ");
        String especialidade = scan.nextLine();
        System.out.println("Insira o dia de plantão: ");
        String diaPlantao = scan.nextLine();
        return new Medico(nome, cpf, telefone, endereco, sexo, 0, crm, especialidade, diaPlantao);
    }

    public void lista() {
        String medicoQuery = """
                SELECT p.cpf             AS cpf,
                       p.nome            AS nome,
                       p.numero_telefone AS telefone,
                       p.endereco        AS endereco,
                       p.sexo            AS sexo,
                       m.id_medico       AS id,
                       m.crm             AS crm,
                       m.especialidade   AS especialidade,
                       m.dia_plantao     AS dia_plantao
                FROM medico m
                         INNER JOIN pessoa p on m.pessoa_medico_id = p.id;""";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        ResultSet resultSet;
        List<Medico> medicos = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(medicoQuery);
            resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Medico medico = new Medico(resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("telefone"), resultSet.getString("endereco"), resultSet.getString("sexo"), resultSet.getInt("id"), resultSet.getString("crm"), resultSet.getString("especialidade"), resultSet.getString("dia_plantao"));
                medicos.add(medico);
            }
            for (Medico medico : medicos) {
                System.out.println("Id: " + medico.getId());
                System.out.println("Nome: " + medico.getNome());
                System.out.println("CPF: " + medico.getCpf());
                System.out.println("Telefone: " + medico.getNumeroTelefone());
                System.out.println("Endereço: " + medico.getEndereco());
                System.out.println("CRM: " + medico.getCrm());
                System.out.println("Especialidade: " + medico.getEspecialidade());
                System.out.println("Dia de plantão: " + medico.getDiaPlantao());
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

    public void cadastra(@NotNull Medico medico) {
        String pessoaQuery = "INSERT INTO pessoa (cpf, nome, numero_telefone, endereco, sexo) VALUES (?, ?, ?, ?, ?) RETURNING id;";
        String medicoQuery = "INSERT INTO medico (crm, especialidade, dia_plantao, pessoa_medico_id) VALUES (?, ?, ?, ?);";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(pessoaQuery);
            pstm.setString(1, medico.getCpf());
            pstm.setString(2, medico.getNome());
            pstm.setString(3, medico.getNumeroTelefone());
            pstm.setString(4, medico.getEndereco());
            pstm.setString(5, medico.getSexo());
            ResultSet resultSet = pstm.executeQuery();
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            pstm = conn.prepareStatement(medicoQuery);
            pstm.setString(1, medico.getCrm());
            pstm.setString(2, medico.getEspecialidade());
            pstm.setString(3, medico.getDiaPlantao());
            pstm.setInt(4, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                provedor.fechaConexao(conn);
            }
        }
    }

    public void atualiza(@NotNull Medico medico, int id) {
        String medicoQuery = "UPDATE medico SET crm = ?, especialidade = ?, dia_plantao = ? WHERE id_medico = ? RETURNING pessoa_medico_id;";
        String pessoaQuery = "UPDATE pessoa SET cpf = ?, nome = ?, numero_telefone = ?, endereco = ?, sexo = ? WHERE id = ?;";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(medicoQuery);
            pstm.setString(1, medico.getCrm());
            pstm.setString(2, medico.getEspecialidade());
            pstm.setString(3, medico.getDiaPlantao());
            pstm.setInt(4, id);
            ResultSet resultSet = pstm.executeQuery();
            int idPessoa = 0;
            if (resultSet.next()) {
                idPessoa = resultSet.getInt("pessoa_medico_id");
            }
            pstm = conn.prepareStatement(pessoaQuery);
            pstm.setString(1, medico.getCpf());
            pstm.setString(2, medico.getNome());
            pstm.setString(3, medico.getNumeroTelefone());
            pstm.setString(4, medico.getEndereco());
            pstm.setString(5, medico.getSexo());
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

    public void remove(int id) {
        String registroQuery = "DELETE FROM registro WHERE medico_id = ?;";
        String medicoQuery = "DELETE FROM medico WHERE id_medico = ? RETURNING pessoa_medico_id  ;";
        String pessoaQuery = "DELETE FROM pessoa WHERE id = ?  ;";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(registroQuery);
            pstm.setInt(1, id);
            pstm.execute();

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
