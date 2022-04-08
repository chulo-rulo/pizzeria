package com.bootcamp.pizzeria.dao;

import java.util.List;

import com.bootcamp.pizzeria.entities.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Repository
public interface IPizzaDao extends JpaRepository<Pizza, Long> {

    @Query(value = "select p from Pizza p left join fetch p.ingrediente")
	public List<Pizza> findAll(Sort sort);
    
}
