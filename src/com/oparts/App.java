package com.oparts;

import com.oparts.model.Estadistica;
import com.oparts.model.Personaje;
import com.oparts.repository.PersonajeRepository;
import com.oparts.service.PersonajeService;

public class App {
  public static void main(String[] args) {
    PersonajeRepository repo = new PersonajeRepository();
    PersonajeService servicio = new PersonajeService(repo);

    servicio.crearPersonaje("Kira", 24, "Netrunner");
    servicio.crearPersonaje("Dax", 31, "Mercenario");

    for (Personaje p : servicio.listarPersonajes()) {
      System.out.println(p);
    }

    Personaje kira = servicio.obtenerPersonaje(1);
    kira.setEstadistica(Estadistica.ASTUCIA, 4);
    System.out.println("ASTUCIA de Kira: " + kira.getEstadistica(Estadistica.ASTUCIA));

    try {
      servicio.crearPersonaje("", 20, "Netrunner");
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }

    try {
      servicio.obtenerPersonaje(99);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}