package com.oparts.model;

import java.util.EnumMap;
import java.util.Map;

public class Estadisticas {
  private final Map<Estadistica, Integer> valores_estadisticas = new EnumMap<>(Estadistica.class);

  public Estadisticas(){
    for(Estadistica e : Estadistica.values()){
      valores_estadisticas.put(e, 1);
    }

  }
}
