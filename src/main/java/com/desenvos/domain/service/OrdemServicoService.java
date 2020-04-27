package com.desenvos.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desenvos.domain.exeception.EntidadeNaoEncontradaException;
import com.desenvos.domain.exeception.NegocioException;
import com.desenvos.domain.model.Cliente;
import com.desenvos.domain.model.Comentario;
import com.desenvos.domain.model.OrdemServico;
import com.desenvos.domain.model.StatusOrdemServico;
import com.desenvos.domain.repository.ClienteRepository;
import com.desenvos.domain.repository.ComentarioRepository;
import com.desenvos.domain.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	
	@Autowired
	public OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	public ClienteRepository clienteRepository;
	
	@Autowired
	public ComentarioRepository comentarioRepository;
	
	public OrdemServico incluir(OrdemServico ordemServico) {
		
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado."));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
	}
	
	public void finalizar(Long ordemServicoId){
		OrdemServico ordemServico = BuscarOrdemServico(ordemServicoId);
		
		ordemServico.finalizar();
		
		ordemServicoRepository.save(ordemServico);
	}


	
	public Comentario incluirComentario(Long ordemServicoId, String descricao) {
		
		OrdemServico ordemServico = BuscarOrdemServico(ordemServicoId);
		
		Comentario comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);
		
		return comentarioRepository.save(comentario);
	}
	
	private OrdemServico BuscarOrdemServico(Long ordemServicoId) {
		return ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada"));
	}
}
