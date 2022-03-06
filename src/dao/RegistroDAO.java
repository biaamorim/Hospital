package dao;

import config.ProvedorPostgres;
import domain.Registro;
import interfaces.DAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroDAO implements DAOInterface {
    ProvedorPostgres provedor = new ProvedorPostgres();
    public void lista() {
        String registrosQuery = """
                SELECT r.id_registro      AS id,
                       pp.nome            AS nome_paciente,
                       f.tipo_atendimento AS tipo_atendimento,
                       f.data_registro    AS dia_atendimento,
                       m.especialidade    AS area_atendimento,
                       pm.nome            AS nome_medico,
                       pe.nome            AS nome_enfermeiro
                FROM registro r
                         INNER JOIN paciente p on p.id_paciente = r.paciente_id
                         INNER JOIN pessoa pp on pp.id = p.pessoa_paciente_id
                         INNER JOIN ficha f on f.id_ficha = r.ficha_id
                         INNER JOIN enfermeiro e on e.id_enfermeiro = r.enfermeiro_id
                         INNER JOIN pessoa pe on pe.id = e.pessoa_enfermeiro_id
                         INNER JOIN medico m on m.id_medico = r.medico_id
                         INNER JOIN pessoa pm on pm.id = m.pessoa_medico_id;""";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        ResultSet resultSet;
        List<Registro> registros = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(registrosQuery);
            resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Registro registro = new Registro(resultSet.getInt("id"), resultSet.getString("nome_paciente"), resultSet.getString("tipo_atendimento"),
                                                resultSet.getString("dia_atendimento"), resultSet.getString("area_atendimento"), resultSet.getString("nome_medico"),
                                                resultSet.getString("nome_enfermeiro"));
                registros.add(registro);
            }
            for (Registro registro: registros) {
                System.out.println("Id: " + registro.getId());
                System.out.println("Nome do Paciente: " + registro.getNomePaciente());
                System.out.println("Dia do atendimento: " + registro.getDiaAtendimento());
                System.out.println("Tipo de atendimento: " + registro.getTipoAtendimento());
                System.out.println("Área de atendimento: " + registro.getAreaAtendimento());
                System.out.println("Nome do Médico: " + registro.getNomeMedico());
                System.out.println("Nome do Enfermeiro: " + registro.getNomeEnfermeiro());
                System.out.println("----------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                provedor.fechaConexao(conn);
            }
        }
    }

    public void cadastraRegistro() {
        String registroQuery = "INSERT INTO registro (paciente_id, medico_id, enfermeiro_id, ficha_id) VALUES (?, ?, ?, ?);";
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira o id do paciente: ");
        int idPaciente = scan.nextInt();
        System.out.println("Insira o id do médico: ");
        int idMedico = scan.nextInt();
        System.out.println("Insira o id do enfermeiro: ");
        int idEnfermeiro = scan.nextInt();
        System.out.println("Insira o id da ficha: ");
        int idFicha = scan.nextInt();
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(registroQuery);
            pstm.setInt(1, idPaciente);
            pstm.setInt(2, idMedico);
            pstm.setInt(3, idEnfermeiro);
            pstm.setInt(4, idFicha);
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
        String registroQuery = "DELETE FROM registro WHERE id_registro = ?;";
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(registroQuery);
            pstm.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                provedor.fechaConexao(conn);
            }
        }
    }
}
