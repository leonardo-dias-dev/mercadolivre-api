package br.com.mercadolivre.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(schema = "mercadolivre", name = "produto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "produto_sequence", schema = "mercadolivre", sequenceName = "produto_sequence", allocationSize = 1)
public class Produto {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_sequence")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 2000)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

}
