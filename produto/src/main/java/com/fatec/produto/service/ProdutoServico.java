package com.fatec.produto.service;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.produto.model.Produto;

@Service
public class ProdutoServico implements IProdutoServico {
    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    IProdutoRepository produtoRepository;

    public List<Produto> consultaProduto() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> cadastrar(Produto produto) {
        logger.info(">>>>>> servico cadastrar produto iniciado ");
        return Optional.ofNullable(produtoRepository.save(produto));
    }

    @Override
    public Optional<Produto> consultarPorId(String id) {
        logger.info(">>>>>> servico consulta por id chamado");
        long codProduto = Long.parseLong(id);
        return produtoRepository.findById(codProduto);
    }

    @Override
    public Optional<Produto> atualizar(Long produtoId, Produto produtoAtualizado) {
        logger.info(">>>>>> servico atualizar informacoes de produto chamado");
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não cadastrado"));
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setQuantidadeNoEstoque(String.valueOf(produtoAtualizado.getQuantidadeNoEstoque()));
        produto.setCusto(Double.toString(produtoAtualizado.getCusto()));
        return Optional.ofNullable(produtoRepository.save(produto));
    }

    @Override
    public void excluir(String id) {
        long codProduto = Long.parseLong(id);
        produtoRepository.deleteById(codProduto);
    }

    @Override
    public Double estoqueImobilizado() {
        logger.info(">>>>>> servico imobilizado =>");
        return produtoRepository.calcularTotalCustoQuantidade();
    }
}