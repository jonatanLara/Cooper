/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelos.Nivel;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rodrigososa
 */
public class OperacionNivel {
  private DatabaseConnection databaseConnection = null;

  public OperacionNivel(DatabaseConnection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }
  
  public Integer crearNivel(Nivel nivel) throws SQLException {
    String query = "INSERT INTO " + AtributoNivel.TABLA_NIVEL + '('
            + AtributoNivel.NIVEL + ','
            + AtributoNivel.CREADO + ')';
    PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setInt(1, nivel.getNivel());
    preparedStatement.setDate(2, Date.valueOf(nivel.getCreado()));
    
    preparedStatement.executeUpdate();
    ResultSet resultSet = preparedStatement.getGeneratedKeys();

    if (resultSet != null && resultSet.next()) {
      return resultSet.getInt(1);
    } else {
      return 0;
    }
  }
  
}
