package src.config;

import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Provedor {
    public Connection pegaConexao() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        final String driver = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql//localhost:3306/hospital_db";
        final String user = "mysql";
        final String password = "12345678";

        Class.forName(driver);

        connection = DriverManager.getConnection(url, user, password);

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
