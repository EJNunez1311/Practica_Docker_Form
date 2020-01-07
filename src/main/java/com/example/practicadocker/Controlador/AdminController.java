package com.example.practicadocker.Controlador;

import com.example.practicadocker.Entidad.Formulario;
import com.example.practicadocker.Repositorio.FormRepo;
import com.example.practicadocker.Servicio.FormularioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    FormRepo formRepo;

    @Autowired
    FormularioServices formularioServices;

    @RequestMapping(path = "/admin")
    public ModelAndView  graphs (ModelAndView model){
        /*Map<String, Object> attributes = new HashMap<>();
        attributes.put("pregunta1", formRepo.sumpregunta1());
        attributes.put("pregunta2", formRepo.sumpregunta2());
        attributes.put("pregunta3", formRepo.sumpregunta3());*/

        model.addObject("pregunta1", formRepo.sumpregunta1());
        model.addObject("pregunta2", formRepo.sumpregunta2());
        model.addObject("pregunta3", formRepo.sumpregunta3());

//        System.out.println("Pregunta 1: "+ formRepo.sumpregunta1() +"Pregunta 2: " +formRepo.sumpregunta3());
        model.setViewName("grafica");
        return model;


    }
}
