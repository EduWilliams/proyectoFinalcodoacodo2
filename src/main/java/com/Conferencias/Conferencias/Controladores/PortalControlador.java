
package com.Conferencias.Conferencias.Controladores;

import com.Conferencias.Conferencias.Entidades.Oradores;
import com.Conferencias.Conferencias.Entidades.Ticket;
import com.Conferencias.Conferencias.Servicio.Oradoresservicio;
import com.Conferencias.Conferencias.Servicio.Ticketservicio;
import com.Conferencias.Conferencias.excepciones.Miexception;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {
    @Autowired
    private Oradoresservicio oradoresservicio;
    @Autowired
    private Ticketservicio ticketservicio;
    @GetMapping("/")
    public String index() {

        return "index.html";
    } 
    
    @GetMapping("/Comprarticket")
    public String Comprarticket(){
        
        
        return "Comprarticket.html";
    }
    @PostMapping("/registrar")
    public String registrar( @RequestParam String nombre,@RequestParam String apellido,@RequestParam String email, @RequestParam String tema, ModelMap modelo) throws Miexception{
        System.out.println(nombre+" "+ apellido+ " "+ email+ " " +tema);
        
        
         try {
           oradoresservicio.crearOrador(nombre, apellido, email, tema);
            modelo.put("exito", "Usuario cargado exitosamente!!!");
        } catch (Miexception ex) {
          
             modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("email", email);
            modelo.put("tema", tema);
            
            
            
            
            return "index.html";
        }

        return "index.html";

    }
       @PostMapping("/guardarticket")
       public String guardarticket(@RequestParam String nombre,@RequestParam String apellido,@RequestParam String email,@RequestParam(required=false) Integer cantidad,@RequestParam(required=false) Integer categoria,ModelMap modelo) throws Miexception{
           System.out.println(nombre+" "+ apellido+ " "+ email+ " " +cantidad+" "+ categoria+ " ");
           int descunitario=0;
            switch(categoria){
      
        case 1:
            descunitario=200*80/100;
           


        break;

        case 2:
            descunitario=200*50/100;
            
        break;



        case 3:
        descunitario=200*15/100;
        
        break;


        case 4:
        descunitario=0;
      
        break;




    }

       

        int precio=200-descunitario;
        
        int total=precio*cantidad;
           System.out.println(nombre+ apellido+ email+ cantidad+categoria+total);
           
           try {
             
          ticketservicio.crearticket(nombre, apellido, email,cantidad,categoria,total);
            modelo.put("exito", "Usuario cargado exitosamente!!!");
           
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!"); {
          
             if((nombre!=null)&&(apellido!=null)&&(email!=null)&&(cantidad!=0)&&(categoria!=0)&&(total!=0)){
                  ticketservicio.crearticket(nombre, apellido, email,cantidad,categoria,total);
                 System.out.println("Estoy en el try del controlador"+nombre+apellido+email+cantidad+categoria+total);
             }else{
              
             }
               System.out.println("Errooooooooooooor");
            
            }
            
            return "index.html";
        
             
                 
          
    
           
       
       }    
        return "index.html";
       }
           
       @GetMapping("/ListadoOradores")
       public String ListadoOradores(ModelMap modelo){
           List<Oradores> oradores = oradoresservicio.listarUsuario();
           
           modelo.addAttribute("oradores", oradores);
           return "ListadoOradores.html";
       }
 
         @GetMapping("/Listadotickets")
         public String Listadotickets(ModelMap modelo){
           List<Ticket> tickets =  ticketservicio.listartickets();
           q
           modelo.addAttribute("tickets", tickets);
        return "Listadotickets.html";
    }
    }
    
    

