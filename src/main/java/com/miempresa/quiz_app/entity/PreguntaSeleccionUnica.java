package com.miempresa.quiz_app.entity;


import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

@Entity
public class PreguntaSeleccionUnica extends Pregunta{
	
	@ElementCollection
	private List <String> opciones;
	private String opcionCorrecta;
	
	public PreguntaSeleccionUnica() {
		
	}

	public List<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}

	public String getOpcionCorrecta() {
		return opcionCorrecta;
	}

	public void setOpcionCorrecta(String opcionCorrecta) {
		this.opcionCorrecta = opcionCorrecta;
	}
	
	
	
	

}
