package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

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
            case "1. Gritarle un Insulto Fuerte":
                jugador.reducirCordura(danoMax);
                return "Tu insulto la enfurece. La Cabra te cornea fuertemente. **Recibes " + danoMax + " de daño.**";

            case "2. Intentar darle un 'Pat Pat' en la Cabeza":
                jugador.reducirCordura(danoMin);
                return "No eres lo suficientemente rápido y te golpea con el hocico. **Recibes " + danoMin + " de daño.**";

            case "3. Ofrecerle tu Bocadillo de Queso":
                // Esto es un castigo, asumiendo que el jugador sí tenía un bocadillo.
                return "La Cabra olfatea tu bocadillo, lo escupe con desprecio y se lo come. Pierdes tu bocadillo.";

            case "4. Tirarse al Suelo y Esperar a que Pase":
                return "La Cabra simplemente te pasa por encima, como si fueras un obstáculo. ¡Encuentro evadido!";
            default:
                return "Error de acción.";
        }
    }
}