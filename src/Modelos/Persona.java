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

/**
 *
 * @author rodrigososa
 */
public class Persona {
  public static final String TABLA_PERSONA = "persona";
  public static final String ID_PERSONA = "id";
  public static final String NOMBRE = "nombre";
  public static final String APELLIDO = "apellido";
  public static final String CORREO = "correo";
  public static final String ID_BANNER = "id_banner";
  public static final String CREADO = "creado";
  
  private Integer id = 0;
  private String nombre = "";
  private String apellido = "";
  private String correo = "";
  private String idBanner = "";
  private LocalDate creado = null;

  public Persona() {
  }
  
  public Persona(Integer id, String nombre, String apellido, String correo, String idBanner, LocalDate creado) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.idBanner = idBanner;
    this.creado = creado;
  }
  
  public Persona(String nombre, String apellido, String correo, String idBanner, LocalDate creado) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.idBanner = idBanner;
    this.creado = creado;
  }
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getIdBanner() {
    return idBanner;
  }

  public void setIdBanner(String idBanner) {
    this.idBanner = idBanner;
  }

  public LocalDate getCreado() {
    return creado;
  }

  public void setCreado(LocalDate creado) {
    this.creado = creado;
  }

  @Override
  public String toString() {
    return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", idBanner=" + idBanner + ", created=" + creado + '}';
  }
  
  public long crearPersona(Persona persona, DatabaseConnection databaseConnection) throws SQLException {
    String query = "INSERT INTO " + TABLA_PERSONA + '('
            + NOMBRE + ','
            + APELLIDO + ','
            + CORREO + ','
            + ID_BANNER + ','
            + CREADO
            + ')'
            + " VALUES(?,?,?,?,?)";

    PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, persona.getNombre());
    preparedStatement.setString(2, persona.getApellido());
    preparedStatement.setString(3, persona.getCorreo());
    preparedStatement.setString(4, persona.getIdBanner());
    preparedStatement.setDate(5, Date.valueOf(persona.getCreado()));

    preparedStatement.executeUpdate();
    ResultSet rs = preparedStatement.getGeneratedKeys();
    if (rs != null && rs.next()) {
      return rs.getLong(1);
    } else {
      return 0;
    }
  }
  
  public long crearPersona(DatabaseConnection databaseConnection) throws SQLException {
    String query = "INSERT INTO " + TABLA_PERSONA + '('
            + NOMBRE + ','
            + APELLIDO + ','
            + CORREO + ','
            + ID_BANNER + ','
            + CREADO
            + ')'
            + " VALUES(?,?,?,?,?)";

    PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, this.getNombre());
    preparedStatement.setString(2, this.getApellido());
    preparedStatement.setString(3, this.getCorreo());
    preparedStatement.setString(4, this.getIdBanner());
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
