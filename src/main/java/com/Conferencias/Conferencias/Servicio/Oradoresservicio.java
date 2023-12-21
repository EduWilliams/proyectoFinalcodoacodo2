
package com.Conferencias.Conferencias.Servicio;

import com.Conferencias.Conferencias.Entidades.Oradores;
import com.Conferencias.Conferencias.excepciones.Miexception;
import com.Conferencias.Conferencias.repositorio.Oradoresrepositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Oradoresservicio {
 @Autowired
   private Oradoresrepositorio oradoresrepositorio;
    
    @Transactional
    public void  crearOrador( String nombre, String apellido, String email, String tema) throws Miexception{
         validar(nombre,apellido,email,tema);
         Oradores ora = new Oradores();
         
        System.out.println("Datos ingresado a servicio orador" +" "+nombre+" "+apellido +"  "+" "+email+" "+tema);
        
       
     
        ora.setNombre(nombre);
        ora.setApellido(apellido);
        ora.setEmail(email);
        ora.setTema(tema);
        ora.setFechainscripcion(new Date());
        
         System.out.println(ora);
        oradoresrepositorio.save(ora);
        
    }
            
           public List<Oradores> listarUsuario() {
        List<Oradores> oradores = new ArrayList();

        oradores = oradoresrepositorio.findAll();
        return oradores;

    }  
    
    private void validar( String nombre,String apellido,String email,String tema)throws Miexception{
        
        

        if (nombre == null || nombre.isEmpty()) {
            throw new Miexception("Debe ingresar su nombre");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new Miexception("Debe ingresar su apellido");
        }
        
         if (email == null || email.isEmpty()) {
            throw new Miexception("Debe ingresar el tema de su conferencia");
        }
        
        
        
         
            if (tema == null || tema.isEmpty()) {
            throw new Miexception("Debe ingresar el tema de su conferencia");
        }
        
    }
   
    
}
