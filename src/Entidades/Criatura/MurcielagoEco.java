package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MurcielagoEco extends Entidad {

    private final int danoSonicoMax = 11;
    private final int danoVertigoMin = 5;

    public MurcielagoEco() {
        super("MURCIELAGO_ECO",
                "Murciélago Eco",
                "Una criatura voladora de gran envergadura y ojos ciegos.",
                "Un chillido agudo resuena en la caverna. Un Murciélago te ha detectado. ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() { // Public
        return Arrays.asList(
                "1. Gritarle de vuelta para asustarlo",              // Daño Máximo
                "2. Intentar golpearlo con una rama",                   // Daño Mínimo
                "3. Tirarle una piedra a un muro lejano",               // Pérdida de turno
                "4. Quedarte en absoluto silencio y arrastrarte"        // Éxito
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1":
                jugador.reducirCordura(danoSonicoMax);
                return "Tu grito solo intensifica su eco. El dolor sónico es insoportable. Pierdes **" + danoSonicoMax + " de Cordura**.";

            case "2":
                jugador.reducirCordura(danoVertigoMin);
                return "El murciélago esquiva la rama. El remolino de aire te causa vértigo. Pierdes **" + danoVertigoMin + " de Cordura**.";

            case "3":
                return "La distracción funciona, pero el eco te confunde. Pierdes un turno buscando el camino.";

            case "4":
                return "Te mueves con un silencio sepulcral. El murciélago no te detecta y pasa de largo. ¡Encuentro evadido!";

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