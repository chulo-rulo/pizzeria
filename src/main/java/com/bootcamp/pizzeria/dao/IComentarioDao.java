package com.bootcamp.pizzeria.dao;

import com.bootcamp.pizzeria.entities.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentarioDao extends JpaRepository<Comentario, Long>{
    
}
