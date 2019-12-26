package anma.jdbc.dbs;

import java.sql.*;

public class Connector {

    public static Connection getStatement(String url, String user, String password) throws SQLException {

//        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
//        String user = "hbstudent";
//        String pass = "hbstudent";

        return DriverManager.getConnection(url, user, password);
//                Class.forName("org.postgresql.Driver");

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
