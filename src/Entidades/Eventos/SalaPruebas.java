package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;
import java.util.Arrays;
import java.util.List;

public class SalaPruebas extends Entidad {

    public SalaPruebas() {
        super("EVENTO_SALA_PRUEBAS", "Sala de Pruebas",
                "Despiertas en una sala blanca con paredes brillantes y un altavoz en el techo.\n" +
                "Una voz metálica anuncia con entusiasmo:\n" +
                "“Bienvenido al Test de Persistencia Cognitiva número 33-C.\n",
                "Una voz calmada te pregunta:\n" +
                "“¿Te consideras apto para continuar con el experimento?”");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Preguntar si hay tarta",
                "2. Mentir",
                "3. Sugerir cosas obscenas",
                "4. Asentir y esperar instrucciones"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Preguntar si hay tarta":
                return "La voz suspira visiblemente incómoda. Guarda silencio unos segundos antes de abrir una puerta y dejarte libre.";
            case "2. Mentir":
                if (jugador.getInteligencia() > 10){
                    jugador.reducirIntimidacion(5);
                    return "Dices que no pasaste los tests cognitivos en el colegio. A veces se te cae la baba. **Pierdes 5 de Intimidación**";
                } else {
                    return "Dices que codificas con microcesador x264 slower con 8000 de bitrate CONSTANTE y que no se puede más. La camara te mira raro y te deja irte.";
                }
            case "3. Sugerir cosas obscenas":
                return "Le dices que es la mejor IA que has conocido, le preguntas si puede generar una imagen de los bos besándoos.\n" +
                        "La cámara te mira raro, pero... ¿acepta?";
            case "4. Asentir y esperar instrucciones":
                jugador.aumentarSuerte(3);
                return "La voz responde:\n" +
                        "“Gracias por su cooperación, sujeto #427.\n" +
                        "Su entusiasmo será registrado en el informe de participantes.”\n" +
                        "El suelo se abre y caes en el mismo camino de siempre. **Consigues 3 de Suerte**";
            default:
                return "No entiendes bien qué hacer.";
        }
    }
}
