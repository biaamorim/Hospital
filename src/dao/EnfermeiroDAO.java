package dao;

import config.ProvedorPostgres;
import domain.Enfermeiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        System.out.println("Insira o horario do inicio do expediente: ");
        float inicioExpediente = scan.nextFloat();
        System.out.println("Insira o horario de termino do expediente: ");
        float fimExpediente = scan.nextFloat();
        return new Enfermeiro(nome, cpf, telefone, endereco, sexo, 0, equipe, supervisor, inicioExpediente,
                fimExpediente);

    }

    public void cadastrarEnfermeiro(Enfermeiro enfermeiro) {
        String pessoaQuery = "INSERT INTO pessoa (cpf, nome, numero_telefone, endereco, sexo) VALUES (?, ?, ?, ?, ?);";
        String enfermeiroQuery = "INSERT INTO enfermeiro (id_enfermeiro, tipo_equipe, e_supervisor, inicio_expediente, fim_expediente) VALUES (?,?,?,?,?);";

        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm;

        try {
            pstm = conn.prepareStatement(pessoaQuery);
            pstm.setString(1, enfermeiro.getCpf());
            pstm.setString(2, enfermeiro.getNome());
            pstm.setString(3, enfermeiro.getNumeroTelefone());
            pstm.setString(4, enfermeiro.getEndereco());
            pstm.setString(5, enfermeiro.getSexo());
            pstm.execute();
            pstm = conn.prepareStatement(enfermeiroQuery);
            pstm.setString(1, enfermeiro.getTipoEquipe());
            pstm.setBoolean(2, enfermeiro.getESupervisor());
            pstm.setFloat(3, enfermeiro.getInicioExpediente());
            pstm.setFloat(4, enfermeiro.getFimExpediente());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Enfermeiro encontrar(int id) throws SQLException {
        Connection conn = provedor.pegaConexao();
        PreparedStatement pstm = conn.prepareStatement("SELECT * FROM enfermeiro WHERE  id_enfermeiro = ?;");
        ResultSet resultado = pstm.executeQuery();
        Enfermeiro enfermeiro = getEnfermeiroResult(resultado);
        pstm.close();
        conn.close();
        return enfermeiro;

    }

    private Enfermeiro getEnfermeiroResult(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id_enfermeiro");
        String nome = resultado.getString("nome");
        String telefone = resultado.getString("numero_telefone");
        String endereco = resultado.getString("endereco");
        String cpf = resultado.getString("cpf");
        String sexo = resultado.getString("sexo");
        String tipo_equipe = resultado.getString("tipo_equipe");
        Boolean supervisor = resultado.getBoolean("e_suoervisor");
        Float inicio = resultado.getFloat("inicio_expediente");
        Float fim = resultado.getFloat("fim_expediente");

        return new Enfermeiro(nome, cpf, telefone, endereco, sexo, id, tipo_equipe, supervisor, inicio, fim);
    }

}
