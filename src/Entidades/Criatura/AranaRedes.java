package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AranaRedes extends Entidad {

    private final int danoAtaqueMax = 10;
    private final int danoPegajosoMin = 5;

    public AranaRedes() {
        super("ARANA_REDES", "Araña de Redes", "Una araña que teje redes plateadas y pegajosas.", "Una enorme red te bloquea. La Araña te mira fijamente. ¿Qué harás?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Intentar romper la red con las manos",           // Daño Máximo
                "2. Lanzarle una antorcha",                         // Daño Mínimo
                "3. Engrasar tus manos y cortar la red lentamente",  // Éxito
                "4. Esperar a que se vaya"                          // Pérdida de turno
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1":
                jugador.reducirCordura(danoAtaqueMax);
                return "Te enredas totalmente en la red. El pánico te hace perder la cabeza. Pierdes **" + danoAtaqueMax + " de Cordura**.";

            case "2":
                jugador.reducirCordura(danoPegajosoMin);
                return "El fuego no la asusta. Ella te lanza una hebra pegajosa que te ensucia. Pierdes **" + danoPegajosoMin + " de Cordura**.";

            case "3":
                return "El aceite hace que el corte sea fácil. Logras atravesar la red sin hacer ruido. ¡Encuentro evadido!";

            case "4":
                return "La araña no se mueve. Pierdes la esperanza y un turno completo.";

            default:
                return interaccionExtra(jugador, seleccion, this.eventosExtra);
        }
    }

    public String interaccionExtra (Jugador jugador, String seleccion, ArrayList<ArrayList<String>> eventosExtra) {
        if (!eventosExtra.isEmpty()) {
            if (eventosExtra.size() != 2 && seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "1") {
                    jugador.aumentarInteligencia(2);
                    return "Logras cortar la red con el cuchillo sin alertar a la araña. Te sientes bastante más inteligente de lo que eres. **+2 inteligencia**";
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "1") {
                    jugador.aumentarInteligencia(2);
                    return "Logras cortar la red con el cuchillo sin alertar a la araña. Te sientes bastante más inteligente de lo que eres. **+2 inteligencia**";
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("6")) {
                if (eventosExtra.get(1).get(0) == "1") {
                    jugador.aumentarInteligencia(2);
                    return "Logras cortar la red con el cuchillo sin alertar a la araña. Te sientes bastante más inteligente de lo que eres. **+2 inteligencia**";
                }
                else if (eventosExtra.get(1).get(0) == "2") {

                }
            }
        }
        return "No entiendes bien qué hacer.";
    }
}