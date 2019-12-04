package anma.jdbc.dbs;

import java.sql.*;

public class Connector {

    public static Connection getStatement(String url, String user, String password) throws SQLException {

        Connection connection =
                     DriverManager.getConnection("jdbc:postgresql://localhost:5433/persons", "andriim", "Porkie");

            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return connection;
    }

    public static ResultSet getResults(Statement statement, String table) {

        try {

            return statement.executeQuery("SELECT * FROM " + table);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
