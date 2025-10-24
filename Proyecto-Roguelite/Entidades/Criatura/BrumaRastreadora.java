import java.util.Arrays;
import java.util.List;

public class BrumaRastreadora extends Entidad {

    private static final String ID = "BRUMA_RASTREADORA";
    private static final String NOMBRE = "Bruma Rastreadora";
    private static final String DESCRIPCION = "Una niebla helada que roba la vitalidad de quienes se acercan.";
    private static final String PREGUNTA = "Sientes un frío intenso y escuchas un susurro apenas audible... ¿Qué haces?";

    private final int duracionDebuffTurnos = 3;
    private final int umbralSabiduriaDebilidad = 10;
    private final int umbralDestrezaEvasion = 8; // Umbral bajo para reflejar que es una acción simple

    public BrumaRastreadora() {
        super(ID, NOMBRE, DESCRIPCION, PREGUNTA);
    }

    // --- Interacciones Base Genéricas ---

    @Override
    protected List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Atacar con Arma de Melé (Fuerza/Destreza)", // Opción de Combate Físico
                "2. Analizar el Entorno (Sabiduría)",           // Opción de Combate Mágico/Análisis
                "3. Intentar Pasar Rápido (Destreza)",          // Opción de Defensa/Habilidad
                "4. Hablarle/Distraerla (Carisma)"              // Opción de Interacción/Social
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Atacar con Arma de Melé (Fuerza/Destreza)":
                // Las brumas suelen ignorar el daño físico, pero el contacto aplica el debuff.
                jugador.aplicarDebuff("Congelacion", 1);
                return "Tu golpe atraviesa la niebla, pero el frío te envuelve. Ganas 'Congelación' por 1 turno.";

            case "2. Analizar el Entorno (Sabiduría)":
                if (jugador.getStat("Sabiduria") >= umbralSabiduriaDebilidad) {
                    return "Determinas que la bruma es débil al Fuego. Obtienes ventaja ofensiva en el próximo ataque.";
                } else {
                    return "El análisis te confunde. Pierdes 1 turno y la bruma se acerca.";
                }

            case "3. Intentar Pasar Rápido (Destreza)":
                if (jugador.getStat("Destreza") >= umbralDestrezaEvasion) {
                    return "Tu agilidad te permite atravesar la niebla antes de que te afecte. Encuentro evadido con éxito.";
                } else {
                    jugador.aplicarDebuff("Congelacion", duracionDebuffTurnos);
                    return "No eres lo suficientemente rápido. La bruma te afecta completamente. Ganas 'Congelación'.";
                }

            case "4. Hablarle/Distraerla (Carisma)":
                // Opción social que casi nunca funciona en brumas.
                return "La niebla no tiene oídos para escuchar tu súplica. Te ignora.";

            default:
                return "Error en la selección. La bruma te cubre lentamente.";
        }
    }
}