package br.senai.repository;

import br.senai.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository <Conta, Long> {

    List<Conta> findAll();
}
