package com.oparts;

import com.oparts.model.Estadistica;
import com.oparts.model.Personaje;
import com.oparts.repository.PersonajeRepository;
import com.oparts.service.PersonajeService;
import com.oparts.ui.MenuConsola;
import java.awt.Menu;

public class App {
  public static void main(String[] args) {
    PersonajeRepository repo = new PersonajeRepository();
    PersonajeService servicio = new PersonajeService(repo);
    MenuConsola menu = new MenuConsola(servicio);
    menu.iniciar();

}
}
