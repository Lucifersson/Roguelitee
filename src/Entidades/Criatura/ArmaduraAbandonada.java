package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArmaduraAbandonada extends Entidad {

    private final int danoMazaMax = 12;
    private final int danoEmpujonMin = 6;

    public ArmaduraAbandonada() {
        super("ARMADURA_ABANDONADA",
                "Armadura Abandonada",
                "Una mole de placas de acero oxidado que se mueve lentamente...",
                "Una armadura vacía se interpone en tu camino... ¿Qué harás?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Intentar romperle el yelmo de un golpe",
                "2. Tirarle un plátano a los pies",
                "3. Preguntarle si le cuesta subir escaleras",
                "4. Rodearla lentamente por el lateral"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1":
                jugador.reducirCordura(danoMazaMax); // <<-- CAMBIO A CORDURA
                return "Tu golpe rebota inútilmente. El miedo al fracaso te abruma. Pierdes **" + danoMazaMax + " de Cordura**.";

            case "2":
                jugador.reducirCordura(danoEmpujonMin); // <<-- CAMBIO A CORDURA
                return "La armadura resbala, pero el chirrido es aterrador. Tu mente se resiente. Pierdes **" + danoEmpujonMin + " de Cordura**.";

            case "3":
                return "La armadura emite un chirrido furioso. Te obliga a retroceder y buscar otra ruta. Pierdes un turno.";

            case "4":
                return "Dado que se mueve muy lento, puedes rodearla fácilmente sin que te alcance. ¡Encuentro evadido!";

            default:
                return interaccionExtra(jugador, seleccion, this.eventosExtra);
        }
    }

    public String interaccionExtra (Jugador jugador, String seleccion, ArrayList<ArrayList<String>> eventosExtra) {
        if (!eventosExtra.isEmpty()) {
            if (eventosExtra.size() != 2 && seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "1") {
                    jugador.aumentarCarisma(3);
                    return "Pasas a su lado con el traje y se activa. Te preparas para recibir un golpe pero empieza a hablar y te dice que estás muy elegante. Te sientes más carismático. **+3 de carisma**";
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "1") {
                    jugador.aumentarCarisma(3);
                    return "Pasas a su lado con el traje y se activa. Te preparas para recibir un golpe pero empieza a hablar y te dice que estás muy elegante. Te sientes más carismático. **+3 de carisma**";
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("6")) {
                if (eventosExtra.get(1).get(0) == "1") {
                    jugador.aumentarCarisma(3);
                    return "Pasas a su lado con el traje y se activa. Te preparas para recibir un golpe pero empieza a hablar y te dice que estás muy elegante. Te sientes más carismático. **+3 de carisma**";
                }
                else if (eventosExtra.get(1).get(0) == "2") {

                }
            }
        }
        return "No entiendes bien qué hacer.";
    }
}