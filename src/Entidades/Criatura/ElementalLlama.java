package Roguelite.Entidades.Criatura;

import Roguelite.Entidad;
import Roguelite.Jugador;
import java.util.Arrays;
import java.util.List;

public class ElementalLlama extends Entidad {

    private final int danoQuemaduraMax = 12;
    private final int danoCalorMin = 6;

    public ElementalLlama() {
        super("ELEMENTAL_LLAMA",
                "Elemental de Llama",
                "Una masa ardiente de energía pura...",
                "Una pared de fuego te bloquea el paso... ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Intentar apagarlo de un soplido",               // Daño Máximo
                "2. Lanzarle una botella de agua",                  // Daño Mínimo
                "3. Sacar un malvavisco para asarlo",               // Pérdida de turno
                "4. Rodearlo rápidamente por el lateral"             // Éxito
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Intentar apagarlo de un soplido":
                jugador.reducirSalud(danoQuemaduraMax);
                return "Te acercas demasiado. La llama te envuelve, quemándote gravemente. Recibes un brutal golpe de **" + danoQuemaduraMax + " de daño**.";

            case "2. Lanzarle una botella de agua":
                jugador.reducirSalud(danoCalorMin);
                return "El agua se evapora instantáneamente. La explosión de vapor te chamusca el pelo. Recibes **" + danoCalorMin + " de daño**.";

            case "3. Sacar un malvavisco para asarlo":
                return "El elemental se come el malvavisco con un rugido y se expande en tamaño. Pierdes un turno de miedo.";

            case "4. Rodearlo rápidamente por el lateral":
                return "Logras pasar corriendo por el lateral antes de que el calor te afecte. ¡Encuentro evadido!";

            default:
                return "Error de acción.";
        }
    }
}