package com.proyectos.FinanSmart.model;

public class Gasto {
    private String id;
    private int monto;

    // Constructor
    public Gasto(String id, int monto) {
        this.id = id;
        this.monto = monto;
    }

    // Getter n Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    // To String
    @Override
    public String toString() {
        return "Gasto{" +
                "id='" + id + '\'' +
                ", monto=" + monto +
                '}';
    }
}