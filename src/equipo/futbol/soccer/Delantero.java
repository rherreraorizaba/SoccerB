package equipo.futbol.soccer;

public class Delantero extends Jugador{

    private int cantidadDeRemates;
    private float velocidadPromedioTiro;

    public Delantero(String nombre,int edad,int numeroDeCamiseta){
        super(nombre,edad,numeroDeCamiseta);
        this.cantidadDeRemates = 0;
        this.velocidadPromedioTiro = 0;
    }
    public void realizarRemate(float velocidadDeRemate){
        this.cantidadDeRemates++;
        this.velocidadPromedioTiro = (this.velocidadPromedioTiro+velocidadDeRemate)/this.cantidadDeRemates;
    }

    public int getCantidadDeRemates() {
        return cantidadDeRemates;
    }

    public float getVelocidadPromedioTiro() {
        return velocidadPromedioTiro;
    }
    public float getPromedioDeGolesEsperados(){
        return super.getGolesAnotados()/(float)super.getPartidosJugados();
    }

    @Override
    public String toString() {
        return "Delantero{" +
                super.toString() +
                "cantidadDeRemates=" + cantidadDeRemates +
                ", velocidadPromedioTiro=" + velocidadPromedioTiro +
                '}';
    }
}
