package equipo.futbol.soccer;

import java.util.Objects;
import java.util.Comparator;

public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private int edad;
    private int numeroDeCamiseta;
    private int golesAnotados;
    private int partidosJugados;

    private static Comparator<Jugador> c= new Comparator<Jugador>(){
        public int compare(Jugador o1, Jugador o2){
            return o1.compareTo(o2);
        }
    };

    public static Comparator<Jugador> getComparator(){
        return c;
    }

    public static void setComparator(Comparator<Jugador> comparator) {
        c=comparator;
    }

    public Jugador(String nombre, int edad, int numeroDeCamiseta) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroDeCamiseta = numeroDeCamiseta;
        this.golesAnotados = 0;
        this.partidosJugados = 0;
    }

    public void juegaPartido(){
        this.partidosJugados++;
    }

    public void anotaGol(){
        this.golesAnotados++;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getNumeroDeCamiseta() {
        return numeroDeCamiseta;
    }

    public void setNumeroDeCamiseta(int numeroDeCamiseta) {
        this.numeroDeCamiseta = numeroDeCamiseta;
    }

    public String getNombre() {
        return nombre;
    }
    public void cumpleAños(){
        this.edad++;
    }
    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", numeroDeCamiseta=" + numeroDeCamiseta +
                ", golesAnotados=" + golesAnotados +
                ", partidosJugados=" + partidosJugados +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jugador jugador)) return false;

        return edad == jugador.edad && numeroDeCamiseta == jugador.numeroDeCamiseta && golesAnotados == jugador.golesAnotados && partidosJugados == jugador.partidosJugados && Objects.equals(nombre, jugador.nombre);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nombre);
        result = 31 * result + edad;
        result = 31 * result + numeroDeCamiseta;
        result = 31 * result + golesAnotados;
        result = 31 * result + partidosJugados;
        return result;
    }

    @Override
    public int compareTo(Jugador o) {
        int r=0;
        if((r=this.nombre.compareTo(o.nombre))!=0)
            return r;
        if((r=this.edad-o.edad)!=0)
            return r;
        if((r=numeroDeCamiseta-o.numeroDeCamiseta)!=0)
            return r;
        if((r=golesAnotados-o.golesAnotados)!=0)
            return r;
        return partidosJugados - o.partidosJugados;
    }

}
