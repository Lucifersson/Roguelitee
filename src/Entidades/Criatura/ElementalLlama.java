package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
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
            case "1":
                jugador.reducirCordura(danoQuemaduraMax);
                return "Te acercas demasiado. La llama te envuelve, quemándote gravemente. Recibes un brutal golpe de **" + danoQuemaduraMax + " de daño**.";

            case "2":
                jugador.reducirCordura(danoCalorMin);
                return "El agua se evapora instantáneamente. La explosión de vapor te chamusca el pelo. Recibes **" + danoCalorMin + " de daño**.";

            case "3":
                return "El elemental se come el malvavisco con un rugido y se expande en tamaño. Pierdes un turno de miedo.";

            case "4":
                return "Logras pasar corriendo por el lateral antes de que el calor te afecte. ¡Encuentro evadido!";

            default:
                return interaccionExtra(jugador, seleccion, this.eventosExtra);
        }
    }

    public String interaccionExtra (Jugador jugador, String seleccion, ArrayList<ArrayList<String>> eventosExtra) {
        if (!eventosExtra.isEmpty()) {
            if (eventosExtra.size() != 2 && seleccion.equals("7")) {
                if (eventosExtra.get(0).get(0) == "1") {
                    jugador.reducirCordura(2);
                    return "Intentas saltar sobre el elemental pero te quemas el culo. Al salir corriendo pierdes cordura. **-2 de cordura**";
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "7") {
                    jugador.reducirCordura(2);
                    return "Intentas saltar sobre el elemental pero te quemas el culo. Al salir corriendo pierdes cordura. **-2 de cordura**";
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("6")) {
                if (eventosExtra.get(1).get(0) == "7") {
                    jugador.reducirCordura(2);
                    return "Intentas saltar sobre el elemental pero te quemas el culo. Al salir corriendo pierdes cordura. **-2 de cordura**";
                }
                else if (eventosExtra.get(1).get(0) == "2") {

                }
            }
        }
        return "No entiendes bien qué hacer.";
    }
}