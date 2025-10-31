package entidades.eventos;

import entidades.Entidad;
import entidades.Jugador;

import java.util.Arrays;
import java.util.List;

public class EspejoMagico extends Entidad {

    public EspejoMagico() {
        super("EVENTO_PUERTA_EXTRAÑA", "Puerta Extraña",
                "Te encuentras con una puerta solitaria en medio del desierto. No hay nada más.",
                "¿Abrirás la puerta o la ignorarás?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Abrirla",
                "2. Golpearla",
                "3. Pasar a través",
                "4. Pedir permiso"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Abrirla":
                return "Nada pasa. Literalmente nada.";
            case "2. Golpearla":
                if (jugador.getIntimidacion() > 10) {
                    jugador.reducirCordura(5);
                    return "La puerta cede un poco y tu pierna se queda atascada con el marco. **Pierdes 5 de Cordura.**";
                } else {
                    jugador.reducirCarisma(5);
                    return "No rompes la puerta, solo pierdes energía. **Pierdes 5 de Carisma.**";
                }
            case "3. Pasar a través":
                jugador.aumentarSuerte(5);
                return "Notas una ligera brisa al otro lado de la puerta. **Ganas 5 de Suerte.**";
            case "4. Pedir permiso":
                return "La puerta se abre lentamente. **Ganas el logro Cortesía Dimensional**.";
            default:
                return "No entiendes bien qué hacer.";
        }
    }
}
