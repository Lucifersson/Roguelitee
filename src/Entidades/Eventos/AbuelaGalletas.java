package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.Arrays;
import java.util.List;

public class AbuelaGalletas extends Entidad {

    public AbuelaGalletas() {
        super("EVENTO_ABUELA_GALLETAS", "Abuela Cocina Galletas",
                "En mitad del camino, una abuela sonriente amasa galletas sobre una mesa de madera.\n" +
                        "El aire huele a azúcar, mantequilla y chocolate. \n" +
                        "“¿Quieres probar una?” te dice con una voz dulce." +
                        "A su alrededor, otras abuelas idénticas hornean en silencio, mirando al horizonte.",
                "Huele bien, ¿verdad? No pasa nada si tomas solo una… ¿o dos?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Comer una galleta",
                "2. Ligar con la abuela",
                "3. Preguntar de dónde salen tantas abuelas",
                "4. Intentar apagar los hornos"
        );
    }

    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1":
                if (jugador.getCordura() < 5) {
                    jugador.reducirCordura(2);
                    return "La galleta no estaba bien horneada. Huyes buscando un baño urgentemente. No llegas. **Pierdes 2 de Cordura**";
                } else {
                    return "Cruje perfecta. Es la mejor galleta que has probado.\n" +
                            "De pronto, otra abuela aparece y te ofrece otra. Y otra.\n" +
                            "El suelo se cubre de galletas. **Consigues el logro 'Demasiadas Galletas'**";
                }
            case "2":
                if (jugador.getGenero().equals("Mujer")) {
                    jugador.aumentarCarisma(2);
                    return "La abuela te escucha atentamente y te sigue el juego.\n" +
                            "Parece que la tienes en el bote. *Ganas 2 de Carisma**";
                }else{
                    jugador.reducirCarisma(2);
                    return "La abuela te escucha atentamente, pero te pone el dedo en la boca y te manda callar.\n" +
                            "Está en la otra acera **Pierdes 2 de Carisma**";
                }
            case "3":
                jugador.reducirCordura(2);
                return "Las abuelas se detienen y ter miran fijamente." +
                        "Su mirada te atraviesa el alma.\n" +
                        "Sientes que algo oscuro se instala en tu mente. **Pierdes 2 de Cordura**";
            case "4":
                jugador.aumentarIntimidacion(2);
                return "Al intentar apagar uno, una abuela te agarra la mano con fuerza.\n" +
                        "Te mira con ojos llenos de tristeza... **Ganas 2 de Intimidación**";
            default:
                interaccionExtra(jugador, seleccion, cantExtra);
        }
        return "No entiendes bien qué hacer";
    }

    public String interaccionExtra (Jugador jugador, String seleccion, int cantExtra) {
        if (seleccion.equals("5")) {
            return "Pasa algo";
        }else {
            return "No entiendes bien qué hacer.";
        }
    }
}
