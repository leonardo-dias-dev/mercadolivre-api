package br.com.mercadolivre.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "mercadolivre", name = "usuario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "usuario_sequence", schema = "mercadolivre", sequenceName = "usuario_sequence", allocationSize = 1)
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

}
