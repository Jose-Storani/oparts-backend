package com.oparts.model;

public class CyberPunk extends ItemConRareza {
  public CyberPunk(int id, String nombre, String descripcion, String efecto,
      Rareza rareza, int precio) {
    super(id, nombre, descripcion, efecto, rareza, precio);
    exigirEfecto();
    exigirRareza();
  }

  @Override
  public Categoria getCategoria() { return Categoria.CYBERPUNK; }
}
