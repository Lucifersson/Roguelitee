package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.Arrays;
import java.util.List;

public class AscensorPosibilidades extends Entidad {

    public AscensorPosibilidades() {
        super("EVENTO_ASCENSOR_POSIBILIDADES", "Ascensor de Posibilidades",
                "Entras a un ascensor que solo tiene dos botones: ARRIBA y ¿ARRIBA?.",
                "¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Pulsar ARRIBA",
                "2. Pulsar ¿ARRIBA?",
                "3. Romper el panel",
                "4. Esperar a que algo ocurra"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Pulsar ARRIBA":
                return "El ascensor sube un piso. ¿Qué esperabas?.";
            case "2. Pulsar ¿ARRIBA?":
                jugador.reducirCordura(3);
                return "El ascensor sube varios pisos rápidamente y luego cae en picado. No sabes si te has fracturado un tobillo. **Pierdes 3 de Cordura.**";
            case "3. Romper el panel":
                if (jugador.getIntimidacion() >= 12) {
                    jugador.aumentarIntimidacion(2);
                    return "Rompes el panel con un golpe dramático. Los cables chispean; se abre una trampilla secreta. **Ganas 2 de intimidación**";
                } else {
                    jugador.reducirCarisma(2);
                    return "Intentas romper el panel, pero solo consigues rasgarte la mano. No es tu día.. **Pierdes 2 de Carisma.**";
                }
            case "4. Esperar a que alguien más entre":
                return "Pierdes valiosas horas de vida esperando a que alguien llegue a sacarte de ese cubículo mal acondicionado.";
            default:
                return "No entiendes bien qué hacer.";
        }
    }
}
