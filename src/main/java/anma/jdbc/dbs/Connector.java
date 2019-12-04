package anma.jdbc.dbs;

import java.sql.*;

public class Connector {

    public Connector() throws SQLException {
    }

    public static Statement getStatement(String url, String user, String password) throws SQLException {

        try (Connection connection =
                     DriverManager.getConnection("jdbc:postgresql://localhost:5433/persons", "andriim", "Porkie")) {

            Class.forName("org.postgresql.Driver");

            Statement statement = connection.createStatement();

            return statement;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ResultSet getResults(Statement statement, String table) {

        try {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table + ")");

            return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
