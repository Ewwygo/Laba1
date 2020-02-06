package client;

import services.Example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            Example stub = (Example) registry.lookup("Example");
            String response = stub.alphabet(str);
            System.out.println(response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
