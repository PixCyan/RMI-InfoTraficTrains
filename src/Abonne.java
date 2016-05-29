import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by raffennn on 10/05/2016.
 */
public interface Abonne extends Remote {
    public void informer(InfoTrafic info) throws RemoteException;


}
