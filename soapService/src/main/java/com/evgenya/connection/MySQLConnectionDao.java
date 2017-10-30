package com.evgenya.connection;




import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnectionDao {

    private String driver = "com.mysql.jdbc.Driver";
    private static final Properties prop = new Properties();
    static {
        try {
//            prop.load(DBConnection.class.getClassLoader().getResourceAsStream("db-config.properties"));
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db-config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public Connection getConnect(){
             Connection connection = null;
         try {

             connection = DriverManager.getConnection(prop.getProperty("URL"),prop.getProperty("user"), prop.getProperty("password"));
             System.out.print(connection.isClosed());

         }catch (SQLException e) {
             System.err.println(e.getMessage());
         }
         return connection;
     }
    public MySQLConnectionDao() {
        try {
            Class.forName(driver);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
