package com.example.practicadocker.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String index(Model model, Principal principal ){

        model.addAttribute("titulo", "Barcamp");

        //Aqui redirecciono hacia cliente, realiza la creacion pero es invisibl al usuario
        return "redirect:/barcamp/form";
    }
    @RequestMapping("/login")
    public String login(){
        return "newlogin";

    }
    /*public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("newlogin", "error", error);
    }*/
}
