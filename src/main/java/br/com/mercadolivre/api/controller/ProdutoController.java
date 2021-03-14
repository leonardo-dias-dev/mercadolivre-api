package br.com.mercadolivre.api.controller;

import br.com.mercadolivre.api.dto.converter.ProdutoConverter;
import br.com.mercadolivre.api.dto.response.ProdutoResponse;
import br.com.mercadolivre.domain.model.Produto;
import br.com.mercadolivre.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoConverter produtoConverter;

    @GetMapping
    public List<ProdutoResponse> listar(@RequestParam(required = false, defaultValue = "") String nome) {
        List<Produto> produtos = produtoService.listar(nome);

        return produtoConverter.toCollectionResponse(produtos);
    }

}
