import java.rmi.Remote;

public interface Hello extends Remote {
    String sayHello() throws java.rmi.RemoteException;
}
