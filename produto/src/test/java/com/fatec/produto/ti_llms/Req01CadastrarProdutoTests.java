package com.fatec.produto.ti_llms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.fatec.produto.model.Produto;
import com.fatec.produto.service.IProdutoRepository;

@DataJpaTest
class Req01CadastrarProdutoTests {
	@Autowired
	private IProdutoRepository produtoRepository;

	private Produto produto;

	@BeforeEach
	void setUp() {
		produto = new Produto("Descrição válida", "Categoria válida", "10.5", "100");
	}

	// criterio classes de equivalencia - classes validas
	@Test
	void testSaveProduto() {
		Produto savedProduto = produtoRepository.save(produto);
		assertNotNull(savedProduto.getId());
		assertEquals(produto.getDescricao(), savedProduto.getDescricao());
	}

	@Test
	void testFindById() {
		Produto savedProduto = produtoRepository.save(produto);
		Optional<Produto> foundProduto = produtoRepository.findById(savedProduto.getId());
		assertTrue(foundProduto.isPresent());
		assertEquals(savedProduto, foundProduto.get());
	}

	@Test
	void testUpdateProduto() {
		Produto savedProduto = produtoRepository.save(produto);
		savedProduto.setDescricao("Descrição atualizada");
		Produto updatedProduto = produtoRepository.save(savedProduto);
		assertEquals("Descrição atualizada", updatedProduto.getDescricao());
	}

	@Test
	void testDeleteProduto() {
		Produto savedProduto = produtoRepository.save(produto);
		Long produtoId = savedProduto.getId();
		produtoRepository.delete(savedProduto);
		Optional<Produto> deletedProduto = produtoRepository.findById(produtoId);
		assertFalse(deletedProduto.isPresent());
	}

	@Test
	void testFindAll() {
		produtoRepository.save(produto);
		Produto produto2 = new Produto("Outra descrição", "Outra categoria", "20.5", "50");
		produtoRepository.save(produto2);
		Iterable<Produto> produtos = produtoRepository.findAll();
		assertEquals(2, ((Collection<?>) produtos).size());
	}

	// criterio classes de equivalencia - classes invalidas
	@Test
	void testSaveProdutoWithInvalidDescricao() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Produto("", "Categoria válida", "10.5", "100");
		});
	}

	@Test
	void testSaveProdutoWithInvalidCategoria() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Produto("Descrição válida", "", "10.5", "100");
		});
	}

	@Test
	void testSaveProdutoWithInvalidQuantidadeNoEstoque() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Produto("Descrição válida", "Categoria válida", "10.5", "-10");
		});
	}

	@Test
	void testSaveProdutoWithInvalidCusto() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Produto("Descrição válida", "Categoria válida", "-10.5", "100");
		});
	}

}
