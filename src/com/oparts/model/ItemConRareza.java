package com.oparts.model;

public abstract class ItemConRareza extends ItemConEfecto {
  private Rareza rareza; // null significa "sin definir"

  protected ItemConRareza(int id, String nombre, String descripcion, String efecto,
      Rareza rareza, int precio) {
    super(id, nombre, descripcion, efecto, precio);
    this.rareza = rareza;
  }

  public Rareza getRareza() { return rareza; }

  public boolean tieneRareza() { return rareza != null; }

  // Las categorías donde la rareza es obligatoria llaman a este método en su constructor
  protected void exigirRareza() {
    if (rareza == null) {
      throw new IllegalArgumentException("La rareza no puede estar vacía");
    }
  }
}
