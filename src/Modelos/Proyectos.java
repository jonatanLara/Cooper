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
 * @author Usuario
 */
public class Proyectos {
  public static final String TABLA_PROYECTO = "proyecto";
  public static final String ID_CICLO = "uuid";
  public static final String NOMBRE_PROYECTO = "nombre_proyecto";
  public static final String IMAGAEN = "imagen";
  public static final String NOMBRE_ALUMNO = "nombre_alumno";
  public static final String ID_ALUMNO = "id_banner_alumno";
  public static final String CUATRIMESTRE = "cuatrimestre";
  public static final String CARRERA = "carrera";
  public static final String CONVENIO = "convenio";
  public static final String ASESOR_EMPRESARIAL = "asesorempresarial";
  public static final String ASESOR_ACADEMICO = "asesoracademico";
  public static final String CREADO = "creado";
  
    private String periodo;
    private String nombreProyecto;
    private String imagen;
    private String nombreAlumno;
    private String idbanner;
    private String cuatrimestre;
    private int  carrera;
    private int institucion;
    private LocalDate creado;
    private String asesorEmpresarial;
    private String asesorAcademico;
    
    public Proyectos(){}

    public Proyectos(String periodo, String nombreProyecto, String imagen, String nombreAlumno, String idbanner, String cuatrimestre, int carrera, int institucion, LocalDate creado, String asesorEmpresarial, String asesorAcademico) {
        this.periodo = periodo;
        this.nombreProyecto = nombreProyecto;
        this.imagen = imagen;
        this.nombreAlumno = nombreAlumno;
        this.idbanner = idbanner;
        this.cuatrimestre = cuatrimestre;
        this.carrera = carrera;
        this.institucion = institucion;
        this.creado = creado;
        this.asesorEmpresarial = asesorEmpresarial;
        this.asesorAcademico = asesorAcademico;
    }

    
    
    public long crearPersona(DatabaseConnection databaseConnection) throws SQLException {
    String query = "INSERT INTO " + TABLA_PROYECTO + '('
            + ID_CICLO + ','
            + NOMBRE_PROYECTO + ','
            + IMAGAEN + ','
            + NOMBRE_ALUMNO + ','
            + ID_ALUMNO + ','
            + CUATRIMESTRE + ','
            + CARRERA + ','
            + CONVENIO + ','
            + CREADO + ','
            + ASESOR_EMPRESARIAL + ','
            + ASESOR_ACADEMICO
            + ')'
            + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, this.getPeriodo());
    preparedStatement.setString(2, this.getNombreProyecto());
    preparedStatement.setString(3, this.getImagen());
    preparedStatement.setString(4, this.getNombreAlumno());
    preparedStatement.setString(5, this.getIdbanner());
    preparedStatement.setString(6, this.getCuatrimestre());
    preparedStatement.setInt(7, this.getCarrera());
    preparedStatement.setInt(8, this.getInstitucion());
    preparedStatement.setString(10, this.getAsesorEmpresarial());
    preparedStatement.setString(11, this.getAsesorAcademico());
    preparedStatement.setDate(9, Date.valueOf(this.getCreado()));

    preparedStatement.executeUpdate();
    ResultSet rs = preparedStatement.getGeneratedKeys();
    if (rs != null && rs.next()) {
      return rs.getLong(1);
    } else {
      return 0;
    }
  }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @return the nombreProyecto
     */
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @return the nombreAlumno
     */
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    /**
     * @return the idbanner
     */
    public String getIdbanner() {
        return idbanner;
    }

    /**
     * @return the cuatrimestre
     */
    public String getCuatrimestre() {
        return cuatrimestre;
    }

    /**
     * @return the carrera
     */
    public int getCarrera() {
        return carrera;
    }

    /**
     * @return the institucion
     */
    public int getInstitucion() {
        return institucion;
    }

    /**
     * @return the creado
     */
    public LocalDate getCreado() {
        return creado;
    }

    /**
     * @return the asesorEmpresarial
     */
    public String getAsesorEmpresarial() {
        return asesorEmpresarial;
    }

    /**
     * @return the asesorAcademico
     */
    public String getAsesorAcademico() {
        return asesorAcademico;
    }
    
}
