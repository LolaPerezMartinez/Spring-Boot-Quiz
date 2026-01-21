INSERT INTO temas (nombre) VALUES ('Matemáticas');
INSERT INTO preguntas (enunciado, tipo_pregunta, tema_id, activa) VALUES ('¿2+2=4?', 'VF', 1, true);

INSERT INTO respuesta (texto, correcta, pregunta_id) VALUES ('Verdadero', true, 1);
INSERT INTO respuesta (texto, correcta, pregunta_id) VALUES ('Falso', false, 1);
