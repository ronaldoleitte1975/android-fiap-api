package br.com.ronaldo.androidfiapapi.service;

import org.springframework.stereotype.Service;

import br.com.ronaldo.androidfiapapi.domain.Pedido;
import br.com.ronaldo.androidfiapapi.dto.PedidoCreateRequestDTO;

@Service
public interface PedidoService {

	public Pedido create(PedidoCreateRequestDTO pedidoRequestDTO);

	public Pedido findByIdPedido(Long idPedido);

}
