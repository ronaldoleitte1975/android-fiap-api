package br.com.ronaldo.androidfiapapi.service;

import org.springframework.stereotype.Service;

import br.com.ronaldo.androidfiapapi.domain.Cliente;
import br.com.ronaldo.androidfiapapi.dto.ClienteCreateRequestDTO;

@Service
public interface ClienteService {

	public Cliente create(ClienteCreateRequestDTO clienteCreateRequestDTO);
	
	public Cliente findByEmail(String email);

}
