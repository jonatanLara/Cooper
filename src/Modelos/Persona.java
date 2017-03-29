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
public class Persona {
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
}
