package com.example.reto_tecnico_entelgy.models;
import java.util.Arrays;
import java.util.Optional;

public enum TipoAnimal {
    TERRESTRE, VOLADOR, ACUATICO;

    public static Optional<TipoAnimal> fromString(String tipo) {
        return Arrays.stream(values())
                .filter(t -> t.name().equalsIgnoreCase(tipo))
                .findFirst();
    }
}
