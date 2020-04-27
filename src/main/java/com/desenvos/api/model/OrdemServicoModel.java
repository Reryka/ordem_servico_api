package com.desenvos.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.desenvos.domain.model.StatusOrdemServico;

public class OrdemServicoModel {

	private Long id;
	private ClienteModel cliente;
	private String descricao;
	private BigDecimal preco;
	private StatusOrdemServico status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFechamento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public StatusOrdemServico getStatus() {
		return status;
	}
	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}
	public OffsetDateTime getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(OffsetDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public OffsetDateTime getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(OffsetDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	
}
