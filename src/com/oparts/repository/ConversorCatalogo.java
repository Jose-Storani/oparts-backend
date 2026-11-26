package com.oparts.repository;

import com.oparts.model.*;

public class ConversorCatalogo {

  public ElementoCatalogo convertir(LineaCatalogo linea) {
    String[] c = linea.getCampos();

    Categoria categoria = Categoria.desde(c[0]);

    int esperados = camposEsperados(categoria);
    if (c.length != esperados) {
      throw new IllegalArgumentException("Para " + categoria + " se esperaban " + esperados
          + " campos y hay " + c.length);
    }

    int id = entero(c[1], "id");

    switch (categoria) {
      case CYBERPUNK:
        return new CyberPunk(id, c[2], c[3], c[4], rarezaOpcional(c[5]), entero(c[6], "precio"));
      case STEAMPUNK:
        return new SteamPunk(id, c[2], c[3], c[4], rarezaOpcional(c[5]), entero(c[6], "precio"));
      case OPART:
        return new OPart(id, c[2], c[3], c[4], rarezaOpcional(c[5]), entero(c[6], "precio"),
            enteroOpcional(c[7], "afinidad"), enteroOpcional(c[8], "costoMP"), rarezaOpcional(c[9]));
      case ARMA:
        return new Arma(id, c[2], TipoArma.desde(c[3]), entero(c[4], "dificultad"), c[5],
            entero(c[6], "durabilidad"), entero(c[7], "penalizacion"), entero(c[8], "precio"));
      case MAGICO:
        return new Magico(id, c[2], c[3], c[4], entero(c[5], "precio"));
      case BASICO:
        return new Basico(id, c[2], c[3], entero(c[4], "precio"));
      case VEHICULO:
        return new Vehiculo(id, c[2], entero(c[3], "precioMin"), entero(c[4], "precioMax"));
      case KUNDUM:
        return new Kundum(id, TipoKundum.desde(c[2]), entero(c[3], "precio"));
      case KUNDUM_ITEM:
        return new KundumItem(id, c[2], c[3], c[4]);
      default:
        throw new IllegalArgumentException("Categoría sin conversor: " + categoria);
    }
  }

  private static int camposEsperados(Categoria categoria) {
    switch (categoria) {
      case CYBERPUNK: return 7;
      case STEAMPUNK: return 7;
      case OPART: return 10;
      case ARMA: return 9;
      case MAGICO: return 6;
      case BASICO: return 5;
      case VEHICULO: return 5;
      case KUNDUM: return 4;
      case KUNDUM_ITEM: return 5;
      default: throw new IllegalArgumentException("Categoría sin definir: " + categoria);
    }
  }

  private static int entero(String texto, String campo) {
    if (texto.isBlank()) {
      throw new IllegalArgumentException("El campo " + campo + " está vacío");
    }
    try {
      return Integer.parseInt(texto.trim());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          "El campo " + campo + " debe ser un número entero (dice \"" + texto.trim() + "\")");
    }
  }

  private static Integer enteroOpcional(String texto, String campo) {
    if (texto.isBlank()) {
      return null;
    }
    return entero(texto, campo);
  }

  private static Rareza rarezaOpcional(String texto) {
    if (texto.isBlank()) {
      return null;
    }
    return Rareza.desde(texto);
  }
}