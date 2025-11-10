package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.Arrays;
import java.util.List;

public class EspectroMemoria extends Entidad {

    private final int danoPsiquicoMax = 10;
    private final int danoPanicoMin = 5;

    public EspectroMemoria() {
        super("ESPECTRO_MEMORIA",
                "Espectro de la Memoria",
                "Una figura sombría que se alimenta de la confusión.",
                "El aire se enfría y escuchas voces susurrando tu nombre. ¿Qué haces?");
    }


    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Intentar darle un golpe 'fantasma'",
                "2. Cerrar los Ojos y Gritar muy fuerte",
                "3. Contarle una Historia Aburrida",
                "4. Intentar Recordar tu Tarea Pendiente"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Intentar darle un golpe 'fantasma'":
                jugador.reducirCordura(danoPsiquicoMax);
                return "Tu puño lo atraviesa, pero la retroalimentación psíquica es brutal. Recibes un fuerte golpe mental de **" + danoPsiquicoMax + " de daño**.";

            case "2. Cerrar los Ojos y Gritar muy fuerte":
                jugador.reducirCordura(danoPanicoMin);
                return "Tu grito te deja exhausto y el Espectro se divierte con tu pánico. Recibes **" + danoPanicoMin + " de daño** psíquico.";

            case "3. Contarle una Historia Aburrida":
                // Castigo: Pérdida de un recurso, el espectro se aburre y te roba algo por fastidiar.
                return "El Espectro bosteza, se aburre con tu historia y te roba una posesión menor antes de desvanecerse.";

            case "4. Intentar Recordar tu Tarea Pendiente":
                // Resultado: Éxito total. Enfocarse lo disipa.
                return "Logras concentrarte en el dolor de cabeza que te da tu jefe. El Espectro se disipa por el shock de la rutina. ¡Encuentro evadido!";

            default:
                return "Error de acción.";
        }
    }
}