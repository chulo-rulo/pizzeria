package com.bootcamp.pizzeria.controllers;

import java.util.List;


import com.bootcamp.pizzeria.entities.Pizza;
import com.bootcamp.pizzeria.service.IPizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pizzas")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
    RequestMethod.DELETE })

public class PizzaController {

    @Autowired 
    private IPizzaService pizzaService;

    //http://localhost:7000/pizzas?page=1&size=2
    @GetMapping
    public ResponseEntity<List<Pizza>> getPizzas(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {

        ResponseEntity<List<Pizza>> responseEntity = null;
        List<Pizza> pizzas = null;
        Sort sort = Sort.by("nombre");

        if (page != null && size != null) {

            // Queremos el listado de pizzas por pagina
            Pageable pageable = PageRequest.of(page, size, sort);
            pizzas = pizzaService.findAll(pageable).getContent();

        } else {
            // Solicitamos (request) todas las pizzas
            pizzas = pizzaService.findAll(sort);
        }

        if (pizzas != null) {
            responseEntity = new ResponseEntity<>(pizzas, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

     // Recupera una pizza por ID
     @GetMapping(value = "/{id}")
     public ResponseEntity<Pizza> getPizzaPorId(@PathVariable long id) {
 
         Pizza pizza = pizzaService.findById(id);
         ResponseEntity<Pizza> responseEntity = null;
 
         if (pizza != null) {
             responseEntity = new ResponseEntity<>(pizza, HttpStatus.OK);
         } else {
             responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
 
         return responseEntity;
 
     }
    
}
