package com.oparts.ui;

import com.oparts.model.Estadistica;
import com.oparts.model.Personaje;
import com.oparts.service.PersonajeService;
import java.util.List;
import java.util.Scanner;


public class MenuConsola {
  private final PersonajeService servicio;
  private final Scanner scanner = new Scanner(System.in);

  public MenuConsola(PersonajeService servicio){
    this.servicio = servicio;
  }

   public void iniciar() {
    boolean ejecutando = true;

    while (ejecutando) {
      mostrarMenu();
      String opcion = scanner.nextLine().trim();

      try {
        switch (opcion) {
          case "1":
            crearPersonaje();
            break;
          case "2":
            listarPersonajes();
            break;
          case "3":
            verFicha();
            break;
          case "4":
            asignarEstadistica();
            break;
          case "0":
            ejecutando = false;
            System.out.println("Cerrando O-Parts...");
            break;
          default:
            System.out.println("Opción inválida");
        }
      } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }

    scanner.close();
  }

  private void mostrarMenu() {
    System.out.println("\n=== O-PARTS ===");
    System.out.println("1. Crear personaje");
    System.out.println("2. Listar personajes");
    System.out.println("3. Ver ficha de un personaje");
    System.out.println("4. Asignar valor a una estadística");
    System.out.println("0. Salir");
    System.out.print("Elegí una opción: ");
  }

  private void crearPersonaje() {
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    int edad = leerNumero("Edad: ");
    System.out.print("Clase: ");
    String clase = scanner.nextLine();

    Personaje creado = servicio.crearPersonaje(nombre, edad, clase);
    System.out.println("Personaje creado con id " + creado.getId() + ": " + creado);
  }

  private void listarPersonajes() {
    List<Personaje> personajes = servicio.listarPersonajes();

    if (personajes.isEmpty()) {
      System.out.println("No hay personajes cargados");
      return;
    }

    for (Personaje p : personajes) {
      System.out.println("#" + p.getId() + " " + p);
    }
  }

  private void verFicha() {
    int id = leerNumero("Id del personaje: ");
    Personaje p = servicio.obtenerPersonaje(id);

    System.out.println("--- " + p + " ---");
    for (Estadistica e : Estadistica.values()) {
      System.out.println(e + ": " + p.getEstadistica(e));
    }
  }

  private int leerNumero(String mensaje) {
    System.out.print(mensaje);
    String texto = scanner.nextLine();

    try {
      return Integer.parseInt(texto.trim());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Tenés que ingresar un número entero");
    }
  }

  private void asignarEstadistica() {
  int id = leerNumero("Id del personaje: ");
  Personaje p = servicio.obtenerPersonaje(id);

  Estadistica[] estadisticas = Estadistica.values();
  System.out.println("Estadísticas de " + p.getNombre() + ":");
  for (int i = 0; i < estadisticas.length; i++) {
    System.out.println((i + 1) + ". " + estadisticas[i]
        + " (actual: " + p.getEstadistica(estadisticas[i]) + ")");
  }

  int numero = leerNumero("Elegí una estadística: ");
  if (numero < 1 || numero > estadisticas.length) {
    throw new IllegalArgumentException(
        "Elegí un número entre 1 y " + estadisticas.length);
  }
  Estadistica elegida = estadisticas[numero - 1];

  int valor = leerNumero("Nuevo valor para " + elegida + ": ");
  Personaje actualizado = servicio.asignarEstadistica(id, elegida, valor);

  System.out.println(elegida + " de " + actualizado.getNombre()
      + " ahora vale " + actualizado.getEstadistica(elegida));
}


}
