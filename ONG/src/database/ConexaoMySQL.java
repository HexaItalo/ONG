package database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static final String URL = "jdbc:mysql://ads-aula.mysql.uhserver.com/ads_aula?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "alunoads2025";
    private static final String SENHA = "@AdS20251";
    public static Connection conectar() {
        try {
            
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados: " + e.getMessage(), e);
        }
    }
}
