package sample.db;

import sample.models.Guest;
import sample.models.Hotel;
import sample.models.Person;
import sample.models.Room;

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
        String url = "jdbc:mysql://localhost:3306/hotel_db";
        String user = "root";
        String pass = "JoeriHBO0174";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to the database");
            dbConnection = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
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

    public boolean registerPerson(Guest person)
    {
        try {
            Statement statement = dbConnection.createStatement();
            String query = "SELECT emailAdres FROM person WHERE emailAdres = '" + person.getEmailAdres() + "'";
            ResultSet result;
            result = statement.executeQuery(query);
            System.out.println("Query to check if the emailadres is already is used, executed!");
            int rowCount = 0;
            while (result.next())
            {
                rowCount++;
            }
            if (rowCount <= 0)
            {
                this.executeSQLQuery("INSERT INTO person (id, firstName, lastName, emailAdres, passWord, age) VALUES (" + person.getId()+ ", '" + person.getFirstName() + "', '" + person.getLastName() + "', '" + person.getEmailAdres() + "', '"+ person.getPassWord() + "', "+ person.getAge());
                System.out.println("SQL query executed!");
            }
            return rowCount <= 0;
        } catch (SQLException e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    public boolean verifyLogin(String emailAdres, String passWord)
    {
        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT emailAdres FROM person WHERE emailAdres = '" + emailAdres + "' AND passWord = '" + passWord + "'");
            int rowCount = 0;
            while (resultSet.next()) {
                rowCount++;
            }
            if (rowCount>0) {
                System.out.println("Inloggen succesvol!");
                return true;
            } else {
                System.out.println("Inloggen mislukt...");
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

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
