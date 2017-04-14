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
import java.util.ArrayList;

/**
 *
 * @author rodrigososa
 */
public class Nivel {

  public static final String TABLA_NIVEL = "nivel";
  public static final String ID = "id";
  public static final String NIVEL = "nivel";
  public static final String CREADO = "creado";

  private Integer id = 0;
  private Integer nivel = 0;
  private LocalDate creado = null;

  public Nivel() {
  }

  public Nivel(Integer id, Integer nivel, LocalDate creado) {
    this.id = id;
    this.nivel = nivel;
    this.creado = creado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getNivel() {
    return nivel;
  }

  public void setNivel(Integer nivel) {
    this.nivel = nivel;
  }

  public LocalDate getCreado() {
    return creado;
  }

  public void setCreado(LocalDate creado) {
    this.creado = creado;
  }

  @Override
  public String toString() {
    return "Nivel{" + "id=" + id + ", nivel=" + nivel + ", creado=" + creado + '}';
  }

  public Integer crearNivel(Nivel nivel, DatabaseConnection databaseConnection) throws SQLException {
    String query = "INSERT INTO " + TABLA_NIVEL + '('
            + NIVEL + ','
            + CREADO + ')';
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

  public ArrayList<Nivel> obtenerNiveles(DatabaseConnection databaseConnection) throws SQLException {
    ArrayList<Nivel> niveles = new ArrayList<>();
    String query = "SELECT * FROM " + TABLA_NIVEL;
    PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(query);
    ResultSet resultSet = preparedStatement.executeQuery();
    if (resultSet != null) {
      //resultSet.next();
        resultSet.beforeFirst();
      while (resultSet.next()) {
        Nivel nivel = new Nivel(
                resultSet.getInt(ID),
                resultSet.getInt(NIVEL),
                resultSet.getDate(CREADO).toLocalDate()
        );
        niveles.add(nivel);
      }
      return niveles;
    } else {
      return null;
    }

  }
}
