import java.util.ArrayList;

public class Mision {
	private ArrayList<Modulo> modulos;
	private double energiadisponible;
	private double datosorbita;
	private double datosdescargados;
	private int ciclostranscurridos;

	public Mision() {
		modulos = new ArrayList<Modulo>();
		energiadisponible = 10;
		datosorbita = 0;
		datosdescargados = 0;
		ciclostranscurridos = 0;
	}

	public void agregarModulo(Modulo modulo) {
		modulos.add(modulo);
	}
	
	public Modulo buscarId(int id) {
		Modulo encontrado = null;
		for (Modulo modulo : modulos){
			if (modulo.getId() == id){
				encontrado = modulo;
				break;
			}
		}
		return encontrado;
	}
	
	public Modulo buscarNombre(String nombre) {
		Modulo encontrado = null;
		for (Modulo modulo : modulos){
			if (modulo.getNombre().equalsIgnoreCase(nombre)){
				encontrado = modulo;
				break;
			}
		}
		return encontrado;
	}
	
	public ArrayList<String> avanzarCiclo() {
		ArrayList<String> resultados = new ArrayList<String>();
        ciclostranscurridos++;
        resultados.add(" CICLO "+ ciclostranscurridos + " \n");
        int orden = 1;
		for (Modulo modulo : modulos) {
            String resultado = modulo.procesarCiclo(this);
            resultados.add(orden + ". " + resultado + "\n   Energía disponible: " + energiadisponible + "\n   Datos en órbita: " + datosorbita + " MB" + "\n   Datos descargados: " + datosdescargados + " MB");
            orden++;
		}
		resultados.add(" FIN DEL CICLO ");
		resultados.add("Energía disponible: " + energiadisponible);
        resultados.add("Datos en órbita: " + datosorbita + " MB");
        resultados.add("Datos descargados: " + datosdescargados + " MB");
		return resultados;
	}
	
	public int totalModTierra() {
		int total = 0;
		for (Modulo modulo : modulos){
			if (modulo instanceof Modulotierra){
				total++;
			}
		}
		return total;
	}
	
	public int totalModTierraActivos() {
		int total = 0;
		for (Modulo modulo : modulos){
			if (modulo instanceof Modulotierra && modulo.getActivo()){
				total++;
			}
		}
		return total;
	}
	
	public double capacidadDescargActiva() {
		double total = 0;
		for (Modulo modulo : modulos){
			if(modulo instanceof Modulotierra && modulo.getActivo()){
				Modulotierra tierra = (Modulotierra) modulo;
				total += tierra.getCapacidaddescarga();
			}
		}
		return total;
	}
	
	public ArrayList<Modulotierra> getModuloTierraMayorDesc() {
		ArrayList<Modulotierra> mayores = new ArrayList<Modulotierra>();
		double mayor = -1;
		for (Modulo modulo : modulos){
			if(modulo instanceof Modulotierra){
				Modulotierra tierra = (Modulotierra) modulo;
				if(tierra.getTotaldescarga() > mayor){
					mayor = tierra.getTotaldescarga();
					mayores.clear();
					mayores.add(tierra);
				}
				else if(tierra.getTotaldescarga() == mayor){
					mayores.add(tierra);
				}
			}
		}
		return mayores;
	}
	
	public ArrayList<Modulo> getModulosOrdenadosCosto() {
		ArrayList<Modulo> ordenados = new ArrayList<Modulo>(modulos);
		for (int i = 0; i < ordenados.size() - 1; i++) {
			for (int j = 0; j < ordenados.size() - i - 1; j++) {
				if (ordenados.get(j).getCostoConstru() > ordenados.get(j + 1).getCostoConstru()) {
					Modulo temp = ordenados.get(j);
					ordenados.set(j, ordenados.get(j + 1));
					ordenados.set(j + 1, temp);
				}
			}
		}
		return ordenados;
	}
	
	public double totalDatosDescarg() {
		return datosdescargados;
	}
	
	public void generarEnergia(double cantidad) {
		energiadisponible += cantidad;
	}
	
	public boolean consumirEnergia(double cantidad) {
		boolean pudoConsumir = false;
		if (energiadisponible >= cantidad) {
			energiadisponible -= cantidad;
			return true;
		}
		return pudoConsumir;
	}
	
	public boolean consumirEnergiaTemporal(double cantidad) {
        boolean suficiente = false;
        if (energiadisponible >= cantidad) {
            suficiente = true;
        }
        return suficiente;
    }

	public void agregarDatosOrbita(double cantidad) {
		datosorbita += cantidad;

	}
	
	public void descargarDatos(double cantidad) {
		if (cantidad > datosorbita) {
            cantidad = datosorbita;
        }
        datosorbita -= cantidad;
        datosdescargados += cantidad;
    }

	public double getEnergiaDisponible() {
        return energiadisponible;
    }

    public double getDatosOrbita() {
        return datosorbita;
    }

    public ArrayList<Modulo> getModulos() {
        return modulos;
    }
}
