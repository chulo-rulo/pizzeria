package com.bootcamp.pizzeria.service;

import java.util.List;

import com.bootcamp.pizzeria.dao.IPizzaDao;
import com.bootcamp.pizzeria.entities.Pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class IPizzaServiceImpl implements IPizzaService {
    
    @Autowired//busca una variable por tipo IPizzaDao
    private IPizzaDao pizzaDao;
    
    @Override
    public List<Pizza> findAll(Sort sort) {
        return pizzaDao.findAll(sort);
    }

    @Override
    public Page<Pizza> findAll(Pageable pageable) {
        return pizzaDao.findAll(pageable);
    }

    @Override
    public Pizza findById(long id) {
        return pizzaDao.findById(id);
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Pizza save(Pizza producto) {
        return null;
    }
    
}
