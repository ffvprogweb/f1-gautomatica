package com.fatec.produto.ti_cop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.fatec.produto.model.Produto;
@DataJpaTest

class Req01CadastrarProdutoTests {


    @Test
    public void testSetId() {
        Produto produto = new Produto();
        produto.setId(1L);
        assertEquals(1L, produto.getId());
    }

    @Test
    public void testSetDescricaoValida() {
        Produto produto = new Produto();
        produto.setDescricao("Produto válido");
        assertEquals("Produto válido", produto.getDescricao());
    }

    @Test
    public void testSetDescricaoNula() {
        Produto produto = new Produto();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            produto.setDescricao(null);
        });
        assertEquals("A descrição não deve estar em branco", exception.getMessage());
    }

    @Test
    public void testSetDescricaoEmBranco() {
        Produto produto = new Produto();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            produto.setDescricao("");
        });
        assertEquals("A descrição não deve estar em branco", exception.getMessage());
    }

    @Test
    public void testSetCategoria() {
        Produto produto = new Produto();
        produto.setCategoria("Categoria válida");
        assertEquals("Categoria válida", produto.getCategoria());
    }


}
