package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NPCParking extends Entidad {
    // A MODIFICAR

    public NPCParking() {
        super("EVENTO_NPC_PARKING", "NPC del Parking",
                "Encuentras a un NPC apoyado en un coche que no existe, con un cigarro apagado en la mano.\n" +
                        "“Hermano, esto antes era un boss fight. Ahora soy lore opcional.”",
                "¿Qué haces con el NPC deprimido?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Preguntarle qué le pasó",
                "2. Darle un mechero",
                "3. Contarle tu vida",
                "4. Intentar motivarlo con frases de Mr.Wonderful"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) throws InterruptedException {
        switch (seleccion) {
            case "1. Preguntarle qué le pasó":
                jugador.aumentarCordura(3);
                return " **Ganas 3 de Cordura.**";
            case "2. Darle un mechero":
                jugador.reducirCordura(5);
                return " **Pierdes 5 de Cordura.**";
            case "3. Contarle tu vida":
                jugador.aumentarIntimidacion(2);
                return " **Ganas 2 de Intimidación.**";
            case "4. Intentar motivarlo con frases de Mr.Wonderful":
                jugador.aumentarCarisma(1);
                return " **Ganas 1 de Carisma.**";
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
