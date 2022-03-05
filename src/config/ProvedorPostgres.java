package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProvedorPostgres {
    public Connection pegaConexao() {
        Connection connection = null;

        final String driver = "org.postgresql.Driver";
        final String url = "jdbc:postgres//localhost:5432/hospital_db";
        final String user = "postgres";
        final String password = "12345678";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
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
