package src.Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.Arrays;
import java.util.List;

public class AutomataRoto extends Entidad {

    // ... Atributos ID, NOMBRE, DESCRIPCION, PREGUNTA ...
    private final int danoMax = 10;
    private final int danoMin = 5;

    public AutomataRoto() {
        super("AUTOMATA_ROTO", "Autómata Roto", "Un viejo robot de vigilancia con chispas...", "El autómata se detiene... ¿Qué harás?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Intentar tumbarlo de un empujón",           // Consecuencia Fija: Daño Máximo
                "2. Tirarle una tuerca a sus circuitos",         // Consecuencia Fija: Daño Mínimo
                "3. Darle una Orden en Latín",                  // Consecuencia Fija: Ganancia/Pérdida de turno
                "4. Leer el Manual del Robot en voz alta"       // Consecuencia Fija: Ganancia/Pérdida de turno
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Intentar tumbarlo de un empujón":
                jugador.reducirCordura(danoMax);
                return "Tu empujón solo lo enfurece. Te electrocuta con una descarga fuerte. **Recibes " + danoMax + " de daño.**";

            case "2. Tirarle una tuerca a sus circuitos":
                jugador.reducirCordura(danoMin);
                return "Fallaste el tiro. La tuerca rebota y te golpea en la cabeza. **Recibes " + danoMin + " de daño.**";

            case "3. Darle una Orden en Latín":
                return "El autómata se queda paralizado por un momento, emite un *BEEP* y vuelve a su ruta. Ganas un turno libre para pasar.";

            case "4. Leer el Manual del Robot en voz alta":
                return "Te saltaste un paso vital del manual. El autómata te confunde con su jerga robótica. Pierdes un turno.";
            default:
                return "Error de acción.";
        }
    }
}