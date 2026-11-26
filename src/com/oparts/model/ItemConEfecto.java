package com.oparts.model;

public abstract class ItemConEfecto extends ItemConDescripcion {
  private String efecto;

  protected ItemConEfecto(int id, String nombre, String descripcion, String efecto, int precio) {
    super(id, nombre, descripcion, precio);
    this.efecto = Validaciones.textoOpcional(efecto);
  }

  public String getEfecto() { return efecto; }

  // Las categorías donde el efecto es obligatorio llaman a este método en su constructor
  protected void exigirEfecto() {
    if (efecto.isEmpty()) {
      throw new IllegalArgumentException("El efecto no puede estar vacío");
    }
  }
}
