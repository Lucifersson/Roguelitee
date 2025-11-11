package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;
import java.util.Arrays;
import java.util.List;

public class OrejaEscuchadora extends Entidad {

    private final int danoSecretoMax = 11;
    private final int danoMurmulloMin = 5;

    public OrejaEscuchadora() {
        super("OREJA_ESCUCHADORA", "Oreja Escuchadora", "Una enorme oreja que emerge de la pared, vibrando.", "Una gran oreja rosada te mira. Está esperando que hables. ¿Qué harás?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Susurrarle un secreto vergonzoso",                   // Daño Máximo
                "2. Intentar golpearla con el puño",                     // Daño Mínimo
                "3. Cantarle una canción infantil en voz alta",          // Éxito
                "4. Quedarse en silencio total"                          // Pérdida de turno
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Susurrarle un secreto vergonzoso":
                jugador.reducirCordura(danoSecretoMax);
                return "La Oreja grita tu secreto por todo el laberinto. La humillación te destruye. Pierdes **" + danoSecretoMax + " de Cordura**.";

            case "2. Intentar golpearla con el puño":
                jugador.reducirCordura(danoMurmulloMin);
                return "Tu puño rebota en su cartílago. El sonido sordo te aturde. Pierdes **" + danoMurmulloMin + " de Cordura**.";

            case "3. Cantarle una canción infantil en voz alta":
                return "La Oreja no soporta la inocencia y se retrae asustada en el muro. ¡Encuentro evadido!";

            case "4. Quedarse en silencio total":
                return "La Oreja espera impacientemente tu voz. Pierdes un turno en el tenso silencio.";

            default:
                return "Error de acción.";
        }
    }
}