
package com.Conferencias.Conferencias.Servicio;

import com.Conferencias.Conferencias.Entidades.Ticket;
import com.Conferencias.Conferencias.excepciones.Miexception;
import com.Conferencias.Conferencias.repositorio.ticketRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ticketservicio {
    
    @Autowired
    private ticketRepositorio ticketrepositorio;
    
    @Transactional
    public void crearticket(String nombre,String apellido,String email,int cantidad,int categoria,int total) throws Miexception{
        System.out.println("parametros recibidos en servicio "+nombre+ apellido+ email+ cantidad+categoria+total);
        validar(nombre,apellido,email,cantidad,categoria,total);
        
        Ticket tic = new Ticket();
        
        tic.setNombre(nombre);
        tic.setApellido(apellido);
        tic.setEmail(email);
        tic.setCantidad(cantidad);
        tic.setCategoria(categoria);
       tic.setTotal(total);
        
        System.out.println(tic);
       ticketrepositorio.save(tic);
    }
    
      public List<Ticket> listartickets() {
        List<Ticket> tickets = new ArrayList();

        tickets = ticketrepositorio.findAll();
        return tickets;

    }  
    
    
    
      private void validar(String nombre,String apellido,String email,int cantidad,int categoria,int total)throws Miexception{
        
        

        if (nombre == null || nombre.isEmpty()) {
            throw new Miexception("Debe ingresar su nombre");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new Miexception("Debe ingresar su apellido");
        }
        
         if (email == null || email.isEmpty()) {
            throw new Miexception("Debe ingresar el tema de su conferencia");
        }
        
        if (cantidad <=0|| cantidad >30 ) {
            throw new Miexception("No creo que esa cantidad de ticket desee comprar");
        }
          if (categoria<=0|| categoria>4){
          
           throw new Miexception("Debe ingresar una Categoria valida");
          
      }
          if (total<=1){
              
              throw new Miexception("El total es nulo");
          }
          }
      

}