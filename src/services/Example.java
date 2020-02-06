package services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Example extends Remote {

    String alphabet(String str) throws RemoteException;
}
