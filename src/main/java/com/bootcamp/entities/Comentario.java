package com.bootcamp.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comentario implements Serializable{
    
    private static final long serialVersionUID = 2L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "El campo texto no puede estar vacio")
	@Size(min = 4, max = 255, message = "El campo texto tiene que tener entre 4 y 255 caracteres" )
    private String texto;

    @NotEmpty(message = "El campo puntuacion no puede estar vacio")
	@Size(min = 1, max = 10, message = "El campo texto tiene que tener entre 1 y 10 caracteres" )
    private int puntuacion;

    @NotEmpty(message = "El campo fecha no puede estar vacio")
    private LocalDate fecha;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "comentario")
    private List<Usuario> usuarios;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@NotNull(message = "El comentario tiene que tener una pizza")
	private Pizza pizza;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    
}
