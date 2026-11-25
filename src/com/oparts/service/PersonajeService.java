package com.oparts.service;

import com.oparts.model.Estadistica;
import com.oparts.model.Personaje;
import com.oparts.repository.PersonajeRepository;
import java.util.List;

public class PersonajeService {
  private final PersonajeRepository repositorio;

  public PersonajeService(PersonajeRepository repositorio) {
    this.repositorio = repositorio;
  }

  public Personaje crearPersonaje(String nombre, int edad, String clase) {
    return repositorio.guardar(new Personaje(nombre, edad, clase));
  }

  public List<Personaje> listarPersonajes() {
    return repositorio.listarTodos();
  }

  public Personaje obtenerPersonaje(int id) {
    Personaje p = repositorio.buscarPorId(id);
    if (p == null) {
      throw new IllegalArgumentException("No existe un personaje con id " + id);
    }
    return p;
  }

  public Personaje asignarEstadistica(int id, Estadistica estadistica, int valor){
      Personaje p = obtenerPersonaje(id);
      p.setEstadistica(estadistica, valor);
      return p;
  }
}