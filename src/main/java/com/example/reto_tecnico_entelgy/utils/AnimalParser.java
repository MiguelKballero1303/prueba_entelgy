package com.example.reto_tecnico_entelgy.utils;

import com.example.reto_tecnico_entelgy.models.*;

import java.util.ArrayList;
import java.util.List;

public class AnimalParser {
    public static List<Animal> parsearEntrada(String[] args) {
        List<Animal> animales = new ArrayList<>();

        for (String arg : args) {
            String[] datos = arg.split("\\|");
            if (datos.length == 3) {
                String nombre = datos[0];
                String tipoStr = datos[1];
                String onomatopeya = datos[2];

                TipoAnimal.fromString(tipoStr).ifPresent(tipo -> {
                    switch (tipo) {
                        case TERRESTRE -> animales.add(new Terrestre(nombre, onomatopeya));
                        case VOLADOR -> animales.add(new Volador(nombre, onomatopeya));
                        case ACUATICO -> animales.add(new Acuatico(nombre, onomatopeya));
                    }
                });
            }
        }
        return animales;
    }
}
