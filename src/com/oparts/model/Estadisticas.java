package com.oparts.model;

import java.util.EnumMap;
import java.util.Map;

public class Estadisticas {
  private final Map<Estadistica, Integer> valoresEstadisticas = new EnumMap<>(Estadistica.class);

  public Estadisticas(){
    for(Estadistica e : Estadistica.values()){
      valoresEstadisticas.put(e, 1);
    }
  }

  public int get(Estadistica e){
    return valoresEstadisticas.get(e);
  };

  public void set (Estadistica e, int valorNuevo){
    if(valorNuevo < 1){
      throw new IllegalArgumentException("El valor no puede ser menor a 1");
    }
    valoresEstadisticas.put(e, valorNuevo);
  }


}
