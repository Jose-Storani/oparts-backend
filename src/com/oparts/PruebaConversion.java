package com.oparts;

import com.oparts.model.ElementoCatalogo;
import com.oparts.repository.ConversorCatalogo;
import com.oparts.repository.LectorCatalogo;
import com.oparts.repository.LineaCatalogo;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class PruebaConversion {
  public static void main(String[] args) throws IOException {
    LectorCatalogo lector = new LectorCatalogo();
    ConversorCatalogo conversor = new ConversorCatalogo();
    List<LineaCatalogo> lineas = lector.leer(Path.of("catalogo.txt"));

    System.out.println("=== PRIMERA LÍNEA DE CADA CATEGORÍA ===");
    String anterior = "";
    for (LineaCatalogo l : lineas) {
      String categoria = l.getCampos()[0];
      if (!categoria.equals(anterior)) {
        ElementoCatalogo e = conversor.convertir(l);
        System.out.println(e);
        anterior = categoria;
      }
    }

    System.out.println("\nErrores hardcodeados");
    String[] malas = {
      "CYBERPUNK;900;Casco;;Protege;B",
      "CYBERPUNK;900;Casco;;Protege;B;mucho",
      "CYBERPUNK;900;Casco;;Protege;B;",
      "DRAGON;900;Casco;;Protege;B;100",
      "CYBERPUNK;abc;Casco;;Protege;B;100",
      "ARMA;900;Espada;T9;5;8;60;-2;700",
      "ARMA;900;Espada;T1;5;8;0;-2;700"
    };
    for (String texto : malas) {
      LineaCatalogo l = new LineaCatalogo(0, texto, texto.split(";", -1));
      try {
        conversor.convertir(l);
      } catch (IllegalArgumentException e) {
        System.out.println(texto);
        System.out.println("   -> " + e.getMessage());
      }
    }
  }
}