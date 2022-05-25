package br.senai.controller;

import br.senai.model.Cliente;
import br.senai.model.Evento;
import br.senai.service.EventoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventoController {
    @Autowired
    EventoServiceImpl eventoService;

    @GetMapping("/evento/list")
    public String findAll (Model model){
        model.addAttribute("eventos", eventoService.findAll());
        return "evento/list";
    }

    @GetMapping("/evento/add")
    public String add(Model model) {
        model.addAttribute("evento", new Evento());
        return "evento/add";
    }

    @PostMapping("/evento/save")
    public String save(Evento evento, Model model) {
        try {
            eventoService.save(evento);
            model.addAttribute("evento", evento);
            model.addAttribute("isSave", true);
            return "evento/add";
        } catch (Exception e) {
            model.addAttribute("evento", evento);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());

            return "evento/add";
        }
    }



}