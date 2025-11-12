package BBDD;

import Entidades.Item;
import Entidades.Jugador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BBDD {
    public static ArrayList<ArrayList<String>> conectarBaseDatos(Jugador jugador, String idEventos)  {
        String url = "jdbc:mysql://localhost:3307/roguelitee";
        String user = "root";
        String password = "Roguelitee";
        //lista de eventos (cada evento tiene un id y una cadena de texto que describe el evento)
        ArrayList<ArrayList<String>> lista = new java.util.ArrayList<>();
        //lista de evento (guarda un id y una descripción del enunciado)
        ArrayList<String> listalista = new java.util.ArrayList<>();

        int cantidadCordura = jugador.getCordura();
        int cantidadCarisma = jugador.getCarisma();
        int cantidadIntimidacion = jugador.getIntimidacion();
        int cantidadInteligencia = jugador.getInteligencia();
        int cantidadSuerte = jugador.getSuerte();

        List<Item> items = jugador.getInventario();
        List<String> inventario = new ArrayList<>();
        for (Item item : items) {
            inventario.add(item.getIdMySQL());
        }

        for (String idObjetos : inventario) {
            try (Connection conexion = DriverManager.getConnection(url, user, password)) {
                Statement statement = conexion.createStatement();
                {
                    String query = "SELECT id, cadenaTextoEvento FROM Eventos WHERE idEventos = '" + idEventos + "' AND (idObjetos = '" + idObjetos + "' OR cantidadCordura >= " + cantidadCordura + " OR cantidadCarisma >= " + cantidadCarisma + " OR cantidadIntimidacion >= " + cantidadIntimidacion + " OR cantidadInteligencia >= " + cantidadInteligencia + " OR cantidadSuerte >= " + cantidadSuerte + ") ORDER BY id ASC;";
                    ResultSet rs = statement.executeQuery(query);
                    rs.next();
                    if (!rs.wasNull()) {
                        listalista.clear();
                        listalista.add(rs.getString("id"));
                        listalista.add(rs.getString("cadenaTextoEvento"));
                        if (lista.isEmpty()) {
                            lista.add(listalista);
                        }
                        else {
                            if (lista.size() == 1) {
                                if (lista.get(0) != listalista) {
                                    lista.add(listalista);
                                }
                            }
                            else if (lista.size() == 2) {
                                if (lista.get(1) != listalista) {
                                    lista.add(listalista);
                                }
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}