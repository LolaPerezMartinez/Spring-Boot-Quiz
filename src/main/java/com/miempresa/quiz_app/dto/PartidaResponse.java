package com.miempresa.quiz_app.dto;

import java.util.List;

public record PartidaResponse(
    Long partidaId,
    Long jugadorId,
    String nombreJugador,
    int aciertos,             
    int totalPreguntas,       
    List<PreguntaDTO> preguntas 
) {
    public PartidaResponse {
        if (partidaId == null) throw new IllegalArgumentException("ID de partida nulo");
        if (jugadorId == null) throw new IllegalArgumentException("ID de jugador nulo");
    }
}