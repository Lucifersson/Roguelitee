package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GusanoHielo extends Entidad {

    private final int danoCongelacionMax = 11;
    private final int danoFrioMin = 5;

    public GusanoHielo() {
        super("GUSANO_HIELO",
                "Gusano de Hielo",
                "Una gran larva translúcida que se desliza bajo el hielo.",
                "El suelo cruje bajo tus pies y ves una sombra moviéndose por debajo. ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Quedarse totalmente quieto para evitar vibraciones", // Daño Máximo
                "2. Saltarle encima con fuerza",                          // Daño Mínimo
                "3. Dejarle un trozo de pescado",                         // Pérdida de item
                "4. Correr dando grandes zancadas"                       // Éxito
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1":
                jugador.reducirCordura(danoCongelacionMax);
                return "Te quedas quieto, pero el Gusano ataca donde siente más masa. El terror te paraliza. Pierdes **" + danoCongelacionMax + " de Cordura**.";

            case "2":
                jugador.reducirCordura(danoFrioMin);
                return "Fallaste el salto y te salpica agua helada. La sorpresa te confunde. Pierdes **" + danoFrioMin + " de Cordura**.";

            case "3":
                return "El Gusano se come el pescado, pero te diste demasiado. Pierdes un turno.";

            case "4":
                return "Mueves la masa rápidamente, confundiendo al Gusano. Logras escapar de su rango de ataque. ¡Encuentro evadido!";

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