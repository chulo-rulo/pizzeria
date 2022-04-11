package com.bootcamp.pizzeria.dao;

import java.util.List;

import com.bootcamp.pizzeria.entities.Pizza;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Sort;

@Repository
public interface IPizzaDao extends JpaRepository<Pizza, Long> {

    @Query(value = "select p from Pizza p left join fetch p.ingredientes")
	public List<Pizza> findAll(Sort sort);
    
    @Query(value = "select p from Pizza p left join fetch p.ingredientes",
	 		countQuery = "select count(p) from Pizza p left join p.ingredientes")
	 public Page<Pizza> findAll(Pageable pageable);

     @Query(value = "select p from Pizza p left join fetch p.ingredientes where p.id = :id")
	 public Pizza findById(long id);
}
