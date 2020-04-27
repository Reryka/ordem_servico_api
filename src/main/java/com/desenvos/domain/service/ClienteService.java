package com.desenvos.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desenvos.domain.exeception.NegocioException;
import com.desenvos.domain.model.Cliente;
import com.desenvos.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente)
	{
		
		Cliente clienteExistente = clienteRepository.findByemail(cliente.getEmail());
		
		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId)
	{
		clienteRepository.deleteById(clienteId);
	}
	

}
