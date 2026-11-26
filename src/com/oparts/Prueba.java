package com.oparts;

import com.oparts.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prueba {
  public static void main(String[] args) {
    List<ElementoCatalogo> catalogo = new ArrayList<>();
    catalogo.add(new CyberPunk(1, "Analizador GeoAmbiental", "Dron de reconocimiento",
        "+2 supervivencia", Rareza.B, 8000));
    catalogo.add(new SteamPunk(2, "Brújula de vapor", "", "+1 orientarse", null, 3000));
    catalogo.add(new OPart(3, "O-Part", "Control agua", "", null, 18000, null, null, null));
    catalogo.add(new Arma(4, "Daga Sastaguino", TipoArma.T1, 7, "8", 65, -2, 900));
    catalogo.add(new Magico(5, "Anillo", "-1pt gasto MP", "Descuento 1mp por turno", 12500));
    catalogo.add(new Basico(6, "Raciones", "", 70));
    Vehiculo skate = new Vehiculo(7, "Neon Skate", 15000, 23000);
    catalogo.add(skate);
    catalogo.add(new Kundum(8, TipoKundum.ORO, 13000));
    catalogo.add(new KundumItem(9, "Objetos Raros", "Amuleto Gilgamesh", "Revive 1hp último hogar"));

    System.out.println("=== CATÁLOGO COMPLETO ===");
    for (ElementoCatalogo e : catalogo) {
      System.out.println(e);
    }

    System.out.println("\n=== SOLO STEAMPUNK ===");
    for (ElementoCatalogo e : catalogo) {
      if (e.getCategoria() == Categoria.STEAMPUNK) {
        System.out.println(e);
      }
    }

    System.out.println("\n=== SORTEO DE PRECIO (Neon Skate) ===");
    Random random = new Random();
    for (int i = 0; i < 3; i++) {
      System.out.println(skate.randomPrecio(random));
    }

    System.out.println("\n=== REGLAS: todos estos casos deben dar error ===");

    try {
      new CyberPunk(10, "Collar de detención", "Genera Descargas", "", Rareza.A, 9000);
    } catch (IllegalArgumentException e) {
      System.out.println("CyberPunk sin efecto -> " + e.getMessage());
    }

    try {
      new CyberPunk(11, "Cyber Arco", "", "Dispara flechas", null, 13000);
    } catch (IllegalArgumentException e) {
      System.out.println("CyberPunk sin rareza -> " + e.getMessage());
    }

    try {
      new Magico(12, "Cadena/Collar", "+1 en Manipulación", "", 13750);
    } catch (IllegalArgumentException e) {
      System.out.println("Mágico sin efecto -> " + e.getMessage());
    }

    try {
      new OPart(13, "O-Part", "Control fuego", "", null, 20000, 150, null, null);
    } catch (IllegalArgumentException e) {
      System.out.println("O-Part con afinidad 150 -> " + e.getMessage());
    }

    try {
      new OPart(14, "O-Part", "Control fuego", "", null, 20000, 50, 0, null);
    } catch (IllegalArgumentException e) {
      System.out.println("O-Part con costo MP 0 -> " + e.getMessage());
    }

    try {
      new Arma(15, "Espada rota", TipoArma.T2, 6, "10", 50, 3, 700);
    } catch (IllegalArgumentException e) {
      System.out.println("Arma con penalización positiva -> " + e.getMessage());
    }

    try {
      Rareza.desde("Z");
    } catch (IllegalArgumentException e) {
      System.out.println("Rareza Z -> " + e.getMessage());
    }

    try {
      TipoKundum.desde("Diamante");
    } catch (IllegalArgumentException e) {
      System.out.println("Kundum Diamante -> " + e.getMessage());
    }

    System.out.println("\nTipoKundum.desde(\"Bronce\") = " + TipoKundum.desde("Bronce"));
  }
}
