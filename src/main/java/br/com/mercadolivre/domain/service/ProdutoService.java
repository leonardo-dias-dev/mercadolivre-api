package br.com.mercadolivre.domain.service;

import br.com.mercadolivre.domain.model.Produto;
import br.com.mercadolivre.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listar(String nome) {
        return produtoRepository.findAllByNomeContainingIgnoreCase(nome);
    }

}
