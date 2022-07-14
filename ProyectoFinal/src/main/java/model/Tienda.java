package model;

public class Tienda {
    private int idcelular;
    private String modelo;
    private String marca;
    private int memoria;
    private double precio;
    private int stock;

    public Tienda (int idcelular, String modelo, String marca, int memoria, double precio, int stock) {
        this.idcelular = idcelular;
        this.modelo = modelo;
        this.marca = marca;
        this.memoria = memoria;
        this.precio = precio;
        this.stock = stock;
    }

    public Tienda (String modelo, String marca, int memoria, double precio, int stock) {
        this.modelo = modelo;
        this.marca = marca;
        this.memoria = memoria;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdcelular() {
        return idcelular;
    }

    public void setIdcelular(int idcelular) {
        this.idcelular = idcelular;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Tienda{" + "idcelular=" + idcelular + ", modelo=" + modelo + ", marca=" + marca + ", memoria=" + memoria + ", precio=" + precio + ", stock=" + stock + '}';
    }
}

  