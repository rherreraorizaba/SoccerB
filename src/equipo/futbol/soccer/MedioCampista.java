package equipo.futbol.soccer;

public class MedioCampista extends Jugador{

    private int cantidadPasesCorrectos;
    private int cantidadPasesIncorrectos;
    private int cantidadDeAsistencias;


    public MedioCampista(String nombre, int edad, int numeroDeCamiseta) {
        super(nombre, edad, numeroDeCamiseta);
        this.cantidadPasesCorrectos = 0;
        this.cantidadPasesIncorrectos = 0;
        this.cantidadDeAsistencias = 0;
    }

    public int getCantidadPasesCorrectos() {
        return cantidadPasesCorrectos;
    }

    public int getCantidadPasesIncorrectos() {
        return cantidadPasesIncorrectos;
    }

    public int getCantidadDeAsistencias() {
        return cantidadDeAsistencias;
    }

    public int getTotalDePases(){
        return this.cantidadPasesCorrectos+this.cantidadPasesIncorrectos;
    }

    public void realizoPaseIncorrecto(){
        this.cantidadPasesIncorrectos++;
    }

    public void realizoPaseCorrecto(){
        this.cantidadPasesCorrectos++;
    }

    public void realizaAsistencia(){
        this.cantidadDeAsistencias++;
        this.realizoPaseCorrecto();
    }

    @Override
    public String toString() {
        return "MedioCampista{" +
                super.toString() +
                "cantidadPasesCorrectos=" + cantidadPasesCorrectos +
                ", cantidadPasesIncorrectos=" + cantidadPasesIncorrectos +
                ", cantidadDeAsistencias=" + cantidadDeAsistencias +
                '}';
    }
}
