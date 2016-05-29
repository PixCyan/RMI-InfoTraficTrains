import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by raffennn on 10/05/2016.
 */
public interface ServiceInfos extends Remote {
    public boolean abonner(Abonne a) throws RemoteException;
    public void desabonner(Abonne a) throws RemoteException;
    public boolean estAbonne(Abonne a) throws RemoteException;
}
