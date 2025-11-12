package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReunionNPCs extends Entidad {

    public ReunionNPCs() {
        super("EVENTO_REUNION_NPCS", "Reunión de NPCs",
                "Te encuentras en una sala llena de personas que cuchichean entre ellos sobre tu presencia. \n" +
                "Algunos de ellos los has visto antes en tus aventuras, incluso han interactuado contigo.\n" +
                "Otros parecen nuevos, pero todos comparten una mirada inquietante, como si supieran algo que tú no sabes.",
                "Están discutiendo tu reputación entre misiones. ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Entrar a la reunión",
                "2. Escuchar en silencio",
                "3. Interrumpir gritando",
                "4. Ser Non-chalant"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Entrar a la reunión":
                jugador.aumentarCarisma(1);
                return "'¿Cómo anda el gallinero? pronuncias en voz alta.\n" +
                        "Todos te miran y cambian rápidamente de tema. Recitan frases como si fueran guionizados: ‘Buen viajero, ¿deseas una misión?’. **Ganas 1 de Carisma**";
            case "2. Escuchar en silencio":
                jugador.reducirCordura(5);
                return "Escuchas fragmentos de conversación que te hacen cuestionar tu realidad: ‘¿Realmente existe el libre albedrío en este mundo?’. Te sientes observado. **Pierdes 5 de Cordura**";
            case "3. Interrumpir gritando":
                if (jugador.getIntimidacion() >= 10) {
                    jugador.aumentarIntimidacion(1);
                    return "Tu grito resuena en la sala, y todos huyen despavoridos. Has sembrado el caos. **Ganas 1 de Intimidación**";
                } else {
                    jugador.reducirCarisma(3);
                    return "Intentas interrumpir, pero tu voz se quiebra (que pringado). Se ríen de ti y te sientes más pequeño. **Pierdes 3 de Carisma**";
                }
            case "4. Ser Non-chalant":
                return "Tu aura ocupa toda la habitación. Te extienden una alfombra roja a tu paso.";
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
