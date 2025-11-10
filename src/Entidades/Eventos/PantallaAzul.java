package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.Arrays;
import java.util.List;

public class PantallaAzul extends Entidad {

    // A MODIFICAR

    public PantallaAzul() {
        super("EVENTO_PANTALLA_AZUL", "Pantallazo Azul",
                "Tu visión se tiñe de azul. El mundo parece haberse colgado. Un texto gigante dice 'ERROR FATAL: JUGADOR.EXE HA DEJADO DE FUNCIONAR'.",
                "Intentas moverte, pero tus piernas no responden. ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Reiniciar el sistema",
                "2. Esperar que se arregle solo",
                "3. Golpear la pantalla",
                "4. Llorar en binario"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) throws InterruptedException {
        switch (seleccion) {
            case "1":
                jugador.aumentarCordura(3);
                return "Ctrl+Alt+F4 Recuperas tu dignidad. **Ganas 3 de Cordura.**";
            case "2":
                jugador.reducirCordura(5);
                System.out.print("Esperas.");
                wait(100);
                System.out.print(" Y esperas.");
                wait(300);
                System.out.print(" Y esperas...");
                return " **Pierdes 5 de Cordura.**";
            case "3":
                jugador.aumentarIntimidacion(2);
                return "El universo responde al golpe y se reanuda. Te sientes un buen informático. **Ganas 2 de Intimidación.**";
            case "4":
                jugador.aumentarCarisma(1);
                return "00110100 00110000 00110100... Es conmovedor. **Ganas 1 de Carisma.**";
            default:
                return "No entiendes bien qué hacer.";
        }
    }
}
