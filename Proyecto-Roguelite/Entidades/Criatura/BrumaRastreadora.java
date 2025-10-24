import java.util.Arrays;
import java.util.List;

public class BrumaRastreadora extends Entidad {

    // ... Atributos ID, NOMBRE, DESCRIPCION, PREGUNTA ...
    private final int danoMax = 12;
    private final int danoMin = 7;

    public BrumaRastreadora() {
        super("BRUMA_RASTREADORA", "Bruma Rastreadora", "Una niebla helada...", "Sientes un frío intenso... ¿Qué haces?");
    }

    @Override
    protected List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Tocar la Bruma por Curiosidad",                  // Consecuencia Fija: Daño Máximo
                "2. Cruzar Rápido por el Centro",                    // Consecuencia Fija: Daño Mínimo
                "3. Preguntarle si está Perdida",                    // Consecuencia Fija: Ganancia/Pérdida de turno
                "4. Ponerse una Máscara y Caminar Lento"             // Consecuencia Fija: Ganancia/Pérdida de turno
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Tocar la Bruma por Curiosidad":
                jugador.reducirSalud(danoMax);
                return "La Bruma te envuelve con furia, te quema con el frío. Recibes un golpe total de **" + danoMax + " de daño**.";

            case "2. Cruzar Rápido por el Centro":
                jugador.reducirSalud(danoMin);
                return "Te resbalas. La Bruma te salpica con escarcha, pero escapas rápido. Recibes **" + danoMin + " de daño**.";

            case "3. Preguntarle si está Perdida":
                return "La Bruma te ignora, el frío te hace perder el equilibrio y caes al suelo. Pierdes un turno.";

            case "4. Ponerse una Máscara y Caminar Lento":
                return "La máscara funciona a la perfección. La Bruma te rodea, pero te ignora. ¡Has evadido el peligro!";
            default:
                return "Error en la selección. La bruma te cubre lentamente.";
        }
    }
}