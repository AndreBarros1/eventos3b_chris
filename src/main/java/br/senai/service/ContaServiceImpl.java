package br.senai.service;

import br.senai.model.Conta;
import br.senai.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContaServiceImpl {

    @Autowired
    ContaRepository contaRepository;


    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

}
