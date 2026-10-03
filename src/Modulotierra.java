
public class Modulotierra extends Modulo {
	private double capacidaddescarga;
	private double totaldescarga;
	private String estacion;
	private double consumoenergia;

	public Modulotierra(int id, String nombre, double salud, boolean activo, double costoconstru, double capacidaddescarga, double totaldescarga, String estacion, double consumoenergia) {
		super(id, nombre, salud, activo, costoconstru);
		this.capacidaddescarga = capacidaddescarga;
		this.totaldescarga = 0;
		this.estacion = estacion;
		this.consumoenergia = consumoenergia;
	}

	public String procesarCiclo(Mision mision) {
		String resultado;
		if (!this.activo){
			resultado = nombre + "Módulo inactivo.";
		}
		else if (!mision.consumirEnergiaTemporal(this.consumoenergia)){
			resultado = nombre + "Energía insuficiente.";
		}
		else if (mision.getDatosOrbita() <= 0){
			resultado = nombre + "No hay datos pendientes en órbita.";
		}
		else {
			double cantidad;
			if (mision.getDatosOrbita() < this.capacidaddescarga){
				cantidad = mision.getDatosOrbita();
			}
			else {
				cantidad = this.capacidaddescarga;
			}
			mision.consumirEnergia(this.consumoenergia);
			mision.descargarDatos(cantidad);
			totaldescarga += cantidad;
			resultado = nombre + "consume " + this.consumoenergia + "unidades de energía, y descarga " + cantidad + "MB";
		}
		return resultado;
	}
	
	public String toString() {
		return super.toString() + "\nCapacidad de descarga: " + this.capacidaddescarga + "\nTotal descargado: " + this.totaldescarga + "\nEstación: " + this.estacion + "\nConsumo de energía: " + this.consumoenergia;
	}
	
	public double getCapacidaddescarga() {
    	return this.capacidaddescarga;
	}

	public double getTotaldescarga() {
    	return this.totaldescarga;
	}

	public String getEstacion() {
    	return this.estacion;
	}
}
