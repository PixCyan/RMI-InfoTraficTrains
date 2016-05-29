import javax.print.DocFlavor;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import static java.lang.Thread.sleep;

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
        System.out.println(client.commandesDispo());
        boolean continuer = true;
        Scanner scan = new Scanner(System.in);
        while(continuer) {
            String entree = scan.nextLine();
            if(entree.equals("abonner")) {
                if(service.estAbonne(client)) {
                    System.out.println("Vous êtes déjà abonné(e).");
                } else {
                    service.abonner(client);
                    System.out.println("Vous êtes maintenant abonné(e).");
                }
            } else if(entree.equals("stop")) {
                if(service.estAbonne(client)) {
                    service.desabonner(client);
                    System.out.println("Vous êtes maintenant desabonné(e).");
                } else {
                    System.out.println("Vous n'êtes actuellement pas abonné(e).");
                }
            } else if(entree.equals("exit")) {
                service.desabonner(client);
                System.out.println("Fermeture.");
                continuer = false;
                System.exit(0);
            }
        }
    }

    @Override
    public void informer(InfoTrafic info) {
        System.out.println(info.toString());
    }

    public String commandesDispo() {
        return "---------- Commandes disponibles ----------- \n"
                + "S'abonner : abonner \n"
                + "Se désabonner : stop \n"
                + "Quitter : exit \n"
                + "------------------------------------------ \n";
    }
}
