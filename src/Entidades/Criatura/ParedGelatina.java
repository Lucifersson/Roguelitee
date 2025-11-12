package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParedGelatina extends Entidad {

    private final int danoResistenciaMax = 10;
    private final int danoPegajosidadMin = 4;

    public ParedGelatina() {
        super("PARED_GELATINA", "Pared de Gelatina", "Una pared temblorosa de gelatina semi-transparente.", "El pasillo está bloqueado por una pared de gelatina. Es pegajosa. ¿Qué harás?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Empujarla con toda tu fuerza",                    // Daño Máximo
                "2. Tocarla con un dedo para comprobar su textura",   // Daño Mínimo
                "3. Dejarle un regalo con la esperanza de que se aparte",// Pérdida de item
                "4. Lanzarle ácido (inventario)"                     // Éxito (asumiendo que tienes un recurso)
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Empujarla con toda tu fuerza":
                jugador.reducirCordura(danoResistenciaMax);
                return "Tu fuerza es absorbida. La frustración es abrumadora. Pierdes **" + danoResistenciaMax + " de Cordura**.";

            case "2. Tocarla con un dedo para comprobar su textura":
                jugador.reducirCordura(danoPegajosidadMin);
                return "Tu dedo se pega ligeramente. El asco te causa una leve perturbación. Pierdes **" + danoPegajosidadMin + " de Cordura**.";

            case "3. Dejarle un regalo con la esperanza de que se aparte":
                return "La pared absorbe el regalo. Te ha robado tu objeto más valioso.";

            case "4. Lanzarle ácido (inventario)":
                return "El ácido disuelve rápidamente la pared. El camino queda libre. ¡Encuentro evadido!";

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