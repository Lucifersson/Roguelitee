package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;
import java.util.Arrays;
import java.util.List;

public class CraneoRisueno extends Entidad {

    private final int danoBurlaMax = 10;
    private final int danoRisaMin = 5;

    public CraneoRisueno() {
        super("CRANEO_RISUENO",
              "Cráneo Risueño",
              "Un cráneo pálido que flota y se ríe de ti constantemente.",
              "Escuchas una risa histérica y un cráneo flotante se acerca. ¿Qué harás?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
            "1. Reírse aún más fuerte que el Cráneo",                 // Daño Máximo
            "2. Ponerle una cara triste",                            // Daño Mínimo
            "3. Contarle un chiste aún más macabro",                 // Éxito
            "4. Ignorarlo y esperar que se aburra"                   // Pérdida de turno
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Reírse aún más fuerte que el Cráneo":
                jugador.reducirCordura(danoBurlaMax);
                return "El Cráneo se ríe de tu risa. La burla te desmoraliza profundamente. Pierdes **" + danoBurlaMax + " de Cordura**.";

            case "2. Ponerle una cara triste":
                jugador.reducirCordura(danoRisaMin);
                return "Tu tristeza solo alimenta su risa. La incomodidad te afecta. Pierdes **" + danoRisaMin + " de Cordura**.";

            case "3. Contarle un chiste aún más macabro":
                return "El Cráneo se queda sin aliento de la sorpresa. Deja de reírse, se retira ofendido y puedes pasar.";

            case "4. Ignorarlo y esperar que se aburra":
                return "El Cráneo flota a tu alrededor, molestándote sin parar hasta que pierdes la concentración. Pierdes un turno.";

            default:
                return "Error de acción.";
        }
    }
}