import java.sql.*;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //sql properties
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";

        //query
        String query = "select first_name from student where roll_number = 1";

        //Load and Register a driver
        Class.forName("com.mysql.jdbc.Driver");

        //establish the connection
        Connection connection = DriverManager.getConnection(url, username, password);

        //build the query
        Statement statement = connection.createStatement();

        //process the result
        ResultSet resultSet = statement.executeQuery(query);

        //read the result
        resultSet.next();
        System.out.println(resultSet.getString("first_name"));

        //close the connection
        statement.close();
        connection.close();

    }
}
