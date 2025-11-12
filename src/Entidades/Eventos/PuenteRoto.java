package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuenteRoto extends Entidad {

    public PuenteRoto() {
        super("EVENTO_PUENTE_ROTO", "Puente Roto",
                "Un viejo puente colgante cruje bajo tus pies, con un abismo al fondo.\n" +
                "Al fondo ves pinchos cómicamente colocados.\n" +
                "Hace mucho aire y algunas tablas están rotas.",
                "¿Cruzarás el puente o buscarás otra ruta?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Cruzar con cuidado",
                "2. Saltar las tablas rotas",
                "3. Cagarse y buscar otro camino",
                "4. No hay huevos"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Cruzar con cuidado":
                if (jugador.getSuerte() > 12) {
                    jugador.reducirCordura(1);
                    return "Una tabla cede bajo tus pies, pero logras no cagarte y acabar de cruzar. **Pierdes 1 de Cordura**";
                } else {
                    jugador.reducirCordura(5);
                    return "Una de las cuerdas que sostenía el puente se parte y caes al abismo. \n" +
                            "Por suerte, los pinchos son falsos y amortiguan tu caída.\n" +
                            "Sin embargo, el susto hace que pierdas tu cordura. **Pierdes 5 de Cordura**";
                }
            case "2. Saltar las tablas rotas":
                if (jugador.getIntimidacion() > 10) {
                    return "Tu determinación te impulsa al otro lado. Te sientes más confiado.";
                } else {
                    return "Una tabla podrida cede con tu impacto. Quedas colgado boca abajo, admirando las vistas.\n" +
                            "La cuerda empieza a ceder debido a tu peso y te ves obligado a tirar un objeto"; /*PIERDE OBJETO ALEATORIO*/
                }
            case "3. Cagarse y buscar otro camino":
                return "Pierdes tiempo, pero evitas el peligro. No ocurre nada. Cagón";
            case "4. No hay huevos":
                jugador.aumentarCarisma(3);
                return "El puente se da cuenta de con quien está tratando. Pasas sin problemas **Ganas 3 de Carisma**";
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
