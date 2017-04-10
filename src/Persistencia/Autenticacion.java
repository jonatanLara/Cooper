/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Autenticacion {
  public boolean autenticar(String usuario, String contrasena, DatabaseConnection databaseConnection) throws SQLException {
    String query = "SELECT * FROM " + Usuario.TABLA_USUARIO
            + " WHERE "
            + Usuario.USUARIO 
            + '=' + '\"' + usuario + '\"'
            + " AND "
            + Usuario.CONTRASENA
            + '=' + '\"' + contrasena + '\"';
    
    PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(query);
    ResultSet resultSet = preparedStatement.executeQuery();
    
    return resultSet != null && resultSet.next();  
  }
}
