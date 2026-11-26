package com.oparts.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LectorCatalogo {

  public List<LineaCatalogo> leer(Path archivo) throws IOException {
    List<String> textos = Files.readAllLines(archivo, StandardCharsets.UTF_8);
    List<LineaCatalogo> lineas = new ArrayList<>();

    for (int i = 0; i < textos.size(); i++) {
      String texto = textos.get(i);

      if (i == 0 && texto.startsWith("\uFEFF")) {
        texto = texto.substring(1); // algunos editores de Windows agregan esta marca invisible
      }
      if (texto.isBlank() || texto.startsWith("#")) {
        continue;
      }

      lineas.add(new LineaCatalogo(i + 1, texto, texto.split(";", -1)));
    }
    return lineas;
  }
}