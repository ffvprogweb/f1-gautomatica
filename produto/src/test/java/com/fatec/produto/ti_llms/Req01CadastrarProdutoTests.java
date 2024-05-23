package com.fatec.produto.ti_llms;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fatec.produto.model.Produto;

public class Req01CadastrarProdutoTests {

    // Testes para a descrição
    @Test
    void testDescricaoValida() {
        Produto produto = new Produto();
        produto.setDescricao("Descrição válida");
        assertEquals("Descrição válida", produto.getDescricao());
    }

    @Test
    void testDescricaoInvalida() {
        Produto produto = new Produto();
        assertThrows(IllegalArgumentException.class, () -> produto.setDescricao(null));
        assertThrows(IllegalArgumentException.class, () -> produto.setDescricao(""));
        assertThrows(IllegalArgumentException.class, () -> produto.setDescricao(" "));
    }

    // Testes para a categoria
    @Test
    void testCategoriaValida() {
        Produto produto = new Produto();
        produto.setCategoria("Categoria válida");
        assertEquals("Categoria válida", produto.getCategoria());
    }

    @Test
    void testCategoriaInvalida() {
        Produto produto = new Produto();
        assertThrows(IllegalArgumentException.class, () -> produto.setCategoria(null));
        assertThrows(IllegalArgumentException.class, () -> produto.setCategoria(""));
        assertThrows(IllegalArgumentException.class, () -> produto.setCategoria(" "));
    }

    // Testes para a quantidade no estoque
    @Test
    void testQuantidadeNoEstoqueValida() {
        Produto produto = new Produto();
        produto.setQuantidadeNoEstoque("10");
        assertEquals(10, produto.getQuantidadeNoEstoque());
    }

    @Test
    void testQuantidadeNoEstoqueInvalida() {
        Produto produto = new Produto();
        assertThrows(IllegalArgumentException.class, () -> produto.setQuantidadeNoEstoque("-1"));
        assertThrows(IllegalArgumentException.class, () -> produto.setQuantidadeNoEstoque("abc"));
        assertThrows(IllegalArgumentException.class, () -> produto.setQuantidadeNoEstoque(" "));
    }

    // Testes para o custo
    @Test
    void testCustoValido() {
        Produto produto = new Produto();
        produto.setCusto("10.5");
        assertEquals(10.5, produto.getCusto());
    }

    @Test
    void testCustoInvalido() {
        Produto produto = new Produto();
        assertThrows(IllegalArgumentException.class, () -> produto.setCusto("-1.0"));
        assertThrows(IllegalArgumentException.class, () -> produto.setCusto("0"));
        assertThrows(IllegalArgumentException.class, () -> produto.setCusto("abc"));
        assertThrows(IllegalArgumentException.class, () -> produto.setCusto(" "));
    }
}
