package com.proyectos.FinanSmart.model;

public class Gasto {
    private String id;
    private int monto;

    public Gasto(String id, int monto) {
        this.id = id;
        this.monto = monto;
    }

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

    @Override
    public String toString() {
        return "Gasto{" +
                "id='" + id + '\'' +
                ", monto=" + monto +
                '}';
    }
}