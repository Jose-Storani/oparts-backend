package com.oparts.repository;

import com.oparts.model.Personaje;
import java.util.ArrayList;
import java.util.List;

public class PersonajeRepository {
  private final List<Personaje> personajes = new ArrayList<>();
  private int proximoId = 1;

  public Personaje guardar(Personaje p) {
    p.setId(proximoId++);
    personajes.add(p);
    return p;
  }

  public List<Personaje> listarTodos() {
    return new ArrayList<>(personajes);
  }

  public Personaje buscarPorId(int id) {
    for (Personaje p : personajes) {
      if (p.getId() == id) {
        return p;
      }
    }
    return null;
  }
}