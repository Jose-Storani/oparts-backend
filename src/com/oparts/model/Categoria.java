package com.oparts.model;

public enum Categoria {
  CYBERPUNK, STEAMPUNK, OPART, ARMA, MAGICO, BASICO, VEHICULO, KUNDUM, KUNDUM_ITEM;

  public static Categoria desde(String texto) {
    if (texto == null || texto.isBlank()) {
      throw new IllegalArgumentException("La categoría no puede estar vacía");
    }
    try {
      return Categoria.valueOf(texto.trim().toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Categoría inválida: \"" + texto.trim() + "\"");
    }
  }
}
