package equipo.futbol.soccer;

import java.util.Objects;
import java.util.Comparator;

public class Defensa extends Jugador{
    private int cantidadDeAvancesInterrumpidos;
    private int cantidadDeBalonesRecuperados;
    private String tipoDeDefensa;

    public static Comparator<Defensa> c= new Comparator<Defensa>(){
        @Override
        public int compare(Defensa o1, Defensa o2) {
            return o1.compareTo(o2);
        }
    };

    public Defensa(String nombre, int edad, int numeroDeCamiseta,String tipoDeDefensa){
        super(nombre, edad, numeroDeCamiseta);
        this.tipoDeDefensa=tipoDeDefensa;
        this.cantidadDeBalonesRecuperados=0;
        this.cantidadDeAvancesInterrumpidos=0;
    }

    public String getTipoDeDefensa() {
        return tipoDeDefensa;
    }

    public void setTipoDeDefensa(String tipoDeDefensa) {
        this.tipoDeDefensa = tipoDeDefensa;
    }

    public int getCantidadDeAvancesInterrumpidos() {
        return cantidadDeAvancesInterrumpidos;
    }

    public int getCantidadDeBalonesRecuperados() {
        return cantidadDeBalonesRecuperados;
    }

    public void interrumpeAvance(){
        this.cantidadDeAvancesInterrumpidos++;
    }

    public void balonRecuperado(){
        this.cantidadDeBalonesRecuperados++;
    }

    @Override
    public String toString() {
        return "Defensa{" +
                super.toString() +
                "cantidadDeAvancesInterrumpidos=" + cantidadDeAvancesInterrumpidos +
                ", cantidadDeBalonesRecuperados=" + cantidadDeBalonesRecuperados +
                ", tipoDeDefensa='" + tipoDeDefensa + '\'' +
                '}';
    }

    int compareTo(Defensa o) {
        int r=0;
        if((r=super.compareTo(o))!=0)
            return r;
        if((r=cantidadDeAvancesInterrumpidos-o.cantidadDeAvancesInterrumpidos)!=0)
            return r;
        if((r=cantidadDeBalonesRecuperados-o.cantidadDeBalonesRecuperados)!=0)
            return r;
        return tipoDeDefensa.compareTo(o.tipoDeDefensa);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Defensa defensa)) return false;
        if (!super.equals(o)) return false;

        return cantidadDeAvancesInterrumpidos == defensa.cantidadDeAvancesInterrumpidos && cantidadDeBalonesRecuperados == defensa.cantidadDeBalonesRecuperados && Objects.equals(tipoDeDefensa, defensa.tipoDeDefensa);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + cantidadDeAvancesInterrumpidos;
        result = 31 * result + cantidadDeBalonesRecuperados;
        result = 31 * result + Objects.hashCode(tipoDeDefensa);
        return result;
    }
}
