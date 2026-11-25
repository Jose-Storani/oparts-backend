package com.oparts.model;

public class Personaje {
  // a futuro: indicar a qué usuario pertenece el personaje
  private int id; // 0 significa "todavía no guardado"
  private String nombre;
  private int edad;
  private String clase; // a futuro será una clase propia (nombre, descripción, forma de ganar espíritu, atributos iniciales); un personaje podrá cambiar de clase e incluso tener dos
  private final Estadisticas estadisticas = new Estadisticas(); // siempre las mismas 6 estadísticas; sus valores suben con la experiencia. Existen subestadísticas derivadas, pero eso es más adelante.

  public Personaje(String nombre, int edad, String clase) {
    this.nombre = textoNoVacio(nombre, "El nombre no puede estar vacío");
    if (edad < 1) {
      throw new IllegalArgumentException("La edad debe ser mayor a 0");
    }
    this.edad = edad;
    this.clase = textoNoVacio(clase, "La clase no puede estar vacía");
  }

  // --GETTERS ---
  public int getId() { return id; }

  public String getNombre() { return nombre; }

  public int getEdad() { return edad; }

  public String getClase() { return clase; }

  public int getEstadistica(Estadistica e) {
    return estadisticas.get(e);
  }

  // -SETTERS ----
  public void setId(int id) {
    if (this.id != 0) {
      throw new IllegalStateException("El personaje ya tiene un id asignado");
    }
    this.id = id;
  }

  public void setClase(String clase) {
    this.clase = textoNoVacio(clase, "La clase no puede estar vacía");
  }

  public void setEstadistica(Estadistica e, int valor) {
    estadisticas.set(e, valor);
  }

  @Override
  public String toString() {
    return nombre + " (" + clase + ", " + edad + " años)";
  }


  private static String textoNoVacio(String valor, String mensaje) {
    if (valor == null || valor.isBlank()) {
      throw new IllegalArgumentException(mensaje);
    }
    return valor.trim();
  }
}