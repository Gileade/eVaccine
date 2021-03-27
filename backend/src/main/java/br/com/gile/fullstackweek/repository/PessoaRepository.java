package br.com.gile.fullstackweek.repository;

import br.com.gile.fullstackweek.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
