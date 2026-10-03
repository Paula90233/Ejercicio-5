
public abstract class Modulo {
	protected int id;
	protected String nombre;
	protected double salud;
	protected boolean activo;
	protected double costoconstru;
	
	public Modulo(int id, String nombre, double salud, boolean activo, double costoconstru) {
		this.id = id;
		this.nombre = nombre;
		this.salud = salud;
		this.activo = activo;
		this.costoconstru = costoconstru;
	}

	public void setId(int newid) {
		this.id = newid;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNombre(String newnombre) {
		this.nombre = newnombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setSalud(double newsalud) {
		this.salud = newsalud;
	}
	
	public double getSalud() {
		return this.salud;
	}
	
	public void setActivo(boolean newactivo) {
		this.activo = newactivo;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public void setCostoconstru(double newcostoconstru) {
		this.costoconstru = newcostoconstru;
	}
	
	public double getCostoConstru() {
		return this.costoconstru;
	}
	
	public String toString() {
		return "ID: " + this.id + ", Nombre: " + this.nombre + ", Salud: " + this.salud + ", Activo: " + this.activo + ", Costo Construcción: " + this.costoconstru;
	}
	
	public abstract String procesarCiclo(Mision mision);
}
