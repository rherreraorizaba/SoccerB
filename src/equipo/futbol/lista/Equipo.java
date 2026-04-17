package equipo.futbol.lista;

import equipo.futbol.excepciones.*;
import equipo.futbol.soccer.*;

import java.util.ArrayList;

/*
   Reglas del equipo:
   1) Ningun jugador puede tener el número de otro jugador  (Listo)
   2) Solo un portero puede llevar el 1  (Listo)
   3) El máximo de porteros es 3  (Listo)
   4) El máximo de jugadores solo pueden ser 26  (Listo)
   5) El máximo de edad de los jugadores 50 años (Listo)
   6) La edad minima de los jugadores 16 años (Listo)

 */
public class Equipo {

    private String nombre;
    private String abreviatura;
    private ArrayList<Portero> porteros;
    private ArrayList<Defensa> defensas;
    private ArrayList<MedioCampista> medios;
    private ArrayList<Delantero>  delanteros;
    private final int MAXIMO=5;
    private final int MAXIMO_PORTEROS=3;


    public Equipo(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.porteros=new ArrayList();
        this.defensas=new ArrayList();
        this.medios=new ArrayList();
        this.delanteros=new ArrayList();
    }

    public int cantidadDeJugadores(){
        return porteros.size()+defensas.size()+medios.size()+delanteros.size();
    }

    public boolean existeNumeroDeCamiseta(int numeroDeCamiseta) {
        boolean existe=false;
        for(int i=0;i<this.porteros.size();i++)
            if(numeroDeCamiseta==this.porteros.get(i).getNumeroDeCamiseta()){
                existe=true;
                break;
            }
        if(!existe)
            for(int i=0;i<this.defensas.size();i++)
                if(numeroDeCamiseta==this.defensas.get(i).getNumeroDeCamiseta()){
                    existe=true;
                    break;
                }
        if(!existe)
            for(int i=0;i<this.medios.size();i++)
                if(numeroDeCamiseta==this.medios.get(i).getNumeroDeCamiseta()){
                    existe=true;
                    break;
                }
        if(!existe)
            for(int i=0;i<this.delanteros.size();i++)
                if(numeroDeCamiseta==this.delanteros.get(i).getNumeroDeCamiseta()){
                    existe=true;
                    break;
                }
        return existe;
    }

    private void agregaPortero(Portero portero) throws ExcepcionDePorterosAlMaximo {
        if(porteros.size()==MAXIMO_PORTEROS)
            throw new ExcepcionDePorterosAlMaximo("Ya se tiene 3 porteros!!");
        this.porteros.add(portero);
    }

    private void agregaDefensa(Defensa defensa) throws ExcepcionDeNumeroDeCamisetaInvalido {
        if(defensa.getNumeroDeCamiseta()==1)
            throw new ExcepcionDeNumeroDeCamisetaInvalido("Un defensa no puede tener el numero 1");
        this.defensas.add(defensa);
    }

    private void agregaMedio(MedioCampista medio) throws ExcepcionDeNumeroDeCamisetaInvalido {
        if(medio.getNumeroDeCamiseta()==1)
            throw new ExcepcionDeNumeroDeCamisetaInvalido("Un medio no puede tener el numero 1");
        this.medios.add(medio);
    }

    private void agregaDelantero(Delantero delantero) throws ExcepcionDeNumeroDeCamisetaInvalido {
        if(delantero.getNumeroDeCamiseta()==1)
            throw new ExcepcionDeNumeroDeCamisetaInvalido("Un delantero no puede tener el numero 1");
        this.delanteros.add(delantero);
    }

    public void agregaJugador(Jugador jugador) throws
            ExcepcionDeJugadorInvalido,
            ExcepcionDeCantidadDeJugadoresAlMaximo,
            ExcepcionDeNumeroDeCamisetaRepetido,
            ExcepcionDePorterosAlMaximo,
            ExcepcionDeNumeroDeCamisetaInvalido {
       if(cantidadDeJugadores()==MAXIMO)
           throw new ExcepcionDeCantidadDeJugadoresAlMaximo("La cantidad de Jugadores rebasa el limite!!");
       if(existeNumeroDeCamiseta(jugador.getNumeroDeCamiseta()))
           throw new ExcepcionDeNumeroDeCamisetaRepetido("El jugador trae numero de camiseta que ya tiene otro Jugador");
        if(jugador instanceof Portero )
            agregaPortero((Portero)jugador);
        else if(jugador instanceof Defensa)
            agregaDefensa((Defensa)jugador);
        else if(jugador instanceof MedioCampista)
            agregaMedio((MedioCampista)jugador);
        else if(jugador instanceof Delantero)
            agregaDelantero((Delantero)jugador);
        else throw new ExcepcionDeJugadorInvalido("Jugador invalido!!");
    }
}
