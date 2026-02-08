package com.miempresa.quiz_app.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.miempresa.quiz_app.model.mysql.entity.Jugador;
import com.miempresa.quiz_app.repository.mysql.JugadorRepository;
import com.miempresa.quiz_app.service.UsuarioService;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final JugadorRepository jugadorRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(JugadorRepository jugadorRepo) {
        this.jugadorRepo = jugadorRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Jugador login(String nombre, String password) {
        Jugador jugador = jugadorRepo.findByNombre(nombre)
                .orElseThrow(() -> new IllegalArgumentException("El usuario no existe."));

        if (!passwordEncoder.matches(password, jugador.getPassword())) {
            throw new IllegalArgumentException("Contraseña incorrecta.");
        }
        return jugador;
    }

    @Override
    @Transactional
    public Jugador registrar(String nombre, String password) {
        // 1. Validar que el nombre no esté pillado
        if (jugadorRepo.findByNombre(nombre).isPresent()) {
            throw new IllegalArgumentException("Ese nombre de jugador ya está en uso.");
        }

        // 2. Validaciones de formato (las que ya tenías)
        validarFormato(nombre, password);

        // 3. Crear y guardar
        Jugador nuevo = new Jugador();
        nuevo.setNombre(nombre);
        nuevo.setPassword(passwordEncoder.encode(password));
        return jugadorRepo.save(nuevo);
    }

    private void validarFormato(String nombre, String password) {
        if (nombre == null || nombre.length() < 3) throw new IllegalArgumentException("Nombre demasiado corto.");
        if (password == null || password.length() < 6) throw new IllegalArgumentException("Contraseña demasiado corta.");
    }
}
