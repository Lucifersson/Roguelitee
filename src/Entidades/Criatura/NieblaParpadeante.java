package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NieblaParpadeante extends Entidad {

    private final int danoVertigoMax = 12;
    private final int danoConfusionMin = 6;

    public NieblaParpadeante() {
        super("NIEBLA_PARPADEANTE",
                "Niebla Parpadeante",
                "Una niebla que desaparece y reaparece, distorsionando tu visión.",
                "La niebla te rodea, parpadeando al azar. Te duele la cabeza. ¿Qué harás?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Intentar seguir con la mirada sus movimientos",       // Daño Máximo
                "2. Lanzarle una roca al azar",                          // Daño Mínimo
                "3. Cerrar los ojos y caminar en línea recta",           // Éxito
                "4. Esperar a que se disipe sola"                        // Pérdida de item
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Intentar seguir con la mirada sus movimientos":
                jugador.reducirCordura(danoVertigoMax);
                return "Tu mente no puede procesar el parpadeo. El vértigo es intenso. Pierdes **" + danoVertigoMax + " de Cordura**.";

            case "2. Lanzarle una roca al azar":
                jugador.reducirCordura(danoConfusionMin);
                return "Fallaste. La niebla se ríe y te marea. Pierdes **" + danoConfusionMin + " de Cordura**.";

            case "3. Cerrar los ojos y caminar en línea recta":
                return "Al eliminar el estímulo visual, tu mente se calma y logras atravesarla antes de que reaparezca. ¡Encuentro evadido!";

            case "4. Esperar a que se disipe sola":
                return "Esperaste demasiado. La niebla te ha robado las pilas de tu linterna mientras te distraías.";

            default:
                return interaccionExtra(jugador, seleccion, this.eventosExtra);
        }
    }

    public String interaccionExtra (Jugador jugador, String seleccion, ArrayList<ArrayList<String>> eventosExtra) {
        if (!eventosExtra.isEmpty()) {
            if (eventosExtra.get(0).get(0) == "1" && seleccion.equals("5")) {

            }
            else if (eventosExtra.get(1).get(0) == "1" && seleccion.equals("6")) {

            }
            else if (eventosExtra.get(0).get(0) == "2" && seleccion.equals("5")) {

            }
            else if (eventosExtra.get(1).get(0) == "2" && seleccion.equals("6")) {

            }
        }
        return "No entiendes bien qué hacer.";
    }
}