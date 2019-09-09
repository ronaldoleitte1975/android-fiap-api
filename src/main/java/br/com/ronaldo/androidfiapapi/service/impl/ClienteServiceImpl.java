package br.com.ronaldo.androidfiapapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ronaldo.androidfiapapi.domain.Cliente;
import br.com.ronaldo.androidfiapapi.dto.ClienteCreateRequestDTO;
import br.com.ronaldo.androidfiapapi.repository.ClienteRepository;
import br.com.ronaldo.androidfiapapi.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente create(ClienteCreateRequestDTO clienteCreateRequestDTO) {

		clienteCreateRequestDTO.setSenha(pe.encode(clienteCreateRequestDTO.getSenha()));
		return clienteRepository.save(new Cliente(clienteCreateRequestDTO));
	}

	@Override
	public Cliente findByEmail(String email) {

		return clienteRepository.findByEmail(email);
	}

}
