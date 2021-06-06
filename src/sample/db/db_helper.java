package sample.db;

import sample.models.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class db_helper {

    private static Connection dbConnection;
    private static final db_helper singleton = new db_helper();
    public static db_helper getInstance()
    {
        return singleton;
    }

    public db_helper()
    {
        String url = "jdbc:mysql://localhost:3306.org";
        String user = "root";
        String pass = "JoeriHBO0174";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url,user,pass);
        } catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private void createInitialDatabase() throws IOException, Exception
    {
        try {
            FileReader fileReader = new FileReader(new File("OPT3_19018827_repo/src/sample/db/db_setup.sql"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s;
            while ((s = bufferedReader.readLine()) != null)
            {
                Statement statement = dbConnection.createStatement();
                statement.executeUpdate(s);
            }
        } catch (IOException e)
        {
            System.out.println("Error: Cannot find file: " + e.getMessage());
        }
    }

    public void executeSQLQuery(String query) throws SQLException {
        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public boolean registerPerson(Person person)
    {
        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
            ResultSet checkEmail = statement.executeQuery("SELECT emailAdres FROM person WHERE emailAdres = '" + person.getEmailAdres() + "'");
            int rowCount = 0;
            while (checkEmail.next())
            {
                rowCount++;
            }
            if (rowCount <= 0)
            {
                this.executeSQLQuery("INSERT INTO person (firstName, lastName, emailAdres, passWord, age) VALUES ('" + person.getFirstName() + "', '" + person.getLastName() + "', '" + person.getEmailAdres() + "', '"+ person.getPassWord() + "', '"+ person.getAge() + "'");
            }
            return rowCount <= 0;
        } catch (SQLException e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    public ResultSet getResultSetFromDB(String query) throws SQLException {
        ResultSet result = null;
        try {
            Statement stmt = dbConnection.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
