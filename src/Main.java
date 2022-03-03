package src;

import src.config.Conexao;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Conexao provedor = new Conexao();
        Connection conn = provedor.pegaConexao();
        System.out.println("Conexão estabelecida!");
    }
}
