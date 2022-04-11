package com.bootcamp.pizzeria.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 4L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "El campo nombre no puede estar vacio")
	@Size(min = 4, max = 255, message = "El campo nombre tiene que tener entre 4 y 255 caracteres" )
    private String nombre;

    @NotEmpty(message = "El campo email no puede estar vacio")
	@Size(min = 10, max = 255, message = "El campo email tiene que tener entre 4 y 255 caracteres" )
    private String email;

    @NotEmpty(message = "El campo apellidos no puede estar vacio")
	@Size(min = 4, max = 255, message = "El campo apellidos tiene que tener entre 4 y 255 caracteres" )
    private String apellidos;

    @NotEmpty(message = "El campo password no puede estar vacio")
	@Size(min = 4, max = 255, message = "El campo password tiene que tener entre 4 y 255 caracteres" )
    private String password;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "usuario")
    private List<Comentario> comentarios;

    public Usuario() {
        super();
    }

    

    public Usuario(long id,
            @NotEmpty(message = "El campo nombre no puede estar vacio") @Size(min = 4, max = 255, message = "El campo nombre tiene que tener entre 4 y 255 caracteres") String nombre,
            @NotEmpty(message = "El campo email no puede estar vacio") @Size(min = 10, max = 255, message = "El campo email tiene que tener entre 4 y 255 caracteres") String email,
            @NotEmpty(message = "El campo apellidos no puede estar vacio") @Size(min = 4, max = 255, message = "El campo apellidos tiene que tener entre 4 y 255 caracteres") String apellidos,
            @NotEmpty(message = "El campo password no puede estar vacio") @Size(min = 4, max = 255, message = "El campo password tiene que tener entre 4 y 255 caracteres") String password,
            List<Comentario> comentarios) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.apellidos = apellidos;
        this.password = password;
        this.comentarios = comentarios;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    

}
