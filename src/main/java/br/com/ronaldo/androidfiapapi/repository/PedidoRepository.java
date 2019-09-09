package br.com.ronaldo.androidfiapapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ronaldo.androidfiapapi.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	public Optional<Pedido> findByIdPedido(Long idPedido);
	
}
