package com.oparts.model;

public abstract class ItemConDescripcion extends Item {
  private String descripcion;

  protected ItemConDescripcion(int id, String nombre, String descripcion, int precio) {
    super(id, nombre, precio);
    this.descripcion = Validaciones.textoOpcional(descripcion);
  }

  public String getDescripcion() { return descripcion; }

  @Override
  public String toString() {
    if (descripcion.isEmpty()) {
      return super.toString();
    }
    return super.toString() + " - " + descripcion;
  }
}
