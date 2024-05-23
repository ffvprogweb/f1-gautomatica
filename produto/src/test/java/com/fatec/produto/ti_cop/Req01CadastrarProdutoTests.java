package com.fatec.produto.ti_cop;



import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fatec.produto.model.Produto;

class Req01CadastrarProdutoTests {

    @Test
    void testDescricaoVazia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("", "Categoria válida", "22.30", "10");
        });

        String expectedMessage = "A descrição não deve estar em branco";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCategoriaVazia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Descrição válida", "", "22.30", "10");
        });

        String expectedMessage = "A categoria não deve estar em branco";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCustoInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Descrição válida", "Categoria válida", "-1", "10");
        });

        String expectedMessage = "O custo deve ser maior que zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testQuantidadeInvalida() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Descrição válida", "Categoria válida", "22.30", "-1");
        });

        String expectedMessage = "A quantidade no estoque deve ser maior que zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}