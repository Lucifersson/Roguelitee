package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharcoReflejos extends Entidad {

    private final int danoDudaMax = 13;
    private final int danoMiedoMin = 8;

    public CharcoReflejos() {
        super("CHARCO_REFLEJOS", "Charco de Reflejos", "Un charco de agua perfectamente quieta y oscura.", "Hay un charco. Ves tu reflejo lleno de cicatrices que no tienes. ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Mirar fijamente a tu reflejo distorsionado",         // Daño Máximo
                "2. Tocar el agua con el dedo",                          // Daño Mínimo
                "3. Ignorarlo y saltar por encima",                       // Éxito
                "4. Hablar con tu reflejo"                               // Pérdida de turno
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Mirar fijamente a tu reflejo distorsionado":
                jugador.reducirCordura(danoDudaMax);
                return "Tu reflejo te susurra tus peores dudas. El impacto mental es brutal. Pierdes **" + danoDudaMax + " de Cordura**.";

            case "2. Tocar el agua con el dedo":
                jugador.reducirCordura(danoMiedoMin);
                return "El agua está helada. Sientes un miedo irracional. Pierdes **" + danoMiedoMin + " de Cordura**.";

            case "3. Ignorarlo y saltar por encima":
                return "Evitas el reflejo y la trampa. ¡Encuentro evadido!";

            case "4. Hablar con tu reflejo":
                return "Tu reflejo se ríe de ti y se niega a hablar. Pierdes un turno tratando de entender.";

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