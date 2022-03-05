package dao;

import config.ProvedorPostgres;
import domain.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MedicoDAO {
    ProvedorPostgres provedor = new ProvedorPostgres();

    public Medico preencheMedico() {
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------- DADOS DO MÉDICO -------------------");
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
        System.out.println("Insira o CRM: ");
        String crm = scan.next();
        System.out.println("Insira a especialidade: ");
        String especialidade = scan.next();
        System.out.println("Insira o dia de plantão: ");
        String diaPlantao = scan.next();
        return new Medico(nome, cpf, telefone, endereco, sexo, 0, crm, especialidade, diaPlantao);
    }

    public void cadastraMedico(Medico medico) {
        // TODO: implementar retorno de id
        String pessoaQuery = "INSERT INTO pessoa (cpf, nome, numero_telefone, endereco, sexo) VALUES (?, ?, ?, ?, ?);";
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
            pstm.execute();
            pstm = conn.prepareStatement(medicoQuery);
            pstm.setString(1, medico.getCrm());
            pstm.setString(2, medico.getEspecialidade());
            pstm.setString(3, medico.getDiaPlantao());
            pstm.setInt(4, 1);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
