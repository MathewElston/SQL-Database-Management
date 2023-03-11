import java.sql.*;

/*
 * This class is to inject SQL code by dynamically creating SQL statements using easy to read Strings / plain text.
 */
public class SQLDataBase {
    private String tableName;
    private String connectString;
    private String username;
    private String password;

    public SQLDataBase(String tableName, String connectString, String username, String password) {
        this.tableName = tableName;
        this.connectString = connectString;
        this.username = username;
        this.password = password;
    }
    public void insert(String columns[], String values[]) {
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("INSERT INTO ").append(this.tableName).append("(");
        for (int i = 0; i < columns.length; i++) {
            sqlString.append(columns[i]);
            if (i < columns.length -1) {
                sqlString.append(",");
            }
        }
        sqlString.append(") VALUES (");
        for (int i = 0; i < columns.length; i++) {
            sqlString.append("?");
            if (i < values.length - 1) {
                sqlString.append(",");
            }
        }
        sqlString.append(")");

        try {
            Connection connection = DriverManager.getConnection(this.connectString,this.username,this.password);
            System.out.println(sqlString.toString());
            PreparedStatement statement = connection.prepareStatement(sqlString.toString());
            System.out.println(sqlString);
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i+1, values[i]);
            }

            statement.executeUpdate();
            connection.close();            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }   
    }
    public void insert(String column, String value) {
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("INSERT INTO ").append(tableName).append(" (").append(column).append(") VALUES (?)");

        try {
            Connection connection = DriverManager.getConnection(connectString,"root","");
            PreparedStatement statement = connection.prepareStatement(sqlString.toString());
            statement.setString(1, value);
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}