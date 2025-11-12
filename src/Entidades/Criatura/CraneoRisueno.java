package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Item;
import Entidades.Items.MonedaSuerte;
import Entidades.Jugador;

import java.util.ArrayList;
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
            case "1":
                jugador.reducirCordura(danoBurlaMax);
                return "El Cráneo se ríe de tu risa. La burla te desmoraliza profundamente. Pierdes **" + danoBurlaMax + " de Cordura**.";

            case "2":
                jugador.reducirCordura(danoRisaMin);
                return "Tu tristeza solo alimenta su risa. La incomodidad te afecta. Pierdes **" + danoRisaMin + " de Cordura**.";

            case "3":
                return "El Cráneo se queda sin aliento de la sorpresa. Deja de reírse, se retira ofendido y puedes pasar.";

            case "4":
                return "El Cráneo flota a tu alrededor, molestándote sin parar hasta que pierdes la concentración. Pierdes un turno.";

            default:
                return interaccionExtra(jugador, seleccion, this.eventosExtra);
        }
    }

    public String interaccionExtra (Jugador jugador, String seleccion, ArrayList<ArrayList<String>> eventosExtra) {
        if (!eventosExtra.isEmpty()) {
            if (eventosExtra.size() != 2 && seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "6") {
                    MonedaSuerte moneda = new MonedaSuerte();
                    if (jugador.agregarItem(moneda)) {
                        return "Al ver el uranio-235, el craneo, que asistió a la convención nacional de seguridad atómica y concienciación sobre la radiación,\nse da cuenta de que probablemente no valga la pena meterse contigo si el inevitable precio es contraer cáncer. Sale corriendo y suelta una moneda muy brillante.**Obtienes la moneda de la suerte**";
                    }
                    else {
                        return "Al ver el uranio-235, el craneo, que asistió a la convención nacional de seguridad atómica y concienciación sobre la radiación,\nse da cuenta de que probablemente no valga la pena meterse contigo si el inevitable precio es contraer cáncer. Sale corriendo y suelta una moneda muy brillante. Sin embargo, no tienes espacio en el inventario.";
                    }
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("5")) {
                if (eventosExtra.get(0).get(0) == "6") {
                    MonedaSuerte moneda = new MonedaSuerte();
                    if (jugador.agregarItem(moneda)) {
                        return "Al ver el uranio-235, el craneo, que asistió a la convención nacional de seguridad atómica y concienciación sobre la radiación,\nse da cuenta de que probablemente no valga la pena meterse contigo si el inevitable precio es contraer cáncer. Sale corriendo y suelta una moneda muy brillante.**Obtienes la moneda de la suerte**";
                    }
                    else {
                        return "Al ver el uranio-235, el craneo, que asistió a la convención nacional de seguridad atómica y concienciación sobre la radiación,\nse da cuenta de que probablemente no valga la pena meterse contigo si el inevitable precio es contraer cáncer. Sale corriendo y suelta una moneda muy brillante. Sin embargo, no tienes espacio en el inventario.";
                    }
                }
                else if (eventosExtra.get(0).get(0) == "2") {

                }
            }
            else if (seleccion.equals("6")) {
                if (eventosExtra.get(1).get(0) == "6") {
                    MonedaSuerte moneda = new MonedaSuerte();
                    if (jugador.agregarItem(moneda)) {
                        return "Al ver el uranio-235, el craneo, que asistió a la convención nacional de seguridad atómica y concienciación sobre la radiación,\nse da cuenta de que probablemente no valga la pena meterse contigo si el inevitable precio es contraer cáncer. Sale corriendo y suelta una moneda muy brillante.**Obtienes la moneda de la suerte**";
                    }
                    else {
                        return "Al ver el uranio-235, el craneo, que asistió a la convención nacional de seguridad atómica y concienciación sobre la radiación,\nse da cuenta de que probablemente no valga la pena meterse contigo si el inevitable precio es contraer cáncer. Sale corriendo y suelta una moneda muy brillante. Sin embargo, no tienes espacio en el inventario.";
                    }
                }
                else if (eventosExtra.get(1).get(0) == "2") {

                }
            }
        }
        return "No entiendes bien qué hacer.";
    }
}