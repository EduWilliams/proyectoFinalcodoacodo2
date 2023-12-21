
package com.Conferencias.Conferencias.repositorio;

import com.Conferencias.Conferencias.Entidades.Oradores;
import com.Conferencias.Conferencias.excepciones.Miexception;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
  
public interface Oradoresrepositorio extends JpaRepository<Oradores,String>{
    
   
    
     @Query("SELECT u From Oradores u Where u.email=:email")
    public Oradores buscarporemail(@Param("email")String email);


 
}

