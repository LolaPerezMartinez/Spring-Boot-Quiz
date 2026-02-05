package com.miempresa.quiz_app.model.mysql.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    // Relación con partidas: Un jugador tiene muchas partidas
    // 'mappedBy' debe coincidir con el nombre del campo 'jugador' en la clase Partida
    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)
    private List<Partida> partidas;

    public Jugador() {}

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; } // Añadido setter de ID

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Partida> getPartidas() { return partidas; }
    public void setPartidas(List<Partida> partidas) { this.partidas = partidas; }
}