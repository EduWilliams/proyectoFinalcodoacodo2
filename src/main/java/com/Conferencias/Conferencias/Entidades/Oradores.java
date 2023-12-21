
package com.Conferencias.Conferencias.Entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
@Entity
public class Oradores {
  
    
   
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    
   
    private String nombre;
    private String Apellido;
    private String email;
    private String tema;
    @Temporal(TemporalType.DATE)
    private  Date fechainscripcion;

    public Oradores() {
    }

    public Oradores(String id, String nombre, String Apellido, String email, String tema, Date fechainscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.email = email;
        this.tema = tema;
        this.fechainscripcion = fechainscripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    @Override
    public String toString() {
        return "Oradores{" + "id=" + id + ", nombre=" + nombre + ", Apellido=" + Apellido + ", email=" + email + ", tema=" + tema + ", fechainscripcion=" + fechainscripcion + '}';
    }

    
    

    
}
