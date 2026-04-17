package equipo.futbol.soccer;

import equipo.futbol.excepciones.ExcepcionDeEdadFueraDeLimites;

import java.util.Comparator;

public class Portero extends Jugador{
    private int estatura;
    private int cantidadDeGolesRecibidos;
    private int cantidadDePartidosSinGol;


    public static Comparator<Portero> comparator = new Comparator<Portero>() {
        @Override
        public int compare(Portero o1, Portero o2) {
            return o1.compareTo(o2);
        }
    };

    public Portero(String nombre, int edad, int numeroDeCamiseta, int estatura) throws ExcepcionDeEdadFueraDeLimites {
        super(nombre, edad, numeroDeCamiseta);
        this.estatura = estatura;
        this.cantidadDeGolesRecibidos = 0;
        this.cantidadDePartidosSinGol = 0;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public int getCantidadDeGolesRecibidos() {
        return cantidadDeGolesRecibidos;
    }

    public int getCantidadDePartidosSinGol() {
        return cantidadDePartidosSinGol;
    }

    public void recibeGol(){
        this.cantidadDeGolesRecibidos++;
    }

    public void partidoSinGol(){
        if(this.cantidadDePartidosSinGol <this.getPartidosJugados())
              this.cantidadDePartidosSinGol++;
    }

    @Override
    public String toString() {
        return "Portero{" +
                super.toString() +
                "estatura=" + estatura +
                ", cantidadDeGolesRecibidos=" + cantidadDeGolesRecibidos +
                ", cantidadDePartidosSinGol=" + cantidadDePartidosSinGol +
                '}';
    }



    public int compareTo(Portero o) {
        int r=0;
        if((r=super.compareTo(o))!=0)
            return r;
        if((r=estatura-o.estatura)!=0)
            return r;
        if((r=cantidadDeGolesRecibidos-o.cantidadDeGolesRecibidos)!=0)
            return r;
        return cantidadDePartidosSinGol-o.cantidadDePartidosSinGol;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Portero portero)) return false;
        if (!super.equals(o)) return false;

        return estatura == portero.estatura && cantidadDeGolesRecibidos == portero.cantidadDeGolesRecibidos && cantidadDePartidosSinGol == portero.cantidadDePartidosSinGol;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + estatura;
        result = 31 * result + cantidadDeGolesRecibidos;
        result = 31 * result + cantidadDePartidosSinGol;
        return result;
    }
}
