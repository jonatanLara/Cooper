/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Persistencia.DatabaseConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Usuario {
  public static final String TABLA_USUARIO = "usuario";
  public static final String ID_USUARIO = "id";
  public static final String USUARIO = "usuario";
  public static final String CONTRASENA = "contrasena";
  public static final String NIVEL_ID_NIVEL = "nivel";
  public static final String PERSONA_ID_PERSONA = "persona";
  public static final String CREADO = "creado";
  
  private Integer id = 0;
  private String usuario = "";
  private String contrasena = "";
  private Integer nivel = 0;
  private Integer personaId = 0;
  private LocalDate creado = null;

  public Usuario() {
  }
  
  public Usuario(Integer id, String usuario, String contrasena, Integer nivel, Integer personaId, LocalDate creado) {
    this.id = id;
    this.usuario = usuario;
    this.contrasena = contrasena;
    this.nivel = nivel;
    this.personaId = personaId;
    this.creado = creado;
  }
  
  public Usuario(String usuario, String contrasena, Integer nivel, Integer personaId, LocalDate creado) {
    this.usuario = usuario;
    this.contrasena = contrasena;
    this.nivel = nivel;
    this.personaId = personaId;
    this.creado = creado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  public Integer getNivel() {
    return nivel;
  }

  public void setNivel(Integer nivel) {
    this.nivel = nivel;
  }

  public Integer getPersonaId() {
    return personaId;
  }

  public void setPersonaId(Integer personaId) {
    this.personaId = personaId;
  }

  public LocalDate getCreado() {
    return creado;
  }

  public void setCreado(LocalDate creado) {
    this.creado = creado;
  }

  @Override
  public String toString() {
    return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", contrasena=" + contrasena + ", nivel=" + nivel + ", personaId=" + personaId + ", creado=" + creado + '}';
  }
  
  public long crearUsuario(Usuario usuario, DatabaseConnection databaseConnection) throws SQLException {
    String query = "INSERT INTO " + TABLA_USUARIO + '('
            + USUARIO + ','
            + CONTRASENA + ','
            + NIVEL_ID_NIVEL + ','
            + PERSONA_ID_PERSONA + ','
            + CREADO
            + ')'
            + " VALUES(?,?,?,?,?)";
   

    PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, usuario.getUsuario());
    preparedStatement.setString(2, usuario.getContrasena());
    preparedStatement.setInt(3, usuario.getNivel());
    preparedStatement.setInt(4, usuario.getPersonaId());
    preparedStatement.setDate(5, Date.valueOf(usuario.getCreado()));

    preparedStatement.executeUpdate();
    ResultSet rs = preparedStatement.getGeneratedKeys();
    if (rs != null && rs.next()) {
      return rs.getLong(1);
    } else {
      return 0;
    }
  }
  
  public long crearUsuario(DatabaseConnection databaseConnection) throws SQLException {
    String query = "INSERT INTO " + TABLA_USUARIO + '('
            + USUARIO + ','
            + CONTRASENA + ','
            + NIVEL_ID_NIVEL + ','
            + PERSONA_ID_PERSONA + ','
            + CREADO
            + ')'
            + " VALUES(?,?,?,?,?)";
   

    PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, this.getUsuario());
    preparedStatement.setString(2, this.getContrasena());
    preparedStatement.setInt(3, this.getNivel());
    preparedStatement.setInt(4, this.getPersonaId());
    preparedStatement.setDate(5, Date.valueOf(this.getCreado()));

    preparedStatement.executeUpdate();
    ResultSet rs = preparedStatement.getGeneratedKeys();
    if (rs != null && rs.next()) {
      return rs.getLong(1);
    } else {
      return 0;
    }
  }
  
}
