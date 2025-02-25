package com.example.reto_tecnico_entelgy.models;

public abstract class Animal implements Sonoro {
    private String nombre;
    private String onomatopeya;
    private final TipoAnimal tipo;

    public Animal(String nombre, String onomatopeya, TipoAnimal tipo) {
        this.nombre = nombre;
        this.onomatopeya = onomatopeya;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public String getOnomatopeya() { return onomatopeya; }
    public TipoAnimal getTipo() { return tipo; }

    @Override
    public String emitirSonido() {
        return nombre + " hace " + onomatopeya;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Tipo: " + tipo + ", Sonido: " + emitirSonido();
    }
}
