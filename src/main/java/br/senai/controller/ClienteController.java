package br.senai.controller;

import br.senai.model.Cliente;
import br.senai.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.ref.Cleaner;
import java.util.Optional;

@Controller
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/cliente/list")
    public String findAll(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "cliente/list";
    }

    @GetMapping("/cliente/add")
    public String add(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/add";
    }

    @PostMapping("/cliente/save")
    public String save(Cliente cliente, Model model) {
        try {
            clienteService.save(cliente);
            model.addAttribute("cliente", cliente);
            model.addAttribute("isSave", true);
            return "cliente/add";
        } catch (Exception e) {
            model.addAttribute("cliente", cliente);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());

            return "cliente/add";
        }
    }

    @GetMapping("/cliente/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "cliente/edit";
    }

    @GetMapping("/cliente/list/delete{id}")
    public String delete(@PathVariable("id") long id) {
        Optional<Cliente> clienteOpt = clienteService.findById(id);
        if (clienteOpt.isEmpty()) {
            throw new IllegalArgumentException("Pessoa invalida");
        }
        clienteService.delete(clienteOpt.get());
        return "redirect:/cliente/list";

    }
}

