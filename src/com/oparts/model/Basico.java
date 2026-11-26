package com.oparts.model;

public class Basico extends ItemConDescripcion {
  public Basico(int id, String nombre, String descripcion, int precio) {
    super(id, nombre, descripcion, precio);
  }

  @Override
  public Categoria getCategoria() { return Categoria.BASICO; }
}
