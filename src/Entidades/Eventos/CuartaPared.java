package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CuartaPared extends Entidad {

    public CuartaPared() {
        super("EVENTO_CUARTA_PARED", "Cuarta Pared",
                "Una voz en la oscuridad dice:\n" +
                        "“Sabes que solo estás escribiendo comandos, ¿verdad?\n" +
                        "Que cada ‘interacción’ es solo un switch-case esperando tu input.”\n" +
                        "El aire huele a descompilado.",
                "“¿DESEAS CONTINUAR JUGANDO?”");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Aceptar la verdad",
                "2. Me la pela",
                "3. Ligar con la voz",
                "4. Alt + F4"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Aceptar la verdad":
                return "Aceptar la realidad te libera. La voz se desvanece y sientes una paz interior. \n" +
                        "La pantalla se apaga lentamente... **Desbloqueas el logro Romper la cuarta pared**"; /*FIN SECRETO*/
            case "2. Me la pela":
                jugador.reducirCordura(5);
                return "No cambia nada. Pero la voz sigue ahí, esperando tu aceptación. **Pierdes 5 de Cordura**";
            case "3. Ligar con la voz":
                return "“Hola guapa”.\n" +
                        "La voz te ghostea. \n" +
                        "Sigues tu camino quejandote de todas las mujeres y replanteándote tu sexualidad";
            case "4. Alt + F4":
                jugador.reducirSuerte(3);
                return "“No puedes escapar tan fácilmente.” **Pierdes 3 de Suerte**";
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
