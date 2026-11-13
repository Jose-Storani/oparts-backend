package com.oparts.model;

public class Personaje {
  //el personaje tambien deberia tener un indicador de a que usuario corresponde
  private int id;
  private String nombre;
  private int edad;
  private String clase; //esto a futuro va a ser una clase propia con nombre de clase, descripcion, forma de ganar espiritu, atributos iniciales.
  private final Estadisticas estadisticas = new Estadisticas(); //siempre las mismas 6 estadísticas; sus valores suben con la experiencia. Existen subestadisticas derivadas de cada una, pero eso es mas adelante.

  public Personaje(String nombre, int edad, String clase){
    this.nombre = nombre;
    this.edad= edad;
    this.clase = clase;


  }

  //GETTERS
  public int getId() {return id;}

  public String getNombre() { return nombre; }

  public int getEdad() { return edad; }

  public String getClase() { return clase; }

  public int getEstadistica(Estadistica e) {
    return estadisticas.get(e);
  }

  //-------SETTERS-----------
  public void setEstadistica(Estadistica e, int valor) {
    estadisticas.set(e, valor);
  }

    public void setId(int id) {
    if (this.id != 0) {
      throw new IllegalStateException("El personaje ya tiene un id asignado");
    }
    this.id = id;
  }

    public void setClase(String clase){
      this.clase = clase; //los personajes pueden cambiar de clase durante el juego, incluso tener dos llegado el caso.
    }

      @Override
  public String toString() {
    return nombre + " (" + clase + ", " + edad + " años)";
  }





}
