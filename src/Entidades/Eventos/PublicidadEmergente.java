package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PublicidadEmergente extends Entidad {

    public PublicidadEmergente() {
        super("EVENTO_PUBLICIDAD_EMERGENTE", "Publicidad Emergente",
                "Escuchas gritos provenientes de un tenderete al lado del camino. “¡Cordura buena, bonita y barata, mi alma!”\n" +
                        "Una mujer agita un ramo de romero y varias pulseras. “Te limpio el aura y te subo la Cordura, niño. ¡Solo hoy, a mitad de precio!”",
                "La gitana sonríe mostrando demasiados dientes. ¿Quieres una bendición?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Comprarle Cordura",
                "2. Pasar de largo",
                "3. Quejarte por la publicidad invasiva",
                "4. Mostrar interés educadamente"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Comprarle Cordura":
                jugador.reducirCordura(5);
                return "Sacas el dinero, pero la gitana te mira con desprecio. Te quedas sin dinero y pierdes Cordura. **Pierdes 5 de Cordura.**";
            case "2. Pasar de largo":
                jugador.reducirSuerte(5);
                return "“¡Ay de ti, alma curiosa! Desde hoy, cada vez que falles un salto, escucharás mi risa gitana en el viento. ¡Jajaja, mala suerte, viajero!” **Pierdes 5 de Suerte.**";
            case "3. Quejarte por la publicidad invasiva":
                jugador.reducirCarisma(3);
                return "Te quejas en voz alta y la gitana te escupe con desprecio desde su tienda. ¡Uf! Qué humillación. **Pierdes 3 de Carisma.**";
            case "4. Mostrar interés educadamente":
                jugador.aumentarSuerte(5);
                return "Tus ojos brillan ante el romero bendito y la gitana sonríe, complacida. Te entrega el romero con un guiño misterioso. **Ganas 5 de Suerte**";
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
