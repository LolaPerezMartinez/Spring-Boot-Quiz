package com.miempresa.quiz_app.controller.api;

import com.miempresa.quiz_app.model.mongo.document.Pregunta;
import com.miempresa.quiz_app.service.PreguntaService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {
	
	//NO AUTOWIRED con constructor es mas seguro y actual
    private final PreguntaService preguntaService;

    public PreguntaController(PreguntaService service) {
        this.preguntaService = service;
    }
    /*
     * MultipartFile es el objeto estándar para manejar archivos físicos que vienen desde el exterior.
     */
    @PostMapping("/importar")
    public List<Pregunta> importarPreguntas(@RequestParam("archivo") MultipartFile archivo) {
        return preguntaService.importarDesdeArchivo(archivo);
    }
    
    // Obtener todas las preguntas
    @GetMapping
    public List<Pregunta> obtenerTodas() {
        return preguntaService.obtenerTodas();
    }

    // Obtener pregunta por ID
    @GetMapping("/{id}")
    public Optional<Pregunta> obtenerPorId(@PathVariable String id) {
        return preguntaService.obtenerPorId(id);
    }

    // Obtener preguntas por categoría
    @GetMapping("/categoria/{categoria}")
    public List<Pregunta> obtenerPorCategoria(@PathVariable String categoria) {
        return preguntaService.obtenerPorCategoria(categoria);
    }

    // Obtener preguntas por tipo
    @GetMapping("/tipo/{tipo}")
    public List<Pregunta> obtenerPorTipo(@PathVariable Pregunta.TipoPregunta tipo) {
        return preguntaService.obtenerPorTipo(tipo);
    }

    // Guardar una nueva pregunta
    @PostMapping
    public Pregunta guardarPregunta(@RequestBody Pregunta pregunta) {
        return preguntaService.guardarPregunta(pregunta);
    }

    // Eliminar una pregunta por ID
    @DeleteMapping("/{id}")
    public void eliminarPregunta(@PathVariable String id) {
        preguntaService.eliminarPregunta(id);
    }
}