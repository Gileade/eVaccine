package br.com.gile.fullstackweek.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Integer idade;
    private String dataNascimento;
    private Boolean isVacinada;

    @ManyToOne
    @JoinColumn(name = "codigo_grupo_prioritario")
    private GruposPrioritarios grupo;

}
