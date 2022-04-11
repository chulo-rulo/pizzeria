package com.bootcamp.pizzeria.dao;

import java.util.List;

import com.bootcamp.pizzeria.entities.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Sort;

@Repository
public interface IComentarioDao extends JpaRepository<Comentario, Long>{

    /* @Query(value = "select p from Pizza p left join fetch p.presentacion")
	public List<Comentario> findAll(Sort sort); */
    
}
