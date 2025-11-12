package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PortalDuda extends Entidad {

    private final int danoDudaMax = 15;
    private final int danoVacioMin = 8;

    public PortalDuda() {
        super("PORTAL_DUDA", "Portal de la Duda", "Un pequeño agujero negro que irradia incertidumbre.", "Un pequeño vórtice te bloquea. Te hace dudar de todo. ¿Qué harás?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
            "1. Intentar saltar directamente a través del portal",       // Daño Máximo
            "2. Mirar dentro y preguntarse 'qué es'",                    // Daño Mínimo
            "3. Resolver un acertijo matemático simple en voz alta",     // Éxito
            "4. Esperar a que la duda se disipe"                         // Pérdida de turno
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1":
                jugador.reducirCordura(danoDudaMax);
                return "El portal te escupe de vuelta. Sientes la nada. La absoluta certeza de la duda te destroza. Pierdes **" + danoDudaMax + " de Cordura**.";

            case "2":
                jugador.reducirCordura(danoVacioMin);
                return "Sientes el vacío. La falta de propósito te perturba. Pierdes **" + danoVacioMin + " de Cordura**.";

            case "3":
                return "La lógica pura destruye la incertidumbre del portal. Se disipa temporalmente. ¡Encuentro evadido!";

            case "4":
                return "La espera solo aumenta tu incertidumbre. Pierdes un turno en un estado de parálisis mental.";

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