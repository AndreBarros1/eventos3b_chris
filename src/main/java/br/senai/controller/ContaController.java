package br.senai.controller;

import br.senai.service.ClienteServiceImpl;
import br.senai.service.ContaServiceImpl;
import br.senai.service.EventoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ContaController {

    @Autowired
    ContaServiceImpl contaService;

    @GetMapping("/conta/signup")
    public String findAll (Model model){
        model.addAttribute("conta", contaService.findAll());
        return "conta/signup";
    }



}
