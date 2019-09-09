package br.com.ronaldo.androidfiapapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ronaldo.androidfiapapi.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public Optional<Produto> findByProduto(String sku);

}
