package br.com.gile.fullstackweek.controller;

import br.com.gile.fullstackweek.domain.Pessoa;
import br.com.gile.fullstackweek.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = {"http://localhost:3000"})
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public List<Pessoa> listarTodos(){
        return repository.findAll();
    }

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa){
        return repository.save(pessoa);
    }

    @PutMapping("{codigo}")
    public Pessoa atualizar(@PathVariable("codigo") Long codigo, @RequestBody Pessoa pessoa){
        return repository.findById(codigo).map(
                record -> {
                    record.setCpf(pessoa.getCpf());
                    record.setDataNascimento(pessoa.getDataNascimento());
                    record.setEmail(pessoa.getEmail());
                    record.setIdade(pessoa.getIdade());
                    record.setNome(pessoa.getNome());
                    record.setTelefone(pessoa.getTelefone());
                    record.setIsVacinada(pessoa.getIsVacinada());
                    return repository.save(record);
                }
        ).orElse(null);
    }

    @GetMapping("{codigo}")
    public Pessoa buscarPeloCodigo(@PathVariable("codigo") Long codigo){
        return repository.findById(codigo).orElse(null);
    }
}
