package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Item;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemandaFontanero extends Entidad {

    public DemandaFontanero() {
        super("EVENTO_DEMANDA_FONTANERO", "Demanda del Fontanero",
                "Un séquito de abogados en traje pixelado se acerca con carpetas rojas. Uno de ellos ajusta unos guantes blancos con gesto teatral: “Reclamamos por uso no autorizado de un personaje con bigote.” \n" +
                        "Recuerdas entonces aquel tweet donde, en un arrebato de nostalgia, usaste la imagen de un famoso fontanero para tu avatar durante meses. Ahora te están demandando por ello.",
                "¿Cómo respondes a la demanda?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Negar toda relación: 'Mi fontanero es diferente.'",
                "2. Hacerte amigo del fontanero y firmar un trato comercial",
                "3. Convertir la demanda en un circo mediático y sacarle provecho",
                "4. Huir y cambiar tu avatar"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Negar toda relación: 'Mi fontanero es diferente.'":
                return "Los abogados no se dejan engañar fácilmente. Insisten en que tu avatar es una copia descarada. Pierdes el caso y te ves obligado a pagar una multa considerable.";
            case "2. Hacerte amigo del fontanero y firmar un trato comercial":
                return "Logras un acuerdo amistoso con la compañía del fontanero. Te entregan una caja con una seta mágica como compensación por el malentendido."; /*AÑADE OBJETO*/
            case "3. Convertir la demanda en un circo mediático y sacarle provecho":
                jugador.aumentarInteligencia(3);
                return "Tu historia se vuelve viral. Ganas seguidores y patrocinadores **Ganas 3 de Inteligencia**.";
            case "4. Huir y cambiar tu avatar":
                return "Decides que no vale la pena el problema legal. Cambias tu avatar y te alejas de la controversia, aunque pierdes algo de credibilidad en el proceso.";
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
