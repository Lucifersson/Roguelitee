package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.Arrays;
import java.util.List;

public class GatoCuantico extends Entidad {

    public GatoCuantico() {
        super("EVENTO_GATO_CUANTICO", "Gato Cuántico",
                "Un gato aparece y desaparece entre líneas de código. Parece observarte con curiosidad.",
                "¿Cómo interactúas con el gato?");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Acariciarlo",
                "2. Observarlo fijamente",
                "3. Intentar atraparlo",
                "4. Preguntarle si existe"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1. Acariciarlo":
                jugador.aumentarCordura(5);
                return "El gato ronronea y te sientes más tranquilo. **Consigues 5 de Cordura.**";
            case "2. Observarlo fijamente":
                jugador.aumentarInteligencia(3);
                return "El gato te mira y desaparece. Te quedas con la sensación de que algo cambió. **Consigues 3 de Inteligencia.**";
            case "3. Intentar atraparlo":
                return "Le lanzas una caja, pero el gato ya no está. Parece que siempre estuvo fuera de tu alcance.";
            case "4. Preguntarle si existe":
                return "ERROR: El gato no responde. ¿O sí?";
            default:
                return "No entiendes bien qué hacer.";
        }
    }
}
