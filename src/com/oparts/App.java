package com.oparts;

import com.oparts.model.Estadistica;
import com.oparts.model.Personaje;

public class App {
  public static void main(String[] args) {
    Personaje p = new Personaje("Kira", 24, "Netrunner");
    System.out.println(p);

    p.setEstadistica(Estadistica.ASTUCIA, 4);
    p.setEstadistica(Estadistica.VOLUNTAD, 3);

    for (Estadistica e : Estadistica.values()) {
      System.out.println(e + ": " + p.getEstadistica(e));
    }
  }
}