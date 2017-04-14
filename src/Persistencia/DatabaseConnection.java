/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {

  private static final String DATABASE_NAME = "proyectos_unid";
  private static final String USER_NAME = "root";
  private static final String PASSWORD = "";
  private static final String URL = "jdbc:mysql://localhost/" + DATABASE_NAME + "?rewriteBatchedStatements=true";
  private Connection connection = null;

  public DatabaseConnection() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
  }
  
  public Connection getConnection() {
    return connection;
  }
  public void closeConnection() throws SQLException {
    if (connection != null) {
      connection.close();
    } else {
      JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexión a base de datos, comunícate con el desarrollador");
    }
  }
  
}
