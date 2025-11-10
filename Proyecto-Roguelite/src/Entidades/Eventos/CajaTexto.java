package Entidades.Eventos;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.Arrays;
import java.util.List;

public class CajaTexto extends Entidad {

    public CajaTexto() {
        super("EVENTO_CUAJA_TEXTO", "Caja de Texto Vacía",
                "Te acercas a una mesa con un ordenador verdaderamente antiguo. Un cursor parpadea invitándote a escribir. El juego parece esperar una orden que podría cambiar las reglas.",
                "Escribes algo:");
    }

    @Override
    public List<String> getInteraccionesBase() {
        return Arrays.asList(
                "1. Escribir 'hola mundo'",
                "2. No escribir nada y esperar",
                "3. Escribir tu nombre",
                "4. Escribir 'salir'"
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {
        switch (seleccion) {
            case "1":
                return "El ordenador te devuelve el saludo. Notas una extraña pesadez en los ojos. \n" +
                        "**Desbloqueas el logro 'Primeros Pasos en la Programación'**";
            case "2":
                jugador.reducirInteligencia(2);
                return "El cursor sigue parpadeando. No todos estamos hechos para la tecnología. **Pierdes 2 de Inteligencia**";
            case "3":
                return "El juego lo registra en mayúsculas. Te sientes expuesto.";
            case "4":
                jugador.reducirCarisma(3);
                return "El juego no entiende tu comando. Parece que no puedes salir tan fácilmente. **Pierdes 3 de Carisma**";
            case "5": /*OPCION OCULTA*/
                if ( jugador.getInteligencia() == 20){
                    return "ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR\n" +
                            "**Desbloqueas el logro 'Destruir el Sistema'**";
                    /*SALIR DEL JUEGO System.exit(0); */
                }else{
                    return "El sistema se bloquea momentáneamente, pero luego todo vuelve a la normalidad.";
                }
            default:
                return "No entiendes bien qué hacer.";
        }
    }
}
