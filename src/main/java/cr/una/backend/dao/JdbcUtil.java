package cr.una.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/ejemplo-dao";
    private static final String DB_USER = "ejemplo-dao";
    private static final String DB_PASSWORD = "1234$una";

    private static final Connection dbConnection = getDBConnection();

    public static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = (Connection) DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }
}
