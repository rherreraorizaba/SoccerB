package ito.app;
import equipo.futbol.soccer.Defensa;
import equipo.futbol.soccer.Delantero;
import equipo.futbol.soccer.Jugador;



public class MyApp {

    public static void main(String[] args) {
        Object d= new Delantero("Juan Perez",20,56);
        Jugador e= new Delantero("Juanita Lopez",19,11);
        Delantero f= new Delantero("Pedro Torres",20,672);
        Defensa defensa;

        f.juegaPartido();
        e.juegaPartido();


        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

        System.out.println(d.getClass());
    }
}
