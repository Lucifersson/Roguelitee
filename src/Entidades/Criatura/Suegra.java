package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Suegra extends Entidad {

    // ... Atributos ID, NOMBRE, DESCRIPCION, PREGUNTA ...
    private final int danoMax = 12;
    private final int danoMin = 6;

    public Suegra() {
        super("CABRA_CORNIACEA", "Cabra Corniácea", "Un bruto con cuernos...", "La Cabra te ve... ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Gritarle un Insulto Fuerte",                      // Consecuencia Fija: Daño Máximo
                "2. Intentar darle un 'Pat Pat' en la Cabeza",        // Consecuencia Fija: Daño Mínimo
                "3. Ofrecerle tu Bocadillo de Queso",                 // Consecuencia Fija: Ganancia/Pérdida de item
                "4. Tirarse al Suelo y Esperar a que Pase"            // Consecuencia Fija: Ganancia/Pérdida de turno
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1":
                jugador.reducirCordura(danoMax);
                return "Tu insulto la enfurece. La Cabra te cornea fuertemente. **Recibes " + danoMax + " de daño.**";

            case "2":
                jugador.reducirCordura(danoMin);
                return "No eres lo suficientemente rápido y te golpea con el hocico. **Recibes " + danoMin + " de daño.**";

            case "3":
                // Esto es un castigo, asumiendo que el jugador sí tenía un bocadillo.
                return "La Cabra olfatea tu bocadillo, lo escupe con desprecio y se lo come. Pierdes tu bocadillo.";

            case "4":
                return "La Cabra simplemente te pasa por encima, como si fueras un obstáculo. ¡Encuentro evadido!";
            default:
                return interaccionExtra(jugador, seleccion, this.eventosExtra);
        }
    }

    public String interaccionExtra (Jugador jugador, String seleccion, ArrayList<ArrayList<String>> eventosExtra) {
        if (!eventosExtra.isEmpty()) {
            if (eventosExtra.size() != 2 && seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "1") {

                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "1") {

                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("6")) {
                if (eventosExtra.get(1).get(0) == "1") {

                }
                else if (eventosExtra.get(1).get(0) == "2") {

                }
            }
        }
        return "No entiendes bien qué hacer.";
    }
}