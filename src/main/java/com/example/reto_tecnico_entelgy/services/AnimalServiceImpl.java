package com.example.reto_tecnico_entelgy.services;

import com.example.reto_tecnico_entelgy.models.Animal;
import com.example.reto_tecnico_entelgy.models.TipoAnimal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Override
    public Map<TipoAnimal, List<Animal>> agruparPorTipo(List<Animal> animales) {
        return animales.stream().collect(Collectors.groupingBy(Animal::getTipo));
    }

    public String imprimirAnimales(Map<TipoAnimal, List<Animal>> animalesAgrupados) {
        return animalesAgrupados.entrySet().stream()
                .map(entry -> "\nAnimales " + entry.getKey() + ":\n" +
                        entry.getValue().stream()
                                .map(Animal::emitirSonido)
                                .collect(Collectors.joining("\n")))
                .collect(Collectors.joining("\n"));
    }
}
