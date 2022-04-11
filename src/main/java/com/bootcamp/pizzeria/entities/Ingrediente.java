package com.bootcamp.pizzeria.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ingrediente implements Serializable{

    private static final long serialVersionUID = 3L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "El campo nombre no puede estar vacio")
	@Size(min = 4, max = 255, message = "El campo nombre tiene que tener entre 4 y 255 caracteres" )
    private String nombre;

    @Min( value = 0, message = "El precio no puede ser negativo")
	private double precio;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@NotNull(message = "El ingrediente tiene que tener una pizza")
	private Pizza pizza;

    public Ingrediente() {
        super();
    }

    

    public Ingrediente(long id,
            @NotEmpty(message = "El campo nombre no puede estar vacio") @Size(min = 4, max = 255, message = "El campo nombre tiene que tener entre 4 y 255 caracteres") String nombre,
            @Min(value = 0, message = "El precio no puede ser negativo") double precio,
            @NotNull(message = "El ingrediente tiene que tener una pizza") Pizza pizza) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.pizza = pizza;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    
    
    
}
