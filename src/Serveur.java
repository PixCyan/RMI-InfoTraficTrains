import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

import static java.lang.Thread.sleep;

/**
 * Created by raffennn on 10/05/2016.
 */
public class Serveur implements ServiceInfos {
    private static LinkedList<Abonne> clients = new LinkedList<>();

    public static void main(String [] args) throws Exception {
       //TODO main serveur

        Serveur service = new Serveur();
        ServiceInfos stub;
        stub = (ServiceInfos) UnicastRemoteObject.exportObject(service,0);
        Registry registry = LocateRegistry.createRegistry(3000);
        registry.bind("InfoTrafic", stub);

        boolean fin =false;
        while(!fin) {
            sleep(5000);
            InfoTrafic infos = new InfoTrafic();
            for(Abonne c : clients) {
                c.informer(infos);
            }
        }
    }

    @Override
    public boolean abonner(Abonne a) {
        if(!clients.contains(a)) {
            clients.add(a);
        }
        return true;
    }

    @Override
    public void desabonner(Abonne a) {
        if(clients.contains(a)) {
            clients.remove(a);
        }
    }
}
