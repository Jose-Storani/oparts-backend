package com.oparts.model;

public class SteamPunk extends ItemConRareza {
  public SteamPunk(int id, String nombre, String descripcion, String efecto,
      Rareza rareza, int precio) {
    super(id, nombre, descripcion, efecto, rareza, precio);
    exigirEfecto();
  }

  @Override
  public Categoria getCategoria() { return Categoria.STEAMPUNK; }
}
