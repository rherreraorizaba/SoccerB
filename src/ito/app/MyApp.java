package ito.app;
import equipo.futbol.excepciones.*;
import equipo.futbol.lista.Equipo;
import equipo.futbol.soccer.Defensa;
import equipo.futbol.soccer.Delantero;
import equipo.futbol.soccer.Jugador;
import equipo.futbol.soccer.Portero;


public class MyApp {

    public static void main(String[] args) {
        Equipo equipo = new Equipo("Buhos","B");

        try {
            equipo.agregaJugador(new Portero("Hugo Perez",23,1,156));
            equipo.agregaJugador(new Defensa("Jorge Lopez",25,5,"Central"));
            equipo.agregaJugador(new Portero("Memo Ochoa",42,45,186));
            equipo.agregaJugador(new Portero("Luis Perez",21,19,196));
            equipo.agregaJugador(new Defensa("Puyol",33,17,"Central"));
            equipo.agregaJugador(new Portero("Hugo Perez",23,18,156));
        } catch (ExcepcionDeJugadorInvalido e) {
            System.err.println(e.getMessage());
        } catch (ExcepcionDeCantidadDeJugadoresAlMaximo e) {
            System.err.println(e.getMessage());
        } catch (ExcepcionDeNumeroDeCamisetaRepetido e) {
            System.err.println(e.getMessage());
        } catch (ExcepcionDePorterosAlMaximo e) {
            System.err.println(e.getMessage());
        } catch (ExcepcionDeNumeroDeCamisetaInvalido e) {
            System.err.println(e.getMessage());
        } catch (ExcepcionDeEdadFueraDeLimites e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Programa terminado");
    }
}
