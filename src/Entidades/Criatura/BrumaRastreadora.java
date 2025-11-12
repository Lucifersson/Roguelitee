package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrumaRastreadora extends Entidad {

    // ... Atributos ID, NOMBRE, DESCRIPCION, PREGUNTA ...
    private final int danoMax = 12;
    private final int danoMin = 7;

    public BrumaRastreadora() {
        super("BRUMA_RASTREADORA", "Bruma Rastreadora", "Una niebla helada...", "Sientes un frío intenso... ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Tocar la Bruma por Curiosidad",                  // Consecuencia Fija: Daño Máximo
                "2. Cruzar Rápido por el Centro",                    // Consecuencia Fija: Daño Mínimo
                "3. Preguntarle si está Perdida",                    // Consecuencia Fija: Ganancia/Pérdida de turno
                "4. Ponerse una Máscara y Caminar Lento"             // Consecuencia Fija: Ganancia/Pérdida de turno
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1":
                jugador.reducirCordura(danoMax);
                return "La Bruma te envuelve con furia, te quema con el frío. Recibes un golpe total de **" + danoMax + " de daño**.";

            case "2":
                jugador.reducirCordura(danoMin);
                return "Te resbalas. La Bruma te salpica con escarcha, pero escapas rápido. Recibes **" + danoMin + " de daño**.";

            case "3":
                return "La Bruma te ignora, el frío te hace perder el equilibrio y caes al suelo. Pierdes un turno.";

            case "4":
                return "La máscara funciona a la perfección. La Bruma te rodea, pero te ignora. ¡Has evadido el peligro!";
            default:
                return interaccionExtra(jugador, seleccion, this.eventosExtra);
        }
    }

    public String interaccionExtra (Jugador jugador, String seleccion, ArrayList<ArrayList<String>> eventosExtra) {
        if (!eventosExtra.isEmpty()) {
            if (eventosExtra.size() != 2 && seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "4") {
                    jugador.aumentarInteligencia(3);
                    return "Te das cuenta de que estabas sobrereaccionando a la situación y te calmas. Pasas como si nada.**Ganas 3 de inteligencia**";
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "4") {
                    jugador.aumentarInteligencia(3);
                    return "Te das cuenta de que estabas sobrereaccionando a la situación y te calmas. Pasas como si nada.**Ganas 3 de inteligencia**";
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("6")) {
                if (eventosExtra.get(1).get(0) == "4") {
                    jugador.aumentarInteligencia(3);
                    return "Te das cuenta de que estabas sobrereaccionando a la situación y te calmas. Pasas como si nada.**Ganas 3 de inteligencia**";
                }
                else if (eventosExtra.get(1).get(0) == "2") {

                }
            }
        }
        return "No entiendes bien qué hacer.";
    }
}