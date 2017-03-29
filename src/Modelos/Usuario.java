/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.time.LocalDate;

public class Usuario {
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
  
  
}
