package com.fidalia.conversormonedas.modelos;

public class Moneda {
    private String nombre;
    private String codigo;
    private double valoraConvertir;

    public Moneda(String nombre, String codigo, double valoraConvertir) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.valoraConvertir = valoraConvertir;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValoraConvertir() {
        return valoraConvertir;
    }

    public void setValoraConvertir(double valoraConvertir) {
        this.valoraConvertir = valoraConvertir;
    }
    public void mostrarMoneda(){
          System.out.println(getNombre());
          System.out.println(getCodigo());
          System.out.println(getValoraConvertir());
    }
}
