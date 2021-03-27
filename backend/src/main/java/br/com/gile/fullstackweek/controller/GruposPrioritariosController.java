package br.com.gile.fullstackweek.controller;

import br.com.gile.fullstackweek.domain.GruposPrioritarios;
import br.com.gile.fullstackweek.repository.GruposPrioritariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GruposPrioritariosController {

    @Autowired
    private GruposPrioritariosRepository repository;

    @GetMapping
    public List<GruposPrioritarios> listarTodos(){
        return repository.findAll();
    }

    @GetMapping("{codigo}")
    public GruposPrioritarios buscarPeloCodigo(@PathVariable("codigo") Long codigo){
        return repository.findById(codigo).orElse(null);
    }
}
