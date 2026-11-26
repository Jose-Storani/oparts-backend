package com.oparts.model;

public class KundumItem implements ElementoCatalogo {
  private final int id;
  private String nombre;
  private String descripcion;
  private String efecto;

  public KundumItem(int id, String nombre, String descripcion, String efecto) {
    Validaciones.exigirId(id);
    this.id = id;
    this.nombre = Validaciones.textoNoVacio(nombre, "El nombre no puede estar vacío");
    this.descripcion = Validaciones.textoOpcional(descripcion);
    this.efecto = Validaciones.textoNoVacio(efecto, "El efecto no puede estar vacío");
  }

  @Override
  public int getId() { return id; }

  @Override
  public String getNombre() { return nombre; }

  public String getDescripcion() { return descripcion; }

  public String getEfecto() { return efecto; }

  @Override
  public Categoria getCategoria() { return Categoria.KUNDUM_ITEM; }

  @Override
  public String toString() {
    String texto = "#" + id + " [" + getCategoria() + "] " + nombre + " (solo en Kundums)";
    if (descripcion.isEmpty()) {
      return texto;
    }
    return texto + " - " + descripcion;
  }
}
