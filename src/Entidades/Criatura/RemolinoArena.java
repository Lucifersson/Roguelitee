package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;
import java.util.Arrays;
import java.util.List;

public class RemolinoArena extends Entidad {

    private final int danoAbrasiónMax = 10;
    private final int danoOcularMin = 5;

    public RemolinoArena() {
        super("REMOLINO_ARENA",
                "Remolino de Arena",
                "Una espiral de arena fina que se mueve erráticamente...",
                "Un violento remolino de arena te bloquea el camino... ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Saltar por encima del centro",
                "2. Intentar arrojarle agua o barro",
                "3. Tirar un mapa viejo a su interior",
                "4. Quedarse perfectamente inmóvil, imitando una duna"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Saltar por encima del centro":
                jugador.reducirCordura(danoAbrasiónMax); // <<-- CAMBIO A CORDURA
                return "Pierdes el equilibrio. El remolino te golpea. El vértigo te asalta. Pierdes **" + danoAbrasiónMax + " de Cordura**.";

            case "2. Intentar arrojarle agua o barro":
                jugador.reducirCordura(danoOcularMin); // <<-- CAMBIO A CORDURA
                return "Solo consigues enfurecerlo. El remolino lanza arena a tus ojos. La desesperación te agota. Pierdes **" + danoOcularMin + " de Cordura**.";

            case "3. Tirar un mapa viejo a su interior":
                return "La arena se 'come' el mapa. El remolino continúa girando, y ahora has perdido tu orientación. Pierdes tu mapa.";

            case "4. Quedarse perfectamente inmóvil, imitando una duna":
                return "Te quedas quieto como una roca. El remolino pasa de largo, creyendo que eres parte del paisaje. ¡Encuentro evadido!";

            default:
                return "Error de acción.";
        }
    }
}