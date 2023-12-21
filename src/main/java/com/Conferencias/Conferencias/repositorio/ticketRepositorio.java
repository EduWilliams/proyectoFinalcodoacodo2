
package com.Conferencias.Conferencias.repositorio;


import com.Conferencias.Conferencias.Entidades.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketRepositorio extends JpaRepository<Ticket,String>{
    
   
    
     @Query("SELECT t From Ticket t Where t.email=:email")
    public Ticket buscarporemail(@Param("email")String email);

  
    
   
    
 
    
}
