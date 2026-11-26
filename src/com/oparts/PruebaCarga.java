package com.oparts;

import com.oparts.repository.LectorCatalogo;
import com.oparts.repository.LineaCatalogo;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class PruebaCarga {
  public static void main(String[] args) throws IOException {
    LectorCatalogo lector = new LectorCatalogo();
    List<LineaCatalogo> lineas = lector.leer(Path.of("catalogo.txt"));

    System.out.println("Líneas de datos: " + lineas.size());

    for (int i = 0; i < 2; i++) {
      LineaCatalogo l = lineas.get(i);
      System.out.println("Línea " + l.getNumero() + " del archivo: categoría "
          + l.getCampos()[0] + ", " + l.getCampos().length + " campos");
    }

    for (LineaCatalogo l : lineas) {
      if (l.getCampos()[0].equals("OPART")) {
        System.out.println("\nPrimer OPART, línea " + l.getNumero() + ":");
        System.out.println("  texto original: " + l.getTexto());
        System.out.println("  split(\";\", -1) da " + l.getCampos().length + " campos");
        System.out.println("  split(\";\")     da " + l.getTexto().split(";").length + " campos");
        break;
      }
    }
  }
}