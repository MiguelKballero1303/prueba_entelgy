package com.example.reto_tecnico_entelgy;

import java.util.List;
import java.util.Map;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.reto_tecnico_entelgy.config.AppConfig;
import com.example.reto_tecnico_entelgy.models.Animal;
import com.example.reto_tecnico_entelgy.models.TipoAnimal;
import com.example.reto_tecnico_entelgy.services.AnimalService;
import com.example.reto_tecnico_entelgy.utils.AnimalParser;

@SpringBootApplication
public class RetoTecnicoEntelgyApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnimalService animalService = context.getBean(AnimalService.class);

        if (args.length == 0) {
            System.out.println("No se proporcionaron datos de entrada.");
            return;
        }
        System.out.println("Argumentos recibidos:");
        for (String arg : args) {
            System.out.println(arg);
        }
        List<Animal> animales = AnimalParser.parsearEntrada(args);
        System.out.println("Animales parseados:");
        animales.forEach(System.out::println);

        Map<TipoAnimal, List<Animal>> animalesAgrupados = animalService.agruparPorTipo(animales);
        System.out.println("Animales agrupados por tipo:");
        animalesAgrupados.forEach((tipo, lista) -> {
            System.out.println("\nAnimales " + tipo + ":");
            lista.forEach(System.out::println);
        });
    }
}
