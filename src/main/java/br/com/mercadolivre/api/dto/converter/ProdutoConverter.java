package br.com.mercadolivre.api.dto.converter;

import br.com.mercadolivre.api.dto.response.ProdutoResponse;
import br.com.mercadolivre.domain.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConverter extends AbstractConverter<Produto, ProdutoResponse, Object> {
}
