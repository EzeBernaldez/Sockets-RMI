import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    public static int calcularPrecio(String tipo){
        String tipo_aux = tipo.toLowerCase();

        if (tipo_aux.equals("platea")){
            return 10000;
        }
        else{
            if (tipo_aux.equals("preferencial")){
                return 7000;
            }
            else{
                if (tipo_aux.equals("general")){
                    return 3000;
                }
                else{
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);

            VentaInterface stub = (VentaInterface) registry.lookup("Ventas");

            Scanner input = new Scanner(System.in);
            int opcion;

            do { 
                System.out.println("----------All access----------");
                System.err.println("1. Registrar venta.");
                System.err.println("2. Ver ventas.");
                System.err.println("3. Salir");
                opcion = input.nextInt();
                input.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Nombre");
                        String nombre = input.nextLine();
                        System.out.println("Documento");
                        String documento = input.nextLine();
                        System.out.println("Tipo (Platea, General, Preferencial).");
                        String tipo = input.nextLine();
                        int precio;
                        while ((precio = calcularPrecio(tipo)) == -1){
                            System.out.println("Debe ingresar el tipo correcto: Platea / General / Preferencial");
                            tipo = input.nextLine(); 
                        }

                        Venta v = new Venta(nombre, documento, tipo, precio);

                        stub.registrarVenta(v);
                        break;
                    case 2:
                        List<Venta> lista = stub.obtenerVentas();

                        System.out.println("-----------Ventas Completadas---------");
                        for (Venta venta : lista){
                            System.out.println(venta);
                        }
                        break;
                    
                    case 3:
                        System.out.println("Saliendo....");
                    default:
                        System.err.println("Opcion invalida");;
                }

            } while (opcion != 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}