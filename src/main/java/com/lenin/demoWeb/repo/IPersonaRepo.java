/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenin.demoWeb.repo;

import com.lenin.demoWeb.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lmanrique
 */
public interface IPersonaRepo extends JpaRepository<Persona,Long> {
    
  
}
