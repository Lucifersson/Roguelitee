package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;
import java.util.Arrays;
import java.util.List;

public class LibroEnfadado extends Entidad {

    private final int danoConocimientoMax = 10;
    private final int danoFrustracionMin = 6;

    public LibroEnfadado() {
        super("LIBRO_ENFADADO",
                "Libro Enfadado",
                "Un tomo encuadernado en piel oscura que vibra con ira sorda.",
                "Hay un libro abierto sobre un pedestal que grita un lenguaje inentendible. ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() { // Public
        return Arrays.asList(
                "1. Intentar leer un pasaje en voz alta",           // Daño Máximo
                "2. Arrancarle una página",                         // Daño Mínimo
                "3. Regañarlo por ser maleducado",                  // Éxito
                "4. Ponerle un marcapáginas"                        // Pérdida de item
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Intentar leer un pasaje en voz alta":
                jugador.reducirCordura(danoConocimientoMax);
                return "El conocimiento prohibido te quema la mente. Pierdes **" + danoConocimientoMax + " de Cordura**.";

            case "2. Arrancarle una página":
                jugador.reducirCordura(danoFrustracionMin);
                return "El libro chilla, y la frustración te hace olvidar tu objetivo. Pierdes **" + danoFrustracionMin + " de Cordura**.";

            case "3. Regañarlo por ser maleducado":
                return "El libro se avergüenza y se cierra de golpe. Se retira. ¡Encuentro evadido!";

            case "4. Ponerle un marcapáginas":
                return "El libro se come el marcapáginas. Te has quedado paralizado por el asco. Pierdes un marcapáginas valioso.";

            default:
                return "Error de acción.";
        }
    }
}