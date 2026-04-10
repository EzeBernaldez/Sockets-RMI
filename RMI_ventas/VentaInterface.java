import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface VentaInterface extends Remote {
    void registrarVenta(Venta v) throws RemoteException;
    List<Venta> obtenerVentas() throws RemoteException;
}