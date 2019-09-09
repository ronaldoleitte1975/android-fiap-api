package br.com.ronaldo.androidfiapapi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.ronaldo.androidfiapapi.controller.exception.ResponseError;
import br.com.ronaldo.androidfiapapi.domain.Cliente;
import br.com.ronaldo.androidfiapapi.domain.ItemPedido;
import br.com.ronaldo.androidfiapapi.domain.ItemPedidoPK;
import br.com.ronaldo.androidfiapapi.domain.Pedido;
import br.com.ronaldo.androidfiapapi.domain.Produto;
import br.com.ronaldo.androidfiapapi.dto.PedidoCreateRequestDTO;
import br.com.ronaldo.androidfiapapi.dto.ProdutoDTO;
import br.com.ronaldo.androidfiapapi.repository.ClienteRepository;
import br.com.ronaldo.androidfiapapi.repository.ItemPedidoRepository;
import br.com.ronaldo.androidfiapapi.repository.PedidoRepository;
import br.com.ronaldo.androidfiapapi.repository.ProdutoRepository;
import br.com.ronaldo.androidfiapapi.security.UserSS;
import br.com.ronaldo.androidfiapapi.service.PedidoService;
import br.com.ronaldo.androidfiapapi.service.UserService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public Pedido create(PedidoCreateRequestDTO pedidoRequestDTO) {

		Cliente cliente = clienteRepository.findByEmail(pedidoRequestDTO.getEmail());

		UserSS user = UserService.authenticated();

		if (cliente != null) {
			if (user == null) {
				throw new ResponseError(HttpStatus.UNAUTHORIZED, "Acesso negado.");
			}
		} else {

			throw new ResponseError(HttpStatus.UNAUTHORIZED, "E-mail não localizado.");
		}

		List<ItemPedido> itensPedido = validaItensDaRequest(pedidoRequestDTO.getItens());

		if (itensPedido.size() > 0) {

			Pedido pedidoCriado = pedidoRepository
					.save(new Pedido(null, new Date(System.currentTimeMillis()), cliente, "NOVO", null, null));

			itensPedido.stream().forEach(item -> item.getIdItem().setPedido(pedidoCriado));

			itemPedidoRepository.saveAll(itensPedido);

			pedidoCriado.setItens(itensPedido);

			return pedidoCriado;

		} else {
			throw new ResponseError(HttpStatus.UNPROCESSABLE_ENTITY, "Falha na validação dos itens do pedido.");
		}

	}

	@Transactional
	private List<ItemPedido> validaItensDaRequest(List<ProdutoDTO> itens) {

		List<ItemPedido> itensPedido = new ArrayList<>();

		for (ProdutoDTO produtoDTO : itens) {
			Optional<Produto> produtoDB = produtoRepository.findByProduto(produtoDTO.getSku());

			if (!produtoDB.isPresent()) {
				throw new ResponseError(HttpStatus.UNPROCESSABLE_ENTITY,
						"Não é possível realizar o pedido pois um ou mais produtos informados não encontrado.");
			} else if (produtoDB.get().getQtde() < produtoDTO.getQtde() || produtoDB.get().getQtde() == 0) {
				throw new ResponseError(HttpStatus.UNPROCESSABLE_ENTITY,
						"Não é possível realizar o pedido pois um ou mais produtos informados não possui saldo suficiente em estoque.");
			} else {
				produtoDB.get().setQtde(produtoDB.get().getQtde() - produtoDTO.getQtde());
				produtoRepository.save(produtoDB.get());

				ItemPedidoPK itemId = new ItemPedidoPK(null, produtoDB.get());
				ItemPedido itemPedido = new ItemPedido(itemId, produtoDTO.getSku(), produtoDTO.getQtde(),
						produtoDB.get().getPreco(), (produtoDTO.getQtde() * produtoDB.get().getPreco()));

				itensPedido.add(itemPedido);
			}
		}

		return itensPedido;
	}

	@Override
	public Pedido findByIdPedido(Long idPedido) {
		return pedidoRepository.findByIdPedido(idPedido).get();
	}

}
