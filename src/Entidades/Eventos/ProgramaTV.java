package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramaTV extends Entidad {

    public ProgramaTV() {
        super("EVENTO_PROGRAMA_TV", "Programa de TV",
                "Apareces en un plató con una mesa reluciente. Frente a ti, un presentador sonríe mientras peina su pelirroja melena.",
                "Comienza a entrevistarte con preguntas extrañas. ¿Cómo respondes?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Responder con educación",
                "2. Hacer un chiste incómodo",
                "3. Preguntar ¿cuántos dedos tiene el presentador?",
                "4. Decirle que si tuvieras el culo de Mónica Naranjo darías el programa de espaldas"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Responder con educación":
                return "Sonríes con educación y dices algo neutro.\n" +
                        "Él asiente exageradamente, te interrumpe y continua con las preguntas.";
            case "2. Hacer un chiste incómodo":
                jugador.reducirCarisma(1);
                return "Dices algo que suena mejor en tu cabeza.\n" +
                        "El presentador finge reírse, el público aplaude tarde y una gota de sudor te cae por la sien. **Pierdes 1 de Carisma**";
            case "3. Preguntar ¿cuántos dedos tiene el presentador?":
                jugador.aumentarCarisma(1);
                return "El presentador se detiene, te mira fijamente y da paso a los anuncios.\n" +
                        "Cuando vuelves, ya no está. **Ganas 1 de Carisma**";
            case "4. Decirle que si tuvieras el culo de Mónica Naranjo darías el programa de espaldas":
                return "El presentador se queda paralizado, luego te mira con una mezcla de horror y admiración.\n" +
                        "Finalmente, te invita a sentarte y hablar del tema durante el resto del programa. **Consigues el logro 'De espaldas'**";
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
