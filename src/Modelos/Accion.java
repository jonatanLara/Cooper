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
public class Accion {
  private static final String ID_ACCION = "id_accion";
  private static final String ACCION = "accion";
  private static final String CREADO = "creado";

  private Integer id = 0;
  private Integer accion = 0;
  private LocalDate creado = null;
  
  public Accion() {
  }
  
  public Accion(Integer id, Integer accion, LocalDate creado) {
    this.id = id;
    this.accion = accion;
    this.creado = creado;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAccion() {
    return accion;
  }

  public void setAccion(Integer accion) {
    this.accion = accion;
  }

  public LocalDate getCreado() {
    return creado;
  }

  public void setCreado(LocalDate creado) {
    this.creado = creado;
  }

  @Override
  public String toString() {
    return "Accion{" + "id=" + id + ", accion=" + accion + ", creado=" + creado + '}';
  }
}
