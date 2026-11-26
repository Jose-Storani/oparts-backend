package com.oparts.model;

public enum TipoArma {
  T1, T2, T3;

  public static TipoArma desde(String texto) {
    if (texto == null || texto.isBlank()) {
      throw new IllegalArgumentException("El tipo de arma no puede estar vacío");
    }
    try {
      return TipoArma.valueOf(texto.trim().toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(
          "Tipo de arma inválido: \"" + texto.trim() + "\". Valores válidos: T1, T2, T3");
    }
  }
}
