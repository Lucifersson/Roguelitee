package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GolemMusgo extends Entidad {

    private final int danoAplastamientoMax = 12;
    private final int danoEsporasMin = 6;

    public GolemMusgo() {
        super("GOLEM_MUSGO",
                "Gólem de Musgo",
                "Una mole lenta cubierta de vegetación...",
                "De repente, una gran roca cubierta de musgo se mueve... ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Empujarlo con todas tus fuerzas",
                "2. Arrancarle un trozo de musgo",
                "3. Cantarle una Canción de Cuna",
                "4. Esperar pacientemente a que se mueva solo"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1":
                jugador.reducirCordura(danoAplastamientoMax); // <<-- CAMBIO A CORDURA
                return "El Gólem ni se inmuta. El esfuerzo te deja mentalmente exhausto. Pierdes **" + danoAplastamientoMax + " de Cordura**.";

            case "2":
                jugador.reducirCordura(danoEsporasMin); // <<-- CAMBIO A CORDURA
                return "El musgo libera esporas tóxicas. El pánico a la infección te sobrepasa. Pierdes **" + danoEsporasMin + " de Cordura**.";

            case "3":
                return "Tu canto es horrible. El Gólem se irrita por el ruido y te rocía con agua fangosa. Pierdes un turno de limpieza.";

            case "4":
                return "Te quedas quieto y esperas. Después de unos minutos, el Gólem se mueve lentamente hacia otro lado. ¡Encuentro evadido!";

            default:
                return interaccionExtra(jugador, seleccion, this.eventosExtra);
        }
    }

    public String interaccionExtra (Jugador jugador, String seleccion, ArrayList<ArrayList<String>> eventosExtra) {
        if (!eventosExtra.isEmpty()) {
            if (eventosExtra.size() != 2 && seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "10") {
                    jugador.aumentarIntimidacion(3);
                    return "Le dices que en realidad no es un verdadero gólem y que fue culpa suya que su mujer se llevara la casa y los niños. Empieza a llorar y se aparta de la puerta. No sientes ningún tipo de remordimiento.**+3 de intimidación**";
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "10") {
                    jugador.aumentarIntimidacion(3);
                    return "Le dices que en realidad no es un verdadero gólem y que fue culpa suya que su mujer se llevara la casa y los niños. Empieza a llorar y se aparta de la puerta. No sientes ningún tipo de remordimiento.**+3 de intimidación**";
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("6")) {
                if (eventosExtra.get(1).get(0) == "10") {
                    jugador.aumentarIntimidacion(3);
                    return "Le dices que en realidad no es un verdadero gólem y que fue culpa suya que su mujer se llevara la casa y los niños. Empieza a llorar y se aparta de la puerta. No sientes ningún tipo de remordimiento.**+3 de intimidación**";
                }
                else if (eventosExtra.get(1).get(0) == "2") {

                }
            }
        }
        return "No entiendes bien qué hacer.";
    }
}