package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WifiFantasma extends Entidad {

    public WifiFantasma() {
        super("EVENTO_WIFI_FANTASMA", "Wifi Fantasma",
                "Detectas una señal WiFi con nombre “LAN_del_Más_Acá”.",
                "Te conecta a la red ¿qué buscas?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Entrar en bolsa",
                "2. Entrar a un casino online",
                "3. Buscar videos de gatos",
                "4. Entrar a YouTube profundo"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Entrar en bolsa":
                return "Pones todas tus ganancias en una compañía llamada 'NoJewsTafa'.\n" +
                        "La compañía cae en picado y te sientes un poco triste por dejar a tu familia sin comer otro mes.\n" +
                        "Sigues adelante.";
            case "2. Entrar a un casino online":
                if (jugador.getSuerte() == 20){
                    jugador.reducirSuerte(5);
                    return "Lo metes todo al verde. Recapacitas y, rápidamente, lo cambias todo al rojo. Sale verde. **Pierdes 5 de suerte.**";
                }else{
                    jugador.aumentarSuerte(5);
                    return "Lo metes todo al verde. No lo piensas dos veces. Sale verde. **Ganas 5 de suerte.**";
                }
            case "3. Buscar videos de gatos":
                jugador.aumentarCordura(1);
                return "Encuentras el video perfecto. **Ganas 1 de Cordura.**";
            case "4. Entrar a YouTube profundo":
                return "Encuentras un video que explica detalladamente como refinar Uranio-235.\n" +
                        "Observas ensimismado, memorizas los pasos y das like. **Obtienes Uranio-235**"; /*AÑADIR OBJETO*/
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
