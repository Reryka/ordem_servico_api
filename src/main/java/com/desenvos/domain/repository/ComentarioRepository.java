package com.desenvos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desenvos.domain.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,	Long> {

}
