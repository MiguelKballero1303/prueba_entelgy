package com.example.reto_tecnico_entelgy.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import com.example.reto_tecnico_entelgy.models.*;

public class AnimalServiceTest {
    private final AnimalService service = new AnimalServiceImpl();

    @Test
    public void testAgruparPorTipo() {
        List<Animal> animales = List.of(
                new Terrestre("Rex", "guau"),
                new Acuatico("Nemo", "blub"),
                new Volador("Drácula", "screech")
        );

        Map<TipoAnimal, List<Animal>> agrupados = service.agruparPorTipo(animales);
        
        assertEquals(1, agrupados.get(TipoAnimal.TERRESTRE).size());
        assertEquals(1, agrupados.get(TipoAnimal.ACUATICO).size());
        assertEquals(1, agrupados.get(TipoAnimal.VOLADOR).size());
    }
}
