package com.oparts.model;

import java.util.Random;

public abstract class Item implements ElementoCatalogo {
  private final int id;
  private String nombre;
  private int precioMin;
  private int precioMax;

  // Item de precio fijo
  protected Item(int id, String nombre, int precio) {
    this(id, nombre, precio, precio);
  }

  // Item con precio dentro de un rango (ej: vehículos)
  protected Item(int id, String nombre, int precioMin, int precioMax) {
    Validaciones.exigirId(id);
    if (precioMin < 0) {
      throw new IllegalArgumentException("El precio no puede ser negativo");
    }
    if (precioMax < precioMin) {
      throw new IllegalArgumentException("El precio máximo no puede ser menor al mínimo");
    }
    this.id = id;
    this.nombre = Validaciones.textoNoVacio(nombre, "El nombre no puede estar vacío");
    this.precioMin = precioMin;
    this.precioMax = precioMax;
  }

  @Override
  public int getId() { return id; }

  @Override
  public String getNombre() { return nombre; }

  public int getPrecioMin() { return precioMin; }

  public int getPrecioMax() { return precioMax; }

  public boolean tienePrecioFijo() {
    return precioMin == precioMax;
  }

  public int randomPrecio(Random random) {
    return precioMin + random.nextInt(precioMax - precioMin + 1);
  }

  public String textoPrecio() {
    if (tienePrecioFijo()) {
      return String.valueOf(precioMin);
    }
    return precioMin + " - " + precioMax;
  }

  @Override
  public String toString() {
    return "#" + id + " [" + getCategoria() + "] " + nombre + " (" + textoPrecio() + ")";
  }
}
