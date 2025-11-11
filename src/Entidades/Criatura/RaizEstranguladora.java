package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;
import java.util.Arrays;
import java.util.List;

public class RaizEstranguladora extends Entidad {

    private final int danoPanicoMax = 12;
    private final int danoEsfuerzoMin = 6;

    public RaizEstranguladora() {
        super("RAIZ_ESTRANGULADORA",
                "Raíz Estranguladora",
                "Una gruesa raíz de color rojo oscuro que se arrastra por el suelo.",
                "Una raíz se enrosca en tu tobillo, tensándose lentamente. ¿Qué haces?");
    }

    @Override
    public List<String> getInteraccionesBase() { // Public
        return Arrays.asList(
                "1. Tirar con todas tus fuerzas para soltarte",         // Daño Máximo
                "2. Cortarla con un cuchillo",                          // Daño Mínimo
                "3. Untarla con jarabe dulce",                          // Pérdida de item
                "4. Quedarte quieto y esperar a que se relaje"          // Éxito
        );
    }

    @Override
    public String interactuar(Jugador jugador, String seleccion) {

        switch (seleccion) {
            case "1. Tirar con todas tus fuerzas para soltarte":
                jugador.reducirCordura(danoPanicoMax);
                return "Tu lucha solo aprieta el lazo. La sensación de asfixia te provoca pánico. Pierdes **" + danoPanicoMax + " de Cordura**.";

            case "2. Cortarla con un cuchillo":
                jugador.reducirCordura(danoEsfuerzoMin);
                return "La raíz se retuerce ante el dolor, y el esfuerzo mental te agota. Pierdes **" + danoEsfuerzoMin + " de Cordura**.";

            case "3. Untarla con jarabe dulce":
                return "La raíz se confunde con el olor. Te suelta, pero pierdes el valioso frasco de jarabe.";

            case "4. Quedarte quieto y esperar a que se relaje":
                return "Dejas de resistirte. La raíz se relaja, te suelta y se retrae. ¡Encuentro evadido!";

            default:
                return "Error de acción.";
        }
    }
}