/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenin.demoWeb.services;

import com.lenin.demoWeb.model.Persona;
import java.util.List;

public interface IPersonaServices {

    public List<Persona> findAll();

    public void save(Persona persona);

    public Persona findOne(Long id);

    public void delete(Long id);
     
   
    
}
