package com.oparts.model;

public enum TipoKundum {
  BRONCE("Bronce"),
  PLATA("Plata"),
  ORO("Oro"),
  ANTIGUA("Antigua");

  private final String etiqueta;

  TipoKundum(String etiqueta) {
    this.etiqueta = etiqueta;
  }

  public String getEtiqueta() {
    return etiqueta;
  }

  public static TipoKundum desde(String texto) {
    if (texto == null || texto.isBlank()) {
      throw new IllegalArgumentException("El tipo de Kundum no puede estar vacío");
    }
    try {
      return TipoKundum.valueOf(texto.trim().toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(
          "Tipo de Kundum inválido: \"" + texto.trim() + "\". Valores válidos: Bronce, Plata, Oro, Antigua");
    }
  }
}
