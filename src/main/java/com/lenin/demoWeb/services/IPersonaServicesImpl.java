
package com.lenin.demoWeb.services;

import com.lenin.demoWeb.model.Persona;
import com.lenin.demoWeb.repo.IPersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPersonaServicesImpl implements IPersonaServices {
    String mensaje;
    @Autowired
    IPersonaRepo personarepo;
    
    @Override
    public List<Persona> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (List<Persona>) personarepo.findAll();
    }

    @Override
    public void save(Persona persona) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        personarepo.save(persona);
    }

    @Override
    public Persona findOne(Long id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return personarepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        personarepo.deleteById(id);
    }
    
    

   

   
    
    
    
}
