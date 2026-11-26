package com.oparts.repository;

public class LineaCatalogo {
  private final int numero;
  private final String texto;
  private final String[] campos;

  public LineaCatalogo(int numero, String texto, String[] campos) {
    this.numero = numero;
    this.texto = texto;
    this.campos = campos;
  }

  public int getNumero() { return numero; }

  public String getTexto() { return texto; }

  public String[] getCampos() { return campos; }
}