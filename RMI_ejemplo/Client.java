import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client(){}
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            // Conectar al registro
            Registry registry = LocateRegistry.getRegistry(host);

            // Buscar objeto remoto por su nombre ("Hello")
            // Es vital hacer el cast a la interfaz 'Hello'
            Hello stub = (Hello) registry.lookup("Hello");

            // Invocar método remoto
            String response = stub.sayHello();

            System.out.println("Respuesta: " + response);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();

        }
    }
}