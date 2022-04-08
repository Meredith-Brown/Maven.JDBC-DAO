package daos;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import driver if issues

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/JDBCLab";
    public static final String USER = "meredith";
    public static final String PASS = "m3r-C0desWilm";

    public static Connection getConnection() throws SQLException {
        try {
            DriverManager.registerDriver(new Driver() {
                public java.sql.Connection connect(String url, Properties info) throws SQLException {
                    return null;
                }

                public boolean acceptsURL(String url) throws SQLException {
                    return false;
                }

                public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                    return new DriverPropertyInfo[0];
                }

                public int getMajorVersion() {
                    return 0;
                }

                public int getMinorVersion() {
                    return 0;
                }

                public boolean jdbcCompliant() {
                    return false;
                }

                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    return null;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void closeConnection(ConnectionFactory connection) {
        closeConnection(connection);
    }
}

// https://dzone.com/articles/building-simple-data-access-layer-using-jdbc
// * Get a connection to database
// * @return Connection object