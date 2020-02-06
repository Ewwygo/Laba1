package server;

import services.Example;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Example {

    @Override
    public String alphabet(String str) throws RemoteException {
        boolean cyr = false;
        boolean lat = false;
        for (char a : str.toCharArray()
             ) {
            if (Character.UnicodeBlock.of(a) == Character.UnicodeBlock.CYRILLIC) cyr = true;
            if (Character.UnicodeBlock.of(a) == Character.UnicodeBlock.BASIC_LATIN) lat = true;
        }
        if (lat==true && cyr==true){
            return "Latin and Cyrillic";
        } else if (lat){
            return "Latin";
        } else if (cyr){
            return "Cyrillic";
        } else return "None of two";
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            Example stub = (Example) UnicastRemoteObject.exportObject(server,0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Example",stub);
            System.out.println("Server rdy");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
