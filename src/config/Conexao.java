package src.config;

import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public @Nullable Connection pegaConexao() {
        final String driver = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql//localhost:3306/hospital_db";
        final String user = "mysql";
        final String password = "12345678";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void fechaConexao(Connection conn) {
       if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
