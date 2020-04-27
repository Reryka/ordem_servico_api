package com.desenvos.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desenvos.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByNome(String nome);
	List<Cliente> findByNomeContaining(String nome);
	Cliente findByemail(String email);
	

}
