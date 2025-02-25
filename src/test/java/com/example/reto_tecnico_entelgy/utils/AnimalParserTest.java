package com.example.reto_tecnico_entelgy.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import com.example.reto_tecnico_entelgy.models.*;

public class AnimalParserTest {

    @Test
    public void testParsearEntradaCorrecta() {
        String[] args = {"Rex|terrestre|guau", "Nemo|acuatico|blub", "Drácula|volador|screech"};
        List<Animal> animales = AnimalParser.parsearEntrada(args);

        assertEquals(3, animales.size());
        assertTrue(animales.get(0) instanceof Terrestre);
        assertTrue(animales.get(1) instanceof Acuatico);
        assertTrue(animales.get(2) instanceof Volador);
    }

    @Test
    public void testParsearEntradaConTipoInvalido() {
        String[] args = {"Rex|terrestre|guau", "Desconocido|fantasma|buuu"};
        List<Animal> animales = AnimalParser.parsearEntrada(args);

        assertEquals(1, animales.size());  // Solo "Rex" debe ser válido
        assertTrue(animales.get(0) instanceof Terrestre);
    }

    @Test
    public void testParsearEntradaIncompleta() {
        String[] args = {"Rex|terrestre", "Nemo|acuatico|blub"};  // Falta la onomatopeya en el primero
        List<Animal> animales = AnimalParser.parsearEntrada(args);

        assertEquals(1, animales.size());  // Solo "Nemo" es válido
        assertTrue(animales.get(0) instanceof Acuatico);
    }
}
