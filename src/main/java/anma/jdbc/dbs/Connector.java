package anma.jdbc.dbs;

import java.sql.*;

public class Connector {

    public static Statement getStatement(String url, String user, String password) throws SQLException {

        try (Connection connection =
                     DriverManager.getConnection("jdbc:postgresql://localhost:5433/persons", "andriim", "Porkie")) {

            Class.forName("org.postgresql.Driver");

            return connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

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
