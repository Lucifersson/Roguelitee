package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;
import java.util.Arrays;
import java.util.List;

public class ArmaduraAbandonada extends Entidad {

    private final int danoMazaMax = 12;
    private final int danoEmpujonMin = 6;

    public ArmaduraAbandonada() {
        super("ARMADURA_ABANDONADA",
                "Armadura Abandonada",
                "Una mole de placas de acero oxidado que se mueve lentamente...",
                "Una armadura vacía se interpone en tu camino... ¿Qué harás?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Intentar romperle el yelmo de un golpe",
                "2. Tirarle un plátano a los pies",
                "3. Preguntarle si le cuesta subir escaleras",
                "4. Rodearla lentamente por el lateral"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Intentar romperle el yelmo de un golpe":
                jugador.reducirCordura(danoMazaMax); // <<-- CAMBIO A CORDURA
                return "Tu golpe rebota inútilmente. El miedo al fracaso te abruma. Pierdes **" + danoMazaMax + " de Cordura**.";

            case "2. Tirarle un plátano a los pies":
                jugador.reducirCordura(danoEmpujonMin); // <<-- CAMBIO A CORDURA
                return "La armadura resbala, pero el chirrido es aterrador. Tu mente se resiente. Pierdes **" + danoEmpujonMin + " de Cordura**.";

            case "3. Preguntarle si le cuesta subir escaleras":
                return "La armadura emite un chirrido furioso. Te obliga a retroceder y buscar otra ruta. Pierdes un turno.";

            case "4. Rodearla lentamente por el lateral":
                return "Dado que se mueve muy lento, puedes rodearla fácilmente sin que te alcance. ¡Encuentro evadido!";

            default:
                return "Error de acción.";
        }
    }
}