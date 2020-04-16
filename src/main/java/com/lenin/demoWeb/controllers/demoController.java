package com.lenin.demoWeb.controllers;

import com.lenin.demoWeb.model.Persona;
import com.lenin.demoWeb.repo.IPersonaRepo;
import com.lenin.demoWeb.services.IPersonaServices;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lenin.demoWeb.services.IPersonaServicesImpl;

@Controller
@RequestMapping("/app")
public class demoController {

    String mensajeFlash;
    @Autowired
    IPersonaServices repo;
    
    String result;
    
    Integer result1;
    
    
   // private static final String WS_URL = "http://localhost:8080/WebApplication1/NewWebService?wsdl";
    

    @GetMapping(value = "/listar")
    public String listartodos(Model model){
        
        model.addAttribute("listadoclientes", repo.findAll());

        return "Clientes";
    }


    
    @GetMapping({"/inicio", ""})
    public String Inicio(Model model) throws Exception {
        model.addAttribute("titulo", "Pagina de inicio");
        



//         model.addAttribute("Suma", this.Suma(2, 3));
         
         

        
         return "Inicio";
    }

//public int Suma(int a,int b){    
//int result = 0;
//    try { // Call Web Service Operation
//    com.lenin.demoWeb.services.CalculatorImplService service;
//    service = new com.lenin.demoWeb.services.CalculatorImplService();
//    com.lenin.demoWeb.services.CalculatorI port = service.getCalculatorImplPort();
//    // TODO initialize WS operation arguments here
//    
//    
//     Map<String, Object> req_ctx = ((BindingProvider)port).getRequestContext();
//     req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"https://localhost:8443/prueba/CalculatorImpl?wsdl");
//
//        Map<String, List<String>> headers = new HashMap<String, List<String>>();
//        headers.put("uname", Collections.singletonList("lenin"));
//        headers.put("pass", Collections.singletonList("lenin123"));
//        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
//    
//    
//    
//    
//    
//    
//    
//    
//    
////    Map requestCtx = ((BindingProvider) service).getRequestContext();
////    requestCtx.put(BindingProvider.USERNAME_PROPERTY, "lenin");
////    requestCtx.put(BindingProvider.PASSWORD_PROPERTY, "lenin123");
// 
////    String productionUrl = "https://localhost:8443/prueba/CalculatorImpl?wsdl";
////    requestCtx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, productionUrl);
//    
////    requestCtx.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
////        requestCtx.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
//    
//    
//    int arg0 = a;
//    int arg1 = b;
//    // TODO process result here
//    result = port.add(arg0, arg1);
//  //  System.out.println("Result = "+result);
//} catch (Exception ex) {
//    // TODO handle custom exceptions here
//}
//  return result;
//}

    
    
   

    @GetMapping("/form")
    public String nuevoCliente(Model model) {

        Persona per = new Persona();

        model.addAttribute("personas", per);
        model.addAttribute("titulo", "Ingreso de Clientes Nuevos");

        return "form";

    }

    //METODO PARA GUARDAR
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String Guardar(@Valid Persona per, BindingResult result, Model model, RedirectAttributes flash) {
        String mensajeflash;
        
        List<Persona> list=new ArrayList<Persona>();
        
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de inclusión de clientes");
            return "form";
        }
        list=repo.findAll();
            
        repo.save(per);
        
        if (per != null) {
            mensajeFlash = "Cliente creado con éxito";
        } else {
            mensajeFlash = "Cliente actualizado con éxito";
        }

        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:/form";
    }

    //METODO PARA EDITAR
    @GetMapping(value = "/form/{id}")
    public String Editar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
        Persona persona;

        if (id > 0) {
            persona = this.repo.findOne(id);
            if (persona == null) {
                flash.addFlashAttribute("error", "El id del cliente no existe en la base de datos");
                return "redirect:/listar";
            }
        } else {
            flash.addFlashAttribute("error", "El id del cliente no puede ser cero");
            return "redirect:/listar";
        }
        model.addAttribute("titulo", "Editar cliente");
        model.addAttribute("personas", persona);
        return "form";
    }

    @GetMapping(value = "/eliminar/{id}")
    public String Eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        if (id > 0) {
            this.repo.delete(id);
            flash.addFlashAttribute("success", "Cliente eliminado con éxito");
        }

        return "redirect:/listar";
    }
    
    


    

}
