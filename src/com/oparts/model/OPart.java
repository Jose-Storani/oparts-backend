package com.oparts.model;

public class OPart extends ItemConRareza {
  // null significa "sin completar": el admin los carga más adelante
  private Integer afinidad;
  private Integer costoMP;
  private Rareza rango;

  public OPart(int id, String nombre, String descripcion, String efecto, Rareza rareza,
      int precio, Integer afinidad, Integer costoMP, Rareza rango) {
    super(id, nombre, descripcion, efecto, rareza, precio);
    if (afinidad != null && (afinidad < 1 || afinidad > 100)) {
      throw new IllegalArgumentException("La afinidad debe estar entre 1 y 100");
    }
    if (costoMP != null && costoMP <= 0) {
      throw new IllegalArgumentException("El costo MP debe ser mayor a 0");
    }
    this.afinidad = afinidad;
    this.costoMP = costoMP;
    this.rango = rango;
  }

  public Integer getAfinidad() { return afinidad; }

  public Integer getCostoMP() { return costoMP; }

  public Rareza getRango() { return rango; }

  public boolean tieneDatosPendientes() {
    return afinidad == null || costoMP == null || rango == null;
  }

  @Override
  public Categoria getCategoria() { return Categoria.OPART; }
}
