/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelos.Usuario;
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
public class OperacionUsuario {

  private DatabaseConnection databaseConnection = null;

  public OperacionUsuario(DatabaseConnection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public Integer crearUsuario(Usuario usuario) throws SQLException {
    String query = "INSERT INTO " + AtributoUsuario.TABLA_USUARIO + '('
            + AtributoUsuario.USUARIO + ','
            + AtributoUsuario.CONTRASENA + ','
            + AtributoUsuario.NIVEL_ID_NIVEL + ','
            + AtributoUsuario.PERSONA_ID_PERSONA + ','
            + AtributoUsuario.CREADO
            + ')';

    PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, usuario.getUsuario());
    preparedStatement.setString(2, usuario.getContrasena());
    preparedStatement.setInt(3, usuario.getNivel());
    preparedStatement.setInt(4, usuario.getPersonaId());
    preparedStatement.setDate(5, Date.valueOf(usuario.getCreado()));

    preparedStatement.executeUpdate();
    ResultSet resultSet = preparedStatement.getGeneratedKeys();

    if (resultSet != null && resultSet.next()) {
      return resultSet.getInt(1);
    } else {
      return 0;
    }
  }
}
