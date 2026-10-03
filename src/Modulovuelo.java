
public class Modulovuelo extends Modulo {
	private String tipo;
	private double datosciclo;
	private int ciclosacumulados;
	private double datosrecolectados;
	private double consumoenergia;

	public Modulovuelo(int id, String nombre, double salud, boolean activo, double costoconstru, String tipo, double datosciclo, int ciclosacumulados, double datosrecolectados, double consumoenergia) {
		super(id, nombre, salud, activo, costoconstru);
		this.tipo = tipo;
		this.datosciclo = datosciclo;
		this.ciclosacumulados = 0;
		this.datosrecolectados = 0;
		this.consumoenergia = consumoenergia;
	}

	@Override
	public String procesarCiclo(Mision mision) {
		String resultado;
		if (!this.activo){
			resultado = nombre + "Módulo inactivo.";
		}
		else if (!mision.consumirEnergia(this.consumoenergia)){
			resultado = nombre + "Energía insuficiente.";
		}
		else {
			mision.agregarDatosOrbita(this.datosciclo);
			this.datosrecolectados += this.datosciclo;
			this.ciclosacumulados++;
			resultado = nombre + "Consume " + this.consumoenergia + "unidades de energía, y recolecta " + this.datosciclo + "MB"; 
		}
		return resultado;
	}

	@Override
	public String toString() {
		return super.toString() + "\nTipo: " + this.tipo + "\nDatos por ciclo: " + this.datosciclo + "\nCiclos acumulados: " + this.ciclosacumulados + "\nDatos recolectados: " + this.datosrecolectados + "\nConsumo de energía: " + this.consumoenergia;
	}
	
}
