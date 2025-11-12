package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuzBurlona extends Entidad {

    private final int danoDesesperacionMax = 11;
    private final int danoConfusiónMin = 5;

    public LuzBurlona() {
        super("LUZ_BURLONA",
                "Luz Burlona",
                "Una pequeña luz flotante que baila y parpadea con malicia.",
                "Una luz prometedora aparece en la oscuridad y te invita a seguirla. ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() { // Public
        return Arrays.asList(
                "1. Correr tras ella gritando",                     // Daño Máximo
                "2. Acercarse a ver si ilumina un camino",          // Daño Mínimo
                "3. Silbarle una canción popular",                  // Pérdida de turno
                "4. Ignorarla completamente y caminar a ciegas"     // Éxito
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1":
                jugador.reducirCordura(danoDesesperacionMax);
                return "Corres y caes en un foso. La luz se ríe. La desesperación te consume. Pierdes **" + danoDesesperacionMax + " de Cordura**.";

            case "2":
                jugador.reducirCordura(danoConfusiónMin);
                return "Te confundes con su parpadeo errático, desorientándote. Pierdes **" + danoConfusiónMin + " de Cordura**.";

            case "3":
                return "La luz te ignora y te guía en círculos, perdiendo tiempo vital. Pierdes un turno.";

            case "4":
                return "Caminas con cautela en dirección opuesta al foco de luz. Eres ignorado y puedes pasar.";

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