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
public class Nivel {
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
  
  
}
