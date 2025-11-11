package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;
import java.util.Arrays;
import java.util.List;

public class LimoParlante extends Entidad {

    private final int danoCorrosionMax = 10;
    private final int danoSalpicaduraMin = 5;

    public LimoParlante() {
        super("LIMO_PARLANTE",
                "Limo Parlante",
                "Una masa verde y pegajosa que intenta conversar...",
                "El limo se acerca lentamente y dice, '¡Hola! ¿Quieres oír un chiste?'. ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Darle la mano educadamente",
                "2. Tirarle un puñado de arena",
                "3. Responderle con otro chiste",
                "4. Simplemente seguir caminando sin mirarle"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Darle la mano educadamente":
                jugador.reducirCordura(danoCorrosionMax); // <<-- CAMBIO A CORDURA
                return "Tu mano atraviesa la gelatina. Recibes un golpe corrosivo que afecta a tu juicio. Pierdes **" + danoCorrosionMax + " de Cordura**.";

            case "2. Tirarle un puñado de arena":
                jugador.reducirCordura(danoSalpicaduraMin); // <<-- CAMBIO A CORDURA
                return "El limo se irrita y salpica ácido en tu dirección. El terror te confunde. Pierdes **" + danoSalpicaduraMin + " de Cordura**.";

            case "3. Responderle con otro chiste":
                return "Tu chiste es mejor que el suyo. El limo se ríe tanto que se deshace y puedes pasar.";

            case "4. Simplemente seguir caminando sin mirarle":
                return "El limo se ofende por ser ignorado y te lanza un pequeño chorro de ácido que te obliga a detenerte. Pierdes un turno.";

            default:
                return "Error de acción.";
        }
    }
}