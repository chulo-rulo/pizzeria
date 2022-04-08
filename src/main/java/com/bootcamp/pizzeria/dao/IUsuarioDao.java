package com.bootcamp.pizzeria.dao;

import com.bootcamp.pizzeria.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
    
}
