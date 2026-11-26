package com.oparts.model;

public class Vehiculo extends Item {
  public Vehiculo(int id, String nombre, int precioMin, int precioMax) {
    super(id, nombre, precioMin, precioMax);
  }

  @Override
  public Categoria getCategoria() { return Categoria.VEHICULO; }
}
