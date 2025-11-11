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
        List<String> inventario = jugador.getInventario();

        for (String idObjetos : inventario) {
            try (Connection conexion = DriverManager.getConnection(url, user, password)) {
                Statement statement = conexion.createStatement();
                {
                    String query = "SELECT id, cadenaTextoEvento FROM Eventos WHERE idEventos = '" + idEventos + "' AND idObjetos = '" + idObjetos + "' AND cantidadCordura <= " + cantidadCordura + " AND cantidadCarisma <= " + cantidadCarisma + " AND cantidadIntimidacion <= " + cantidadIntimidacion + " AND cantidadInteligencia <= " + cantidadInteligencia + " AND cantidadSuerte <= " + cantidadSuerte + ";";
                    ResultSet rs = statement.executeQuery(query);
                    rs.next();
                    if (!rs.wasNull()) {
                        listalista.clear();
                        listalista.add(rs.getString("id"));
                        listalista.add(rs.getString("cadenaTextoEvento"));
                        lista.add(listalista);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}