package com.bootcamp.pizzeria.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @NotEmpty(message = "El campo nombre no puede estar vacio")
	@Size(min = 4, max = 255, message = "El campo nombre tiene que tener entre 4 y 255 caracteres" )
    private String nombre;

    private String foto;

    @Min( value = 0, message = "El precio no puede ser negativo")
	private double precio;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pizza")
    private List<Comentario> comentarios;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pizza")
    private List<Ingrediente> ingredientes;

    public Pizza() {}

    public Pizza(long id,
            @NotEmpty(message = "El campo nombre no puede estar vacio") @Size(min = 4, max = 255, message = "El campo nombre tiene que tener entre 4 y 255 caracteres") String nombre,
            String foto, @Min(value = 0, message = "El precio no puede ser negativo") double precio,
            List<Comentario> comentarios, List<Ingrediente> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.precio = precio;
        this.comentarios = comentarios;
        this.ingredientes = ingredientes;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    
    
}
