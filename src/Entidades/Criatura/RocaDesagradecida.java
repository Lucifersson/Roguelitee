package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RocaDesagradecida extends Entidad {

    private final int danoVerguenzaMax = 11;
    private final int danoInsultoMin = 5;

    public RocaDesagradecida() {
        super("ROCA_DESAGRADECIDA",
                "Roca Desagradecida",
                "Una roca que habla con voz lastimera y quejumbrosa.",
                "Una roca en el camino te susurra: 'Ayúdame, por favor. Estoy atascada.' ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Intentar levantarla rápidamente",                     // Daño Máximo
                "2. Ponerle una rodilla para empujarla",                 // Daño Mínimo
                "3. Ignorarla y caminar despacio",                       // Éxito
                "4. Darle un discurso motivacional"                       // Pérdida de item
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Intentar levantarla rápidamente":
                jugador.reducirCordura(danoVerguenzaMax);
                return "La Roca se queja de que la lastimas. Te llama torpe. La vergüenza te inunda. Pierdes **" + danoVerguenzaMax + " de Cordura**.";

            case "2. Ponerle una rodilla para empujarla":
                jugador.reducirCordura(danoInsultoMin);
                return "La Roca te insulta por tocarla con tus 'sucios pantalones'. Pierdes **" + danoInsultoMin + " de Cordura**.";

            case "3. Ignorarla y caminar despacio":
                return "La Roca se queja por un momento, pero se da cuenta de que ya pasaste y se calla. ¡Encuentro evadido!";

            case "4. Darle un discurso motivacional":
                return "La Roca se ofende por tu 'superioridad moral' y te roba un objeto valioso mientras te distrae.";

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