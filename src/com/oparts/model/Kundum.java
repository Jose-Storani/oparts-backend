package com.oparts.model;

public class Kundum extends Item {
  private TipoKundum tipo;

  public Kundum(int id, TipoKundum tipo, int precio) {
    super(id, nombreDe(tipo), precio);
    this.tipo = tipo;
  }

  public TipoKundum getTipo() { return tipo; }

  @Override
  public Categoria getCategoria() { return Categoria.KUNDUM; }

  private static String nombreDe(TipoKundum tipo) {
    if (tipo == null) {
      throw new IllegalArgumentException("El tipo de Kundum no puede estar vacío");
    }
    return "Kundum de " + tipo.getEtiqueta();
  }
}
