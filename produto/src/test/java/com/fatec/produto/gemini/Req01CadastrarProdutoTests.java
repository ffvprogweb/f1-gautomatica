package com.fatec.produto.gemini;

import com.fatec.produto.model.Produto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class Req01CadastrarProdutoTests {

	@Test
    void descricaoValidaDeveSerSetada() {
        // Cenário: Setando uma descrição válida
        Produto produto = new Produto();
        String descricaoValida = "Camisa Flanela";

        // Ação: Setando a descrição
        produto.setDescricao(descricaoValida);

        // Validação: Descrição deve ser igual ao valor setado
        assertThat(produto.getDescricao()).isEqualTo(descricaoValida);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void descricaoInvalidaDeveLancarExcecao(String descricaoInvalida) {
        // Cenário: Setando uma descrição inválida
        Produto produto = new Produto();

        // Ação: Tentando setar a descrição inválida
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> produto.setDescricao(descricaoInvalida));
    }
    @Test
    void categoriaValidaDeveSerSetada() {
        // Cenário: Setando uma categoria válida
        Produto produto = new Produto();
        String categoriaValida = "Vestuário";

        // Ação: Setando a categoria
        produto.setCategoria(categoriaValida);

        // Validação: Categoria deve ser igual ao valor setado
        assertThat(produto.getCategoria()).isEqualTo(categoriaValida);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void categoriaInvalidaDeveLancarExcecao(String categoriaInvalida) {
        // Cenário: Setando uma categoria inválida
        Produto produto = new Produto();

        // Ação: Tentando setar a categoria inválida
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> produto.setCategoria(categoriaInvalida));
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void quantidadeValidaDeveSerSetada(int quantidadeValida) {
        // Cenário: Setando uma quantidade válida
        Produto produto = new Produto();

        // Ação: Setando a quantidade
        produto.setQuantidadeNoEstoque(String.valueOf(quantidadeValida));

        // Validação: Quantidade deve ser igual ao valor setado
        assertThat(produto.getQuantidadeNoEstoque()).isEqualTo(quantidadeValida);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-10", "abc", "12.5"})
    void quantidadeInvalidaDeveLancarExcecao(String quantidadeInvalida) {
        // Cenário: Setando uma quantidade inválida
        Produto produto = new Produto();

        // Ação: Tentando setar a quantidade inválida
        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> produto.setQuantidadeNoEstoque(quantidadeInvalida));
    }
    
}
