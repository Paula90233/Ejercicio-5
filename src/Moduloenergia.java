
public class Moduloenergia extends Modulo {
	private double energiaciclo;
	private int ciclosacumulados;
	private double energiagenerada;

	public Moduloenergia(int id, String nombre, double salud, boolean activo, double costoconstru, double energiaciclo, int ciclosacumulados, double energiagenerada) {
		super(id, nombre, salud, activo, costoconstru);
		this.energiaciclo = energiaciclo;
		this.ciclosacumulados = 0;
		this.energiagenerada = 0;
	}

	@Override
	public String procesarCiclo(Mision mision) {
		String resultado;
		if (!this.activo){
			resultado = nombre + "Módulo inactivo.";
		}
		else {
			mision.generarEnergia(this.energiaciclo);
			this.energiagenerada += this.energiaciclo;
			this.ciclosacumulados++;
			resultado = nombre + "Genera " + this.energiaciclo + "unidades de energía"; 
		}
		return resultado;
	}
	
	public String toString() {
		return super.toString() + "\nEnergía por ciclo: " + this.energiaciclo + "\nCiclos acumulados: " + this.ciclosacumulados + "\nEnergía generada: " + this.energiagenerada;
	}
}
