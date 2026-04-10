import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Servidor implements VentaInterface {

    private List<Venta> ventas = new ArrayList<>();

    public Servidor() throws RemoteException{
        super();
    }

    public void registrarVenta(Venta v) throws RemoteException {
        ventas.add(v);
        System.out.println("Venta registrada: " + v);
    }

    public List<Venta> obtenerVentas() throws RemoteException {
        return ventas;
    }

    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor();

            VentaInterface stub = (VentaInterface) UnicastRemoteObject.exportObject(servidor, 0);

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.bind("Ventas", stub);

            System.out.println("Server ready");

        } catch (Exception e) {
            System.err.println("Server error: "+ e.toString());
            e.printStackTrace();
            
        }
    }


}

