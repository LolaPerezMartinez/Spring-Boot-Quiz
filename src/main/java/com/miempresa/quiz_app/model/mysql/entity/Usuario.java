package com.miempresa.quiz_app.model.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	
	//PROVISIONAL
    @Id
    private Long id;
    private String nombre;
    private String email;

    // getters y setters
}