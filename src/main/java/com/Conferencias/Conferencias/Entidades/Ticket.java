
package com.Conferencias.Conferencias.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Ticket {
    @Id
     @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    
    private String nombre;
    private String apellido;
    private String email;
    private int cantidad;
    private int categoria;
    private int total;

    public Ticket() {
    }

    public Ticket(String id, String nombre, String apellido, String email, int cantidad, int categoria, int total) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.total = total;
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
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", cantidad=" + cantidad + ", categoria=" + categoria + ", total=" + total + '}';
    }

   
  
  



    


    
    
    
    
}
