package com.example.reto_tecnico_entelgy.services;

import com.example.reto_tecnico_entelgy.models.Animal;
import com.example.reto_tecnico_entelgy.models.TipoAnimal;

import java.util.List;
import java.util.Map;

public interface AnimalService {
    Map<TipoAnimal, List<Animal>> agruparPorTipo(List<Animal> animales);
}
