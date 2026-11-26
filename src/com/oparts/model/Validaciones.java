package com.oparts.model;

final class Validaciones {
  private Validaciones() { }

  static String textoNoVacio(String valor, String mensaje) {
    if (valor == null || valor.isBlank()) {
      throw new IllegalArgumentException(mensaje);
    }
    return valor.trim();
  }

  static String textoOpcional(String valor) {
    if (valor == null) {
      return "";
    }
    return valor.trim();
  }

  static void exigirId(int id) {
    if (id < 1) {
      throw new IllegalArgumentException("El id debe ser mayor a 0");
    }
  }
}
