import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by raffennn on 10/05/2016.
 */
public class Client extends UnicastRemoteObject implements Abonne {

    private Client() throws RemoteException {
    }

    public static void main(String [] args) throws Exception {
        //TODO main client

        //recup serveur
        //abonnement au serveur
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 3000);
        ServiceInfos service;
        service = (ServiceInfos) registry.lookup("InfoTrafic");
        final Client client = new Client();
        service.abonner(client);

    }

    @Override
    public void informer(InfoTrafic info) {
        System.out.println(info.toString());
    }
}
