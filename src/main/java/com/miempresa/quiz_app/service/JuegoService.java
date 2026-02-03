package com.miempresa.quiz_app.service;

import com.miempresa.quiz_app.dto.*;
import java.util.List;

public interface JuegoService {
    OpcionesQuizDTO obtenerOpcionesDisponibles();
    
    PartidaResponse iniciarPartida(Long jugadorId, String nombre, 
                                          List<String> categorias, 
                                          List<String> tipos, 
                                          Integer cantidad);
                                          
    PartidaResponse obtenerPartidaConPreguntas(Long partidaId);
    
    RespuestaResultadoDTO registrarRespuesta(Long partidaId, String preguntaId, List<String> respuestasUsuario);
}