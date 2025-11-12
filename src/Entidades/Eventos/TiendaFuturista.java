package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TiendaFuturista extends Entidad {

    public TiendaFuturista() {
        super("EVENTO_TIENDA_FUTURISTA", "Tienda Futurista",
                "Un dron flotante con voz de vendedor te sigue emitiendo luces LED.\n" +
                        "“¡Inversor visionario detectado! Compra NFTs de aire, cursos exclusivos de productividad y una IA que hará tu trabajo por ti (y el mío también).”",
                "¿El dron te apunta con una pantalla holográfica:\n" +
                        "“¿Quieres ser tu propio jefe en el metaverso?”");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Comprar NFTs",
                "2. Pedirle un curso gratuito de criptomonedas",
                "3. No comprar nada",
                "4. Preguntar por productos específicos"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Comprar NFTs":
                jugador.reducirInteligencia(3);
                return "El dron se ríe y se aleja a toda velocidad. El NFT desaparece en tus manos. **Pierdes 3 de Inteligencia**";
            case "2. Pedirle un curso gratuito de criptomonedas":
                jugador.aumentarCarisma(2);
                return "No aprendes a gestionar tus finanzas, pero mejora tu poder de convicción. **Ganas 2 de Carisma**";
            case "3. No comprar nada":
                return "Te alejas sin mirar atrás, evitando caer en la trampa del consumismo digital.";
            case "4. Preguntar por productos específicos":
                return "El dron te ofrece una suscripción premium a un asistente virtual por 25 créditos. Decides que no vale la pena.";
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
