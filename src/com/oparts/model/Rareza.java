package com.oparts.model;

public enum Rareza {
  E, D, C, B, A, S, SS, SSS;

  public static Rareza desde(String texto) {
    if (texto == null || texto.isBlank()) {
      throw new IllegalArgumentException("La rareza no puede estar vacía");
    }
    try {
      return Rareza.valueOf(texto.trim().toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(
          "Rareza inválida: \"" + texto.trim() + "\". Valores válidos: E, D, C, B, A, S, SS, SSS");
    }
  }
}
