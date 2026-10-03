import java.util.ArrayList;

public class Controlador {
    private Mision mision;
    private Vista vista;

    public Controlador() {
        mision = new Mision();
        vista = new Vista();
        mision.agregarModulo(new Moduloenergia(1,"Panel Solar A", 100, true, 5000, 20, 0, 0));
        mision.agregarModulo(new Modulovuelo(2,"Camara Orbital", 100, true, 8000, "Camara",15, 0, 0, 8));
        mision.agregarModulo(new Modulotierra(3,"Antena Guatemala",100,true,6500,10,0,"Estacion Guatemala",5));
        mision.agregarModulo(new Moduloenergia(4,"Panel Solar B",100,true,4500,15, 0, 0));
        mision.agregarModulo(new Modulovuelo(5,"Sensor Atmosferico",95,true,7500,"Sensor",10,0, 0, 6));
        mision.agregarModulo(new Modulotierra(6,"Antena Central",100,true,7000,15,0,"Estacion Central",7));
        mision.agregarModulo(new Moduloenergia(7,"Panel Solar C",100,true,6000,25, 0, 0));
        mision.agregarModulo(new Modulovuelo(8,"Camara Quetzal",100,true,9000,"Camara",20,0,0,10));
        mision.agregarModulo(new Modulotierra(9,"Antena Norte",85,true,5500,8,0,"Estacion Norte",4));
        mision.agregarModulo(new Modulovuelo(10,"Sensor Solar", 90, true,7000,"Sensor",12,0,0,7));
    }

    public void inicio() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();
            if (opcion == 1) {
                listarMod();
            } 
			else if (opcion == 2) {
                buscarMod();
            } 
			else if (opcion == 3) {
                mostrarCatalogo();
            } 
			else if (opcion == 4) {
                avanzarCiclo();
            } 
			else if (opcion == 5) {
                resumen();
            } 
			else if (opcion == 0) {
                salir = true;
                vista.mostrarMensaje("FIN");
            } 
			else {
                vista.mostrarMensaje("Opción inválida.");
            }
        }
    }

    public void listarMod() {
        vista.mostrarModulos(mision.getModulos());
    }

    public void buscarMod() {
        System.out.println(" BUSCAR MÓDULO ");
        System.out.println("1. Buscar por ID");
        System.out.println("2. Buscar por nombre");
        int opcion = vista.leerOpcion();
        if (opcion == 1) {
            int id = vista.leerEntero("Ingrese el ID: ");
            Modulo modulo = mision.buscarId(id);
            vista.mostrarModulo(modulo);
        } 
		else if (opcion == 2) {
            String nombre = vista.leerTexto("Ingrese el nombre: ");
            Modulo modulo = mision.buscarNombre(nombre);
            vista.mostrarModulo(modulo);
        } 
		else {
            vista.mostrarMensaje("Opción inválida.");
        }
    }

    public void mostrarCatalogo() {
        ArrayList<Modulo> modulos = mision.getModulosOrdenadosCosto(); 
        System.out.println(" CATÁLOGO ORDENADO POR COSTO ");
        for (Modulo modulo : modulos) {
            System.out.println(
                    "ID: "
                    + modulo.getId()
                    + " | Nombre: "
                    + modulo.getNombre()
                    + " | Costo: "
                    + modulo.getCostoConstru()
            );
        }
    }

    public void avanzarCiclo() {
        ArrayList<String> resultados = mision.avanzarCiclo();
		vista.mostrarResultadoCiclos(resultados);
    }

    public void resumen() {
        vista.mostrarResumen();
        System.out.println("Cantidad total de módulos de tierra: " + mision.totalModTierra());
        System.out.println("Cantidad de módulos de tierra activos: " + mision.totalModTierraActivos());
        System.out.println("Capacidad total de descarga por ciclo: " + mision.capacidadDescargActiva() + " MB");
        System.out.println("Total histórico de datos descargados: " + mision.totalDatosDescarg() + " MB");
        System.out.println("Módulo(s) de tierra con mayor " + "cantidad histórica descargada:");
        ArrayList<Modulotierra> mayores = mision.getModuloTierraMayorDesc();
        for (Modulotierra tierra : mayores) {
            System.out.println(
                    "Nombre: "
                    + tierra.getNombre()
                    + " | ID: "
                    + tierra.getId()
                    + " | Estación: "
                    + tierra.getEstacion()
                    + " | Total descargado: "
                    + tierra.getTotaldescarga()
                    + " MB"
            );
        }
    }
}
