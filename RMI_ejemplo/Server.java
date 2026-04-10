import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {

    public Server() {}

    public String sayHello() {
        return "Hello, world!";
    }

    public static void main(String[] args) {
        try {
            Server obj = new Server();

            // Exportar objeto remoto
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // habia un problema con getRegistry, para eso lo soluciono creando manualmente el registry.
            Registry registry = LocateRegistry.createRegistry(1099);

            // Registrar objeto con nombre "Hello"
            registry.bind("Hello", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}