package equipo.futbol.lista;

import equipo.futbol.excepciones.ExcepcionDeJugadorInvalido;
import equipo.futbol.soccer.*;

import java.util.ArrayList;

/*
   Reglas del equipo:
   1) Ningun jugador puede tener el número de otro jugador
   2) Solo un portero puede llevar el 1
   3) El máximo de porteros es 3
   4) El máximo de jugadores solo pueden ser 26
   5) El máximo de edad de los jugadores 50 años
   6) La edad minima de los jugadores 16 años

 */
public class Equipo {

    private String nombre;
    private String abreviatura;
    private ArrayList<Portero> porteros;
    private ArrayList<Defensa> defensas;
    private ArrayList<MedioCampista> medios;
    private ArrayList<Delantero>  delanteros;


    public Equipo(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.porteros=new ArrayList();
        this.defensas=new ArrayList();
        this.medios=new ArrayList();
        this.delanteros=new ArrayList();
    }

    public void agregaJugador(Jugador jugador) throws ExcepcionDeJugadorInvalido {
        if(jugador instanceof Portero )
            agregaPortero(jugador);
        if(jugador instanceof Defensa)
            agregaDefensa(jugador);
        if(jugador instanceof MedioCampista)
            agregaMedio(jugador);
        if(jugador instanceof Delantero)
            agregaDelantero(jugador);
        else throw new ExcepcionDeJugadorInvalido("Jugador invalido!!");
    }
}
