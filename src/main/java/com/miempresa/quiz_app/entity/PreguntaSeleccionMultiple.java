package com.miempresa.quiz_app.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

@Entity
public class PreguntaSeleccionMultiple extends Pregunta{
	
	@ElementCollection
	private List<String> opciones;
	
	@ElementCollection
	private List<String> opcionesCorrectas;
	
	public PreguntaSeleccionMultiple() {
		
	}

	public List<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}

	public List<String> getOpcionesCorrectas() {
		return opcionesCorrectas;
	}

	public void setOpcionesCorrectas(List<String> opcionesCorrectas) {
		this.opcionesCorrectas = opcionesCorrectas;
	}

}
