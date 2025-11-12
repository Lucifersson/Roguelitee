package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TentaculoLanguido extends Entidad {

    private final int danoRechazoMax = 10;
    private final int danoAscoMin = 5;

    public TentaculoLanguido() {
        super("TENTACULO_LANGUIDO",
                "Tentáculo Lánguido",
                "Un tentáculo que cuelga, con la punta temblando ligeramente.",
                "Un tentáculo pálido te bloquea el paso, moviéndose con tristeza. ¿Qué harás?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Golpearlo con un palo",                          // Daño Máximo
                "2. Ponerle un cartel de 'No Tocar'",                // Daño Mínimo
                "3. Acariciarlo suavemente",                         // Éxito
                "4. Ignorarlo y pasar por debajo"                    // Pérdida de turno
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1":
                jugador.reducirCordura(danoRechazoMax);
                return "El tentáculo grita de dolor. El trauma sónico te hace daño. Pierdes **" + danoRechazoMax + " de Cordura**.";

            case "2":
                jugador.reducirCordura(danoAscoMin);
                return "El tentáculo se ofende con el cartel. Te salpica con mucosidad que te da asco. Pierdes **" + danoAscoMin + " de Cordura**.";

            case "3":
                return "El tentáculo se calma ante tu toque y se retira feliz. ¡Encuentro evadido!";

            case "4":
                return "El tentáculo te ignora, pero en un acto de rabia pasiva, te agarra el tobillo y te obliga a esperar. Pierdes un turno.";

            default:
                return interaccionExtra(jugador, seleccion, this.eventosExtra);
        }
    }

    public String interaccionExtra (Jugador jugador, String seleccion, ArrayList<ArrayList<String>> eventosExtra) {
        if (!eventosExtra.isEmpty()) {
            if (eventosExtra.size() != 2 && seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "1") {

                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "1") {

                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("6")) {
                if (eventosExtra.get(1).get(0) == "1") {

                }
                else if (eventosExtra.get(1).get(0) == "2") {

                }
            }
        }
        return "No entiendes bien qué hacer.";
    }
}