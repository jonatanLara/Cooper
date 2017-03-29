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
    connection = DriverManager.getConnection(URL);
  }

  public void openConnection() throws SQLException {
    if (getConnection() != null) {
      getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    } else {
      JOptionPane.showMessageDialog(null, "Debes conectarte a la base de datos primero");
    }
  }

  public void closeConnection() throws SQLException {
    if (getConnection() != null) {
      getConnection().close();
    } else {
      JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexión a base de datos, comunícate con el desarrollador");
    }
  }

  public Connection getConnection() {
    return connection;
  }
}
