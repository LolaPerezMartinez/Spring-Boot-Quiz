package com.miempresa.quiz_app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "preguntas")
public abstract class Pregunta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String enunciado;
	private boolean activa;
	
	@ManyToOne
	@JoinColumn(name= "tema_id")
	private Tema tema;
	
	//Esto guarda los valores como VF | UNICA | MULTIPLE y no como 0, 1 y 2
	@Enumerated(EnumType.STRING)
	private TipoPregunta tipoPregunta;
	
	//CascadeType.ALL aplica a todas las operaciones CRUD
	//orphanRemoval = true Si quitas un elemento de la lista, Hibernate lo borra de la base de datos.
	//si no lo ponemos mantendria el id y los datos a null
	//DELETE FROM opcion WHERE id = ?
	@OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Respuesta> respuestas = new ArrayList<>();

	
	
	public Pregunta() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEnunciado() {
		return enunciado;
	}


	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}


	public boolean isActiva() {
		return activa;
	}


	public void setActiva(boolean activa) {
		this.activa = activa;
	}


	public Tema getTema() {
		return tema;
	}


	public void setTema(Tema tema) {
		this.tema = tema;
	}


	public TipoPregunta getTipoPregunta() {
		return tipoPregunta;
	}


	public void setTipoPregunta(TipoPregunta tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}


	public List<Respuesta> getRespuestas() {
		return respuestas;
	}


	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	

}
