package com.oparts.model;

public class Arma extends Item {
  private TipoArma tipo;
  private int dificultad;
  private String dano; // texto: "8" o "25 + 2D6"
  private int durabilidad;
  private int penalizacion;

  public Arma(int id, String nombre, TipoArma tipo, int dificultad, String dano,
      int durabilidad, int penalizacion, int precio) {
    super(id, nombre, precio);
    if (tipo == null) {
      throw new IllegalArgumentException("El tipo de arma no puede estar vacío");
    }
    if (dificultad < 0) {
      throw new IllegalArgumentException("La dificultad no puede ser negativa");
    }
    if (durabilidad < 1) {
      throw new IllegalArgumentException("La durabilidad debe ser mayor a 0");
    }
    if (penalizacion >= 0) {
      throw new IllegalArgumentException("La penalización debe ser un número negativo");
    }
    this.tipo = tipo;
    this.dificultad = dificultad;
    this.dano = Validaciones.textoNoVacio(dano, "El daño no puede estar vacío");
    this.durabilidad = durabilidad;
    this.penalizacion = penalizacion;
  }

  public TipoArma getTipo() { return tipo; }

  public int getDificultad() { return dificultad; }

  public String getDano() { return dano; }

  public int getDurabilidad() { return durabilidad; }

  public int getPenalizacion() { return penalizacion; }

  @Override
  public Categoria getCategoria() { return Categoria.ARMA; }
}
