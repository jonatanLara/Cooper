/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelos.Persona;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigososa
 */
public class OperacionPersona {
  private DatabaseConnection databaseConnection = null;

  public OperacionPersona(DatabaseConnection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }
  
  public Integer crearPersona(Persona persona) throws SQLException {
    String query = "INSERT INTO " + AtributoPersona.TABLA_PERSONA + '('
            + AtributoPersona.NOMBRE + ','
            + AtributoPersona.APELLIDO + ','
            + AtributoPersona.CORREO + ','
            + AtributoPersona.ID_BANNER + ','
            + AtributoPersona.CREADO + 
            ')';
    PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, persona.getNombre());
    preparedStatement.setString(2, persona.getApellido());
    preparedStatement.setString(3, persona.getCorreo());
    preparedStatement.setString(4, persona.getIdBanner());
    preparedStatement.setDate(5, Date.valueOf(persona.getCreado()));
    
    preparedStatement.executeUpdate();
    ResultSet resultSet = preparedStatement.getGeneratedKeys();

    if (resultSet != null && resultSet.next()) { 
      return resultSet.getInt(1);
    } else {
      return 0;
    }
  }
}
