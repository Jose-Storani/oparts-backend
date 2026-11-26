package com.oparts.model;

public class Magico extends ItemConEfecto {
  public Magico(int id, String nombre, String descripcion, String efecto, int precio) {
    super(id, nombre, descripcion, efecto, precio);
    exigirEfecto();
  }

  @Override
  public Categoria getCategoria() { return Categoria.MAGICO; }
}
