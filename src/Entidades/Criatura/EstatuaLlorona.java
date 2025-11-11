package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;
import java.util.Arrays;
import java.util.List;

public class EstatuaLlorona extends Entidad {

    private final int danoLlantoMax = 13;
    private final int danoAnsiedadMin = 7;

    public EstatuaLlorona() {
        super("ESTATUA_LLORONA",
                "Estatua Llorona",
                "Una figura de mármol con lágrimas grabadas en la cara, que parece observarte.",
                "Una estatua te bloquea. Sus lágrimas parecen reales. ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() { // Public
        return Arrays.asList(
                "1. Mirarla fijamente a los ojos",                  // Daño Máximo
                "2. Intentar tocar las lágrimas",                   // Daño Mínimo
                "3. Dejarle una flor marchita",                     // Pérdida de item
                "4. Rodearla de espaldas, sin mirarla jamás"        // Éxito
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Mirarla fijamente a los ojos":
                jugador.reducirCordura(danoLlantoMax);
                return "Te mira de vuelta y el horror de su tristeza te inunda. El terror es profundo. Pierdes **" + danoLlantoMax + " de Cordura**.";

            case "2. Intentar tocar las lágrimas":
                jugador.reducirCordura(danoAnsiedadMin);
                return "Sientes el frío del mármol. La ansiedad por el llanto ajeno te afecta. Pierdes **" + danoAnsiedadMin + " de Cordura**.";

            case "3. Dejarle una flor marchita":
                return "La estatua ignora tu gesto, pero te has quedado tanto tiempo que sientes que algo te roba la calma. Pierdes un objeto sin valor.";

            case "4. Rodearla de espaldas, sin mirarla jamás":
                return "Concentras tu voluntad en no verla y logras pasar con el pulso acelerado, pero a salvo. ¡Encuentro evadido!";

            default:
                return "Error de acción.";
        }
    }
}