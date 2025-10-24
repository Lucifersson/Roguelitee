import java.util.Arrays;
import java.util.List;

public class Suegra extends Entidad {

    private static final String ID = "CABRA_CORNIACEA";
    private static final String NOMBRE = "Cabra Corniácea";
    private static final String DESCRIPCION = "Un bruto con cuernos de obsidiana, enfocado en el combate cuerpo a cuerpo.";
    private static final String PREGUNTA = "La Cabra te ve. Sus ojos brillan con furia mientras raspa el suelo. ¿Qué haces?";

    private final int danoBaseCarga = 25;
    private final int umbralDestrezaEsquiva = 14;
    private final int umbralDefensaBloqueo = 10;

    public Suegra() {
        super(ID, NOMBRE, DESCRIPCION, PREGUNTA);
    }

    // --- Interacciones Base Genéricas ---

    @Override
    protected List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Atacar con Arma de Melé (Fuerza/Destreza)",     // Opción de Combate Físico
                "2. Lanzar un Hechizo Ofensivo (Intelecto)",        // Opción de Combate Mágico
                "3. Esquivar y Flanquear el Ataque (Destreza)",     // Opción de Defensa/Habilidad
                "4. Intentar Distraer a la Bestia (Suerte/Carisma)" // Opción de Interacción/Social
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        String mensajeCabra = "La Cabra Corniácea embiste con toda su fuerza.";

        switch (seleccion) {
            case "1. Atacar con Arma de Melé (Fuerza/Destreza)":
                // Ataque directo. Siempre recibe un poco de daño del contraataque.
                jugador.reducirSalud((int) (danoBaseCarga * 0.25));
                return "Golpeas su costado, pero la Cabra contraataca instintivamente. Recibes daño menor.";

            case "2. Lanzar un Hechizo Ofensivo (Intelecto)":
                // Se resuelve el daño mágico. Si el hechizo es de control, puede fallar por su fuerza.
                if (jugador.getStat("Intelecto") >= 15) {
                    return "Tu rayo mágico la aturde momentáneamente. Ganas una ventaja para el próximo turno.";
                } else {
                    return "Tu hechizo rebota en sus cuernos. La Cabra ignora el daño.";
                }

            case "3. Esquivar y Flanquear el Ataque (Destreza)":
                if (jugador.getStat("Destreza") >= umbralDestrezaEsquiva) {
                    return mensajeCabra + " Eres rápido. Esquivas el ataque y la dejas expuesta.";
                } else {
                    jugador.reducirSalud(danoBaseCarga);
                    return mensajeCabra + " Fallas y recibes " + danoBaseCarga + " de daño completo.";
                }

            case "4. Intentar Distraer a la Bestia (Suerte/Carisma)":
                // La suerte puede determinar si el intento de distracción funciona.
                if (jugador.getStat("Suerte") >= 12) {
                    return "Una roca cae del techo y la distrae. Tienes la oportunidad de huir.";
                } else {
                    return "Tu intento falla. La Cabra gruñe y se concentra en ti aún más.";
                }

            default:
                return "Tu acción no tuvo efecto. La Cabra te embiste sin piedad.";
        }
    }
}