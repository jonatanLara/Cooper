/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.time.LocalDate;

/**
 *
 * @author rodrigososa
 */
public class Evento {
  private static final String ID_EVENTO = "id_evento";
  private static final String USUARIO_ID_USUARIO = "usuario_id_usuario";
  private static final String ACCION_ID_ACCION = "accion_id_accion";
  private static final String FECHA = "fecha";
  private static final String CREADO = "creado";

  private Integer id = 0;
  private Integer usuario = 0;
  private Integer accion = 0;
  private LocalDate fecha = null;
  private LocalDate creado = null;

  public Evento() {
  }
  
  public Evento(Integer id, Integer usuario, Integer accion, LocalDate fecha, LocalDate creado) {
    this.id = id;
    this.usuario = usuario;
    this.accion = accion;
    this.fecha = fecha;
    this.creado = creado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUsuario() {
    return usuario;
  }

  public void setUsuario(Integer usuario) {
    this.usuario = usuario;
  }

  public Integer getAccion() {
    return accion;
  }

  public void setAccion(Integer accion) {
    this.accion = accion;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public LocalDate getCreado() {
    return creado;
  }

  public void setCreado(LocalDate creado) {
    this.creado = creado;
  }

  @Override
  public String toString() {
    return "Evento{" + "id=" + id + ", usuario=" + usuario + ", accion=" + accion + ", fecha=" + fecha + ", creado=" + creado + '}';
  }
}