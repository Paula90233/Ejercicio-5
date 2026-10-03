import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    private Scanner scanner;
    public Vista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("==============================");
        System.out.println("       DEFENSA DEL QUETZAL-2   ");
        System.out.println("==============================");
        System.out.println("1. Listar módulos");
        System.out.println("2. Buscar módulo");
        System.out.println("3. Mostrar catálogo por costo");
        System.out.println("4. Avanzar ciclo");
        System.out.println("5. Mostrar resumen");
        System.out.println("0. Salir");
    }

    public void mostrarModulos() {
        System.out.println(" MÓDULOS DE LA MISIÓN ");
    }

    public void mostrarModulos(ArrayList<Modulo> modulos) {
        System.out.println(" MÓDULOS DE LA MISIÓN ");
        for (Modulo modulo : modulos) {
            System.out.println(modulo);
        }
    }

    public void mostrarModulo() {
        System.out.println(" INFORMACIÓN DEL MÓDULO ");
    }

    public void mostrarModulo(Modulo modulo) {
        System.out.println(" INFORMACIÓN DEL MÓDULO ");
        if (modulo == null) {
            System.out.println("No se encontró el módulo.");
        } else {
            System.out.println(modulo);
        }
    }

    public void mostrarResultadoCiclos(ArrayList<String> resultados) {
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }

    public void mostrarResumen() {
        System.out.println(" RESUMEN DE COMUNICACIONES ");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int leerOpcion() {
        int opcion = -1;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            opcion = -1;
        }
        return opcion;
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
        return numero;
    }
}